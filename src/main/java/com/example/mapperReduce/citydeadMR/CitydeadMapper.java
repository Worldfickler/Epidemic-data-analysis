package com.example.mapperReduce.citydeadMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CityBean;
import com.example.bean.CovidBean;
import com.example.mapperReduce.deadMR.DeadWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Jasper
 * @version 1.0
 */
public class CitydeadMapper extends Mapper<LongWritable, Text, Text, CitydeadWritable> {

    Text text = new Text();
    CitydeadWritable citydeadWritable = new CitydeadWritable();
    CityBean cityBean = new CityBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CitydeadWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"UTF-8");
        cityBean = JSON.parseObject(String.valueOf(line), CityBean.class);
        text.set(cityBean.getCityName());
        citydeadWritable.setCityName(cityBean.getProvinceShortName());
        citydeadWritable.setDeadCount(cityBean.getDeadCount());
        context.write(text, citydeadWritable);
    }
}
