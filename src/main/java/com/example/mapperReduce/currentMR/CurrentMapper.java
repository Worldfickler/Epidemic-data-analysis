package com.example.mapperReduce.currentMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CovidBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CurrentMapper extends Mapper<LongWritable, Text, Text, CurrentWritable> {

    Text text = new Text();
    CurrentWritable currentWritable = new CurrentWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CurrentWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
        text.set(covidBean.getProvinceShortName());
        currentWritable.setProvinceShortName(covidBean.getProvinceShortName());
        currentWritable.setCurrentConfirmedCount(covidBean.getCurrentConfirmedCount());
        context.write(text, currentWritable);
    }
}
