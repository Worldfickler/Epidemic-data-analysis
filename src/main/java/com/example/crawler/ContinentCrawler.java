package com.example.crawler;

import com.alibaba.fastjson2.JSON;
import com.example.bean.Country;
import com.example.utils.HttpUtils;
import com.example.utils.TimeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dell
 * @version 1.0
 */
public class ContinentCrawler {

    public static void main(String[] args) throws IOException {

        BufferedWriter country_bufferedWriter = new BufferedWriter(new FileWriter("data/country_epidemic.txt"));

        String datetime = TimeUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");

        String html = HttpUtils.getHtml("https://ncov.dxy.cn/ncovh5/view/pneumonia");

        Document doc = Jsoup.parse(html);
        String text = doc.select("script[id=getListByCountryTypeService2true]").toString();

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

        List<Country> countries = JSON.parseArray(jsonStr, Country.class);
        for (Country country : countries) {
            String countryStr = JSON.toJSONString(country);
            System.out.println(countryStr);
            country_bufferedWriter.write(countryStr);
            country_bufferedWriter.newLine();
            country_bufferedWriter.flush();
        }
        country_bufferedWriter.close();

    }

}
