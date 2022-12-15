package com.example.mapperReduce.confirmedMR;

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
public class ConfirmedMapper extends Mapper<LongWritable, Text, Text, ConfirmedWritable> {

    Text text = new Text();
    ConfirmedWritable confirmedWritable = new ConfirmedWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, ConfirmedWritable>.Context context) throws IOException, InterruptedException {
//        System.out.println("直接输出value" + value);
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
//        System.out.println("转换后的格式" + line);
        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
//        System.out.println("covidbean数据" + covidBean);
        text.set(covidBean.getProvinceShortName());
        confirmedWritable.setConfirmedCount(covidBean.getConfirmedCount());
        confirmedWritable.setProvinceShortName(covidBean.getProvinceShortName());
        System.out.println("mapper执行" + covidBean.getProvinceShortName() + "   " + covidBean.getConfirmedCount());

        System.out.println(text);
        System.out.println(confirmedWritable);
        context.write(text, confirmedWritable);
        System.out.println("成功写入");
    }
}
