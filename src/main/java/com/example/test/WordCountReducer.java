package com.example.test;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 * KEYIN，reduce阶段输入的key类型：Text
 * VALUEIN，reduce阶段输入value的类型：IntWritable
 * KEYOUT，reduce阶段输出的key类型：Text
 * VALUEOUT，reduce阶段输出的value类型：IntWritable
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    IntWritable intWritable = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        int sum = 0;
        //累加
        for (IntWritable value : values) {
            sum += value.get();
        }

        intWritable.set(sum);

        //写出
        context.write(key, intWritable);

    }
}

