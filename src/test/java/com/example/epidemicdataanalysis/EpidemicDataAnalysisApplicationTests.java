package com.example.epidemicdataanalysis;

import com.alibaba.fastjson.JSON;
import com.example.utils.HttpUtils;
import com.example.utils.TimeUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
class EpidemicDataAnalysisApplicationTests {

    private FileSystem fileSystem;

    @Test
    void contextLoads() throws Exception {

//        boolean is_mkdir = hdfsUtil.mkdir("/xiyou");
//        System.out.println(is_mkdir);

        BufferedWriter city_bufferedWriter = new BufferedWriter(new FileWriter("data/continent_epidemic.txt"));

        //时间标志
        String datetime = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");

        //爬取的页面
        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");

        //解析页面中的指定内容-即id为getAreaStat的标签中的全国疫情数据
        Document doc = Jsoup.parse(html);
        String text = doc.select("script[id=getListByCountryTypeService2true]").toString();//id=getListByCountryTypeService2true
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

    }

}
