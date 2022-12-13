package com.example.nationalMR;

import com.alibaba.fastjson.JSON;
import com.example.bean.CovidBean;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class NationalMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    Text text = new Text();
    IntWritable intWritable = new IntWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        covidBean = JSON.parseObject(String.valueOf(value), CovidBean.class);
        text.set("confirmedCount");
        System.out.println("现存确诊人数" + covidBean.getConfirmedCount());
        intWritable.set(covidBean.getConfirmedCount());
        context.write(text, intWritable);
    }
}
