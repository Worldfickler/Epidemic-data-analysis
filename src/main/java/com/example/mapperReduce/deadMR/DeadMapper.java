package com.example.mapperReduce.deadMR;

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
public class DeadMapper extends Mapper<LongWritable, Text, Text, DeadWritable> {

    Text text = new Text();
    DeadWritable deadWritable = new DeadWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, DeadWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
        text.set(covidBean.getProvinceShortName());
        deadWritable.setProvinceShortName(covidBean.getProvinceShortName());
        deadWritable.setDeadCount(covidBean.getDeadCount());
        context.write(text, deadWritable);
    }
}
