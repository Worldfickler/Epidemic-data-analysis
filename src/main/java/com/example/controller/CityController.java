package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.bean.CityConfirmed;
import com.example.bean.Continent;
import com.example.bean.Result;
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
@RequestMapping("city")
public class CityController {

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
                if (field.getName().equals("cityName")) map.put("name", field.get(obj));
                else map.put("value", field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 市区确诊人数
     * @return
     * @throws IOException
     */
    @RequestMapping("getConfirmedCount")
    public Result getConfirmedCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/cityconfirmed_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        List<Map<String, Object>> list = new ArrayList<>();
        int count = 1;
        while (readLine != null && count <= 5) {
            JSONObject jsonObject = JSON.parseObject(readLine);
            CityConfirmed cityConfirmed = JSON.parseObject(String.valueOf(jsonObject), CityConfirmed.class);
            Map<String, Object> map = object1Map(cityConfirmed);
//            System.out.println("map的数据为:" + map);
            list.add(map);
            readLine = bufferedReader.readLine();
            count ++ ;
        }
        Result result = Result.success(list);
        return result;
    }

}
