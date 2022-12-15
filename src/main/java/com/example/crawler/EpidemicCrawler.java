package com.example.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bean.EpidemicBean;
import com.example.utils.HttpUtils;
import com.example.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author dell
 * @version 1.0
 */

@Component
public class EpidemicCrawler {

//    @Test
    @Scheduled(initialDelay = 1000, fixedDelay = 1000 * 60 * 60 * 12)
    public void Crawler() throws Exception {

        System.out.println("定时任务开始执行了");

        //写入流
        BufferedWriter city_bufferedWriter = new BufferedWriter(new FileWriter("data/city_epidemic.txt"));
        BufferedWriter province_bufferedWriter = new BufferedWriter(new FileWriter("data/province_epidemic.txt"));

        //时间标志
        String datetime = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");

        //爬取的页面
        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");

        //解析页面中的指定内容-即id为getAreaStat的标签中的全国疫情数据
        Document doc = Jsoup.parse(html);
        String text = doc.select("script[id=getAreaStat]").toString();
//        System.out.println(text);

        //使用正则表达式获取json格式的数据
        String pattern = "\\[(.*)\\]";
        Pattern reg = Pattern.compile(pattern);
        Matcher matcher = reg.matcher(text);
        String jsonStr = "";
        if (matcher.find()) {
            jsonStr = matcher.group(0);
//            System.out.println(jsonStr);
        } else {
            System.out.println("NO MATCH");
        }

        //对json数据更进一步的解析
        //将json转换为javabean(便于后续的数据处理)
        List<EpidemicBean> province_epidemicBeans = JSON.parseArray(jsonStr, EpidemicBean.class);
        //全国各省份的信息
        for (EpidemicBean province_epidemicBean : province_epidemicBeans) {
//            System.out.println(province_epidemicBean);
            province_epidemicBean.setDatetime(datetime);//不知道为什么，json转成javabean，时间会变成null，这里只能手动设置
            //获取省份中的城市数据
            String cities = province_epidemicBean.getCities();
            //城市信息也是json格式数据，同样也要处理成javabean类型
            List<EpidemicBean> city_epidemicBeans = JSON.parseArray(cities, EpidemicBean.class);
            for (EpidemicBean city_epidemicBean : city_epidemicBeans) {
                city_epidemicBean.setDatetime(datetime);
                city_epidemicBean.setPid(province_epidemicBean.getLocationId());
                city_epidemicBean.setProvinceShortName(province_epidemicBean.getProvinceShortName());
//                System.out.println(city_epidemicBean);
//                city_bufferedWriter.write(String.valueOf(city_epidemicBean));
                //将javabean的数据重新转换为json格式的数据存储
                String city_str = JSON.toJSONString(city_epidemicBean);
                city_bufferedWriter.write(city_str);
                city_bufferedWriter.newLine();
                city_bufferedWriter.flush();
            }
            //获取json中每一天的统计数据
            String statisticsDataUrl = province_epidemicBean.getStatisticsData();
//            System.out.println(statisticsDataUrl);
            String statisticDataStr = HttpUtils.getHtml(statisticsDataUrl);
            //获取statisticDataStr中的data字段对应的数据
            JSONObject jsonObject = JSON.parseObject(statisticDataStr);
            String dataStr = jsonObject.getString("data");
//            System.out.println(dataStr);
            //将解析出来的数据重新放回到province_epidemicBean中的getStaticsData
            province_epidemicBean.setStatisticsData(dataStr);
            province_epidemicBean.setCities(null);
//            System.out.println(province_epidemicBean);
//            province_bufferedWriter.write(String.valueOf(province_bufferedWriter));
            //与城市的数据处理一样
            String province_str = JSON.toJSONString(province_epidemicBean);
            province_bufferedWriter.write(province_str);
            province_bufferedWriter.newLine();
            province_bufferedWriter.flush();
        }
        city_bufferedWriter.close();
        province_bufferedWriter.close();
    }

}
