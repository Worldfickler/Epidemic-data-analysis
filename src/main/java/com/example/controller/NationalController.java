package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.bean.National;
import com.example.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
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

    @Autowired
    test Test;

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

    /**
     * 全国疫情汇总信息
     * @return
     */
    @RequestMapping("getNationalData")
    public Result getNationData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/national_output/part-r-00000"));
        String readLine = bufferedReader.readLine();
        System.out.println("读取的数据" + readLine);
        List<National> nationals = new ArrayList<>();
        while (readLine != null) {
            System.out.println("test......");
            JSONObject jsonObject = JSON.parseObject(readLine);
            System.out.println("json格式数据" + jsonObject);
            National national = JSON.parseObject(String.valueOf(jsonObject), National.class);
            System.out.println("javabean格式数据" + national);
            nationals.add(national);
            readLine = bufferedReader.readLine();
        }
        System.out.println("list格式数据" + nationals);
        National national = nationals.get(0);
        System.out.println("sssss" + national);
        Map<String, Object> map = object2Map(national);
//        JSONObject jsonObject = JSON.parseObject(String.valueOf(national));
//        Map<String, Object> map = JSON.parseObject(String.valueOf(jsonObject), Map.class);
        Result result = Result.success(map);
        return result;
    }

}
