package com.example.mapperReduce.continentMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.Country;
import com.example.bean.CountryBean;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class continentMapper extends Mapper<LongWritable, Text, Text, continentWritable> {
    Text text = new Text();
    continentWritable continentWritable = new continentWritable();
    CountryBean countryBean = new CountryBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, continentWritable>.Context context) throws IOException, InterruptedException {
        countryBean = JSON.parseObject(String.valueOf(value), CountryBean.class);


        text.set(countryBean.getCountryShortCode());
        continentWritable.setCountryShortCode(countryBean.getCountryShortCode());
        continentWritable.setCurrentConfirmedCount(countryBean.getCurrentConfirmedCount());
        context.write(text, continentWritable);

    }
}

