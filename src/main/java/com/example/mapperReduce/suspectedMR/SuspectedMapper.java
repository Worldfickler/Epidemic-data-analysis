package com.example.mapperReduce.suspectedMR;

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
public class SuspectedMapper extends Mapper<LongWritable, Text, Text, SuspectedWritable> {

    Text text = new Text();
    SuspectedWritable suspectedWritable = new SuspectedWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, SuspectedWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
        text.set(covidBean.getProvinceShortName());
        suspectedWritable.setProvinceShortName(covidBean.getProvinceShortName());
        suspectedWritable.setSuspectedCount(covidBean.getSuspectedCount());
        context.write(text, suspectedWritable);
    }
}
