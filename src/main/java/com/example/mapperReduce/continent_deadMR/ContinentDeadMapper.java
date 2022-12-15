package com.example.mapperReduce.continent_deadMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CountryBean;
import com.example.bean.CovidBean;
import com.example.mapperReduce.continentMR.continentWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ContinentDeadMapper extends Mapper<LongWritable, Text, Text, ContinentDeadWritable> {
    Text text = new Text();
    ContinentDeadWritable continentDeadWritable = new ContinentDeadWritable();
    CountryBean countryBean = new CountryBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text,ContinentDeadWritable>.Context context) throws IOException, InterruptedException {

        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
//        System.out.println("转换后的格式" + line);
        countryBean = JSON.parseObject(String.valueOf(line), CountryBean.class);


        text.set(countryBean.getContinents());
        continentDeadWritable.setContinents(countryBean.getContinents());
        continentDeadWritable.setDeadCount(countryBean.getDeadCount());
        context.write(text, continentDeadWritable);

    }
}
