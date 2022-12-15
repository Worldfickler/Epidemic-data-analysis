package com.example.mapperReduce.continentMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CountryBean;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class continentMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    Text text = new Text();
    IntWritable intWritable = new IntWritable();
    CountryBean countryBean = new CountryBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        countryBean = JSON.parseObject(String.valueOf(value),CountryBean.class);
        System.out.println("废物过聚会");
        System.out.println(countryBean);
        text.set("currentConfirmedCount");
        intWritable.set(countryBean. getCurrentConfirmedCount());
        context.write(text, intWritable);
    }
}

