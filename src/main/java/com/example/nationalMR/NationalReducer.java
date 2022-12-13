package com.example.nationalMR;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class NationalReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    IntWritable intWritable = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        System.out.println("reduce已经运行了");

        int sum = 0;
        for (IntWritable value : values) {
            System.out.println("sum的值为" + sum);
            sum += value.get();
        }
        intWritable.set(sum);
        context.write(key, intWritable);

    }
}
