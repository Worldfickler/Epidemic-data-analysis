package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
@RequestMapping("covid")
public class NationalController {

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
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

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
                if (field.getName().equals("provinceShortName")) map.put("name", field.get(obj));
                else map.put("value", field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 全国疫情信息汇总
     * @return
     * @throws IOException
     */
    @RequestMapping("getNationalData")
    public Result getNationData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/national_output/part-r-00000"));
        String readLine = bufferedReader.readLine();
//        System.out.println("读取的数据" + readLine);
        List<National> nationals = new ArrayList<>();
        while (readLine != null) {
//            System.out.println("test......");
            JSONObject jsonObject = JSON.parseObject(readLine);
//            System.out.println("json格式数据" + jsonObject);
            National national = JSON.parseObject(String.valueOf(jsonObject), National.class);
//            System.out.println("javabean格式数据" + national);
            nationals.add(national);
            readLine = bufferedReader.readLine();
        }
//        System.out.println("list格式数据" + nationals);
        National national = nationals.get(0);
//        System.out.println("sssss" + national);
        Map<String, Object> map = object2Map(national);
//        JSONObject jsonObject = JSON.parseObject(String.valueOf(national));
//        Map<String, Object> map = JSON.parseObject(String.valueOf(jsonObject), Map.class);
        Result result = Result.success(map);
        return result;
    }

    /**
     * 全国累积确诊人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getNationalConfirmedMapData")
    public Result getNationalConfirmedMapData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/confirmed_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
//        System.out.println("line的数据为:" + readLine);
        List<Map<String, Object>> confirmeds = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Confirmed confirmed = JSON.parseObject(String.valueOf(jsonObject), Confirmed.class);
            Map<String, Object> map = object1Map(confirmed);
//            System.out.println("map的数据为:" + map);
            confirmeds.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(confirmeds);
        return result;
    }

    /**
     * 全国现存确诊人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getNationalCurrentConfirmedCountMapData")
    public Result getNationalCurrentConfirmedCountMapData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/current_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
//        System.out.println("line的数据为:" + readLine);
        List<Map<String, Object>> currents = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Current current = JSON.parseObject(String.valueOf(jsonObject), Current.class);
            Map<String, Object> map = object1Map(current);
//            System.out.println("map的数据为:" + map);
            currents.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(currents);
        return result;
    }

    /**
     * 全国治愈人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getNationalCuredCountMapData")
    public Result getNationalCuredCountMapData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/cured_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> cureds = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Cured cured = JSON.parseObject(String.valueOf(jsonObject), Cured.class);
            Map<String, Object> map = object1Map(cured);
            cureds.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(cureds);
        return result;
    }

    /**
     * 全国死亡人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getNationalDeadCountMapData")
    public Result getNationalDeadCountMapData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/dead_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> deads = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Dead dead = JSON.parseObject(String.valueOf(jsonObject), Dead.class);
            Map<String, Object> map = object1Map(dead);
            deads.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(deads);
        return result;
    }

    /**
     * 全国疑似人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getNationalSuspectedCountMapData")
    public Result getNationalSuspectedCountMapData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/suspected_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> suspecteds = new ArrayList<>();
        while (readLine != null) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Suspected suspected = JSON.parseObject(String.valueOf(jsonObject), Suspected.class);
            Map<String, Object> map = object1Map(suspected);
            suspecteds.add(map);
            readLine = bufferedReader.readLine();
        }
        Result result = Result.success(suspecteds);
        return result;
    }

    /**
     * 境外输入
     * @return
     * @throws IOException
     */
    @RequestMapping("getCovidImportData")
    public Result getCovidImportData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/city_import_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> imports = new ArrayList<>();
        int count = 1;
        while (readLine != null && count <= 10) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            Import anImport = JSON.parseObject(String.valueOf(jsonObject), Import.class);
            Map<String, Object> map = object1Map(anImport);
            imports.add(map);
            readLine = bufferedReader.readLine();
            count ++ ;
        }
        Result result = Result.success(imports);
        return result;
    }

}
