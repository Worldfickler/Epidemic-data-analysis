package com.example.mapreduce;

import com.example.bean.AreaBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class AreaMapper extends Mapper<LongWritable, Text, Text, AreaBean> {

    private Text outK = new Text();
    private AreaBean outV = new AreaBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, AreaBean>.Context context) throws IOException, InterruptedException {

        String string = value.toString();
        System.out.println(string);
        String[] split = string.split(",");

        //抓取想要的数据
        String city_zipCode = split[14];
        String city_confirmedCount = split[15];
        String city_suspectedCount = split[16];
        String city_curedCount = split[17];
        String city_deadCount = split[18];

        //封装
        outK.set(city_zipCode);
        outV.setCity_confirmedCount(Long.parseLong(city_confirmedCount));
        outV.setCity_suspectedCount(Long.parseLong(city_suspectedCount));
        outV.setCity_curedCount(Long.parseLong(city_curedCount));
        outV.setCity_deadCount(Long.parseLong(city_deadCount));
        //写出
        context.write(outK, outV);

    }
}
