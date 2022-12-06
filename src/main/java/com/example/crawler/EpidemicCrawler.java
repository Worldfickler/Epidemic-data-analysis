package com.example.crawler;

import com.alibaba.fastjson.JSON;
import com.example.bean.EpidemicBean;
import com.example.utils.HdfsUtil;
import com.example.utils.HttpUtils;
import com.example.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dell
 * @version 1.0
 */

public class EpidemicCrawler {

    @Autowired
    public HdfsUtil hdfsUtil;

    @Test
    public void test() throws Exception {
        boolean is_mkdir = hdfsUtil.mkdir("/xiyou");
        System.out.println(is_mkdir);
    }

    @Test
    public void Crawler() throws Exception {

        //在hdfs上创建文件
        boolean is_mkdir = hdfsUtil.mkdir("/bigdata");

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
        //将json转换为javabean(省份信息)
        List<EpidemicBean> province_epidemicBeans = JSON.parseArray(jsonStr, EpidemicBean.class);

    }

}
