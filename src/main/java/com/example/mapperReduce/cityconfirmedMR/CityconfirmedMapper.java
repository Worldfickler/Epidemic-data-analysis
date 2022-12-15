package com.example.mapperReduce.cityconfirmedMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CityBean;
import com.example.bean.CovidBean;
import com.example.mapperReduce.confirmedMR.ConfirmedWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CityconfirmedMapper extends Mapper<LongWritable, Text, Text, CityconfirmedWritable> {

    Text text = new Text();
    CityconfirmedWritable cityconfirmedWritable = new CityconfirmedWritable();
    CityBean cityBean = new CityBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CityconfirmedWritable>.Context context) throws IOException, InterruptedException {
        System.out.println("直接输出value" + value);
        String line = new String(value.getBytes(),0,value.getLength(),"UTF-8");
        System.out.println("转换后的格式" + line);
        cityBean = JSON.parseObject(String.valueOf(line), CityBean.class);
        System.out.println("citybean数据" + cityBean);
        text.set(cityBean.getCityName());
        cityconfirmedWritable.setCityconfirmedCount(cityBean.getConfirmedCount());
        cityconfirmedWritable.setCityName(cityBean.getCityName());
        System.out.println("mapper执行" + cityBean.getCityName()+ "   " + cityBean.getConfirmedCount());
        System.out.println(text);
        System.out.println(cityconfirmedWritable);
        context.write(text, cityconfirmedWritable);
        System.out.println("成功写入");
    }
}

