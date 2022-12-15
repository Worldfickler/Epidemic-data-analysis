package com.example.mapperReduce.confirmedMR;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class ConfirmedReducer extends Reducer<Text, ConfirmedWritable, Text, ConfirmedWritable> {

    ConfirmedWritable confirmedWritable = new ConfirmedWritable();

    @Override
    protected void reduce(Text key, Iterable<ConfirmedWritable> values, Reducer<Text, ConfirmedWritable, Text, ConfirmedWritable>.Context context) throws IOException, InterruptedException {
        System.out.println("reduce执行");
        int confirmedCount = 0;
        for (ConfirmedWritable value : values) {
            confirmedCount += value.getConfirmedCount();
        }
        confirmedWritable.setProvinceShortName(String.valueOf(key));
        confirmedWritable.setConfirmedCount(confirmedCount);
        context.write(null, confirmedWritable);
    }
}
