package com.example.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.bean.Result;
import com.example.bean.TimeData;
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
@RequestMapping("timeData")
public class TimeDataController {

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
                if (field.getName().equals("confirmedCount")) map.put("累计确诊", field.get(obj));
                else if (field.getName().equals("confirmedIncr")) map.put("新增确诊", field.get(obj));
                else if (field.getName().equals("curedCount")) map.put("累计治愈", field.get(obj));
                else if (field.getName().equals("suspectedCount")) map.put("疑似病例", field.get(obj));
                else if (field.getName().equals("deadCount")) map.put("累计死亡", field.get(obj));
                else map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("getTimeData1")
    public Result getTimeData1() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/timeData_output/part-r-00000", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        String[] split = readLine.split("\t");
//        System.out.println("split的长度为:" + split.length);
//        System.out.println(split[0]);
//        System.out.println(split[1]);
        List<Map<String, Object>> imports = new ArrayList<>();
//        Object parse = JSON.parse(split[1]);
//        System.out.println("parse" + parse);
        List<TimeData> timeDatas = JSON.parseArray(split[1], TimeData.class);
        for (TimeData timeData : timeDatas) {
            Map<String, Object> map = object2Map(timeData);
            imports.add(map);
        }
        Result result = Result.success(imports);
//        JSONObject jsonObject = JSON.parseObject(split[1]);
//        System.out.println("json格式的数据为：" + jsonObject);
        return result;
    }

    @RequestMapping("getTimeData2")
    public Result getTimeData2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/timeData_output/part-r-00010", Charset.forName("UTF-8")));
        String readLine = bufferedReader.readLine();
        String[] split = readLine.split("\t");
//        System.out.println("split的长度为:" + split.length);
//        System.out.println(split[0]);
//        System.out.println(split[1]);
        List<Map<String, Object>> imports = new ArrayList<>();
//        Object parse = JSON.parse(split[1]);
//        System.out.println("parse" + parse);
        List<TimeData> timeDatas = JSON.parseArray(split[1], TimeData.class);
        for (TimeData timeData : timeDatas) {
            Map<String, Object> map = object2Map(timeData);
            imports.add(map);
        }
        Result result = Result.success(imports);
//        JSONObject jsonObject = JSON.parseObject(split[1]);
//        System.out.println("json格式的数据为：" + jsonObject);
        return result;
    }

}
