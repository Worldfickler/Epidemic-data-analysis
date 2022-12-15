package com.example.mapperReduce.nationalMR;

import com.alibaba.fastjson.JSON;
import com.example.bean.CovidBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class NationalMapper extends Mapper<LongWritable, Text, Text, NationalWritable> {

    Text text = new Text();
    NationalWritable nationalWritable = new NationalWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NationalWritable>.Context context) throws IOException, InterruptedException {
        covidBean = JSON.parseObject(String.valueOf(value), CovidBean.class);
        text.set(covidBean.getDatetime());
        nationalWritable.setDatetime(covidBean.getDatetime());
        nationalWritable.setCurrentConfirmedCount(covidBean.getCurrentConfirmedCount());
        nationalWritable.setConfirmedCount(covidBean.getConfirmedCount());
        nationalWritable.setSuspectedCount(covidBean.getSuspectedCount());
        nationalWritable.setCuredCount(covidBean.getCuredCount());
        nationalWritable.setDeadCount(covidBean.getDeadCount());
        context.write(text, nationalWritable);
    }

    //    @Override
//    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
//        covidBean = JSON.parseObject(String.valueOf(value), CovidBean.class);
//        text.set("currentConfirmedCount");
//        intWritable.set(covidBean.getCurrentConfirmedCount());
//        context.write(text, intWritable);
//        text.set("confirmedCount");
//        intWritable.set(covidBean.getConfirmedCount());
//        context.write(text, intWritable);
////        System.out.println("现存确诊人数" + covidBean.getConfirmedCount());
//        text.set("suspectedCount");
//        intWritable.set(covidBean.getSuspectedCount());
//        context.write(text, intWritable);
//        text.set("curedCount");
//        intWritable.set(covidBean.getCuredCount());
//        context.write(text, intWritable);
//        text.set("deadCount");
//        intWritable.set(covidBean.getDeadCount());
//        context.write(text, intWritable);
//    }
}
