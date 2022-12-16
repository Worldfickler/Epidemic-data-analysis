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
public class TimeDataReducer extends Reducer<Text, Text, Text, Text> {

    Text text = new Text();
    TimeDataWritable timeDataWritable = new TimeDataWritable();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            text.set(value);
        }
        context.write(key, text);
    }
}
