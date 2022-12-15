package com.example.mapperReduce.citycuredMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CityBean;
import com.example.mapperReduce.curedMR.CuredWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class CitycuredMapper extends Mapper<LongWritable, Text, Text, CitycuredWritable> {

    Text text = new Text();
    CitycuredWritable citycuredWritable = new CitycuredWritable();
    CityBean cityBean = new CityBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CitycuredWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"UTF-8");
        cityBean = JSON.parseObject(String.valueOf(line), CityBean.class);
        text.set(cityBean.getCityName());
        citycuredWritable.setCityName(cityBean.getCityName());
        citycuredWritable.setCuredCount(cityBean.getCuredCount());
        context.write(text, citycuredWritable);
    }
}
