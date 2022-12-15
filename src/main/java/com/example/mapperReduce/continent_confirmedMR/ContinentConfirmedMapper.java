package com.example.mapperReduce.continent_confirmedMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CountryBean;
import com.example.mapperReduce.continent_deadMR.ContinentDeadWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ContinentConfirmedMapper  extends Mapper<LongWritable, Text, Text, ContinentConfirmedWritable> {
    Text text = new Text();
    ContinentConfirmedWritable continentConfirmedWritable = new ContinentConfirmedWritable();
    CountryBean countryBean = new CountryBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text,ContinentConfirmedWritable>.Context context) throws IOException, InterruptedException {

        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
//        System.out.println("转换后的格式" + line);
        countryBean = JSON.parseObject(String.valueOf(line), CountryBean.class);

        text.set(countryBean.getContinents());
        continentConfirmedWritable.setContinents(countryBean.getContinents());
        continentConfirmedWritable.setCurrentConfirmedCount(countryBean.getCurrentConfirmedCount());
        context.write(text, continentConfirmedWritable);

    }
}
