package com.example.mapperReduce.timeDataMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CovidBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class TimeDataReducer extends Reducer<LongWritable, Text, Text, TimeDataWritable> {

    TimeDataWritable timeDataWritable = new TimeDataWritable();

    @Override
    protected void reduce(LongWritable key, Iterable<Text> values, Reducer<LongWritable, Text, Text, TimeDataWritable>.Context context) throws IOException, InterruptedException {
        timeDataWritable.setStatisticsData(String.valueOf(values));
        timeDataWritable.setProvinceShortName(String.valueOf(key));
        context.write(null, timeDataWritable);
    }
}
