package com.example.mapperReduce.continentMR;

import com.example.mapperReduce.confirmedMR.ConfirmedWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class continentReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    IntWritable intWritable = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        System.out.println("reduce已经运行了");

        int confirmedCount = 0;
        for (ConfirmedWritable value : values) {
            confirmedCount += value.getConfirmedCount();
        }

        intWritable.set(confirmedCount);
        context.write(key, intWritable);

    }
}
