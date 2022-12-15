package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.bean.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dell
 * @version 1.0
 */

@RestController//返回的数据格式为json格式
@RequestMapping("country")
public class CountryController {

    public static Map<String, Object> object1Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
//                map.put(field.getName(), field.get(obj));
                if (field.getName().equals("countryShortCode")) map.put("name", field.get(obj));
                else map.put("value", field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
//                map.put(field.getName(), field.get(obj));
                if (field.getName().equals("continents")) map.put("name", field.get(obj));
                else map.put("value", field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 全球确诊人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getCurrentConfirmedCount")
    public Result getCurrentConfirmedCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/country_confirmedCount_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> list = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Continent continent = JSON.parseObject(String.valueOf(jsonObject), Continent.class);
            Map<String, Object> map = object1Map(continent);
//            System.out.println("map的数据为:" + map);
            list.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(list);
        return result;
    }

    /**
     * 全球治愈人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getCuredCount")
    public Result getCuredCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/country_cured_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> list = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            CountryCure countryCure = JSON.parseObject(String.valueOf(jsonObject), CountryCure.class);
            Map<String, Object> map = object1Map(countryCure);
//            System.out.println("map的数据为:" + map);
            list.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(list);
        return result;
        }

    /**
     * 各大洲死亡人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getDeadCount")
    public Result getDeadCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/continent_DeadCount_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> list = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            ContinentDead continentDead = JSON.parseObject(String.valueOf(jsonObject), ContinentDead.class);
            Map<String, Object> map = object2Map(continentDead);
//            System.out.println("map的数据为:" + map);
            list.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(list);
        return result;
    }

    /**
     * 各大洲累计感染人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getContinentConfirmedCount")
    public Result getContinentConfirmedCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/continent_Confirmed_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> list = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            ContinentConfirmed continentConfirmed = JSON.parseObject(String.valueOf(jsonObject), ContinentConfirmed.class);
            Map<String, Object> map = object2Map(continentConfirmed);
//            System.out.println("map的数据为:" + map);
            list.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(list);
        return result;
    }
}
