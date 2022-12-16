package com.example.mapperReduce.timeDataMR;

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
public class TimeDataMapper extends Mapper<LongWritable, Text, Text, Text> {

    Text text = new Text();
    Text text1 = new Text();
    TimeDataWritable timeDataWritable = new TimeDataWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
        String string = JSON.toJSONString(covidBean.getStatisticsData());
        text.set(covidBean.getProvinceShortName());
        text1.set(covidBean.getStatisticsData());
//        text1.set(string);
        context.write(text, text1);
    }

    //    @Override
//    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, TimeDataWritable>.Context context) throws IOException, InterruptedException {
//        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
////        System.out.println("line:" + line);
//        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
//        text.set(covidBean.getProvinceShortName());
////        timeDataWritable.setProvinceShortName(covidBean.getProvinceShortName());
//        timeDataWritable.setStatisticsData(covidBean.getStatisticsData());
////        System.out.println("省份短名：" + covidBean.getProvinceShortName());
////        System.out.println("数据为:" + covidBean.getStatisticsData());
//        context.write(text, timeDataWritable);
//        System.out.println("写入成功了");
//    }
}
