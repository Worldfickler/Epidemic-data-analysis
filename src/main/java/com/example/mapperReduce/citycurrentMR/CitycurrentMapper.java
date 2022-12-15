package com.example.mapperReduce.citycurrentMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CityBean;
import com.example.bean.CovidBean;
import com.example.mapperReduce.currentMR.CurrentWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Jasper
 * @version 1.0
 */
public class CitycurrentMapper extends Mapper<LongWritable, Text, Text, CitycurrentWritable> {

    Text text = new Text();
    CitycurrentWritable citycurrentWritable = new CitycurrentWritable();
    CityBean cityBean = new CityBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CitycurrentWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"UTF-8");
        cityBean = JSON.parseObject(String.valueOf(line), CityBean.class);
        text.set(cityBean.getCityName());
        citycurrentWritable.setCityName(cityBean.getCityName());
        citycurrentWritable.setCurrentConfirmedCount(cityBean.getCurrentConfirmedCount());
        context.write(text, citycurrentWritable);
    }
}
