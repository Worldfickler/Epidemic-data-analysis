package com.example.test;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 * KEYIN，map阶段输入的key类型：LongWritable
 * VALUEIN，map阶段输入value的类型：Text
 * KEYOUT，map阶段输出的key类型：Text
 * VALUEOUT，map阶段输出的value类型：IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    Text text = new Text();
    IntWritable intWritable = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        //获取一行
        String string = value.toString();
        System.out.println(string);
        //切割
        String[] split = string.split(" ");
        //循环写入
        for(String word : split){
            //封装
            text.set(word);
            //写出
            context.write(text, intWritable);
        }

    }
}

