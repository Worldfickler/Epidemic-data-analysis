package com.example.mapperReduce.deadMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class DeadReducer extends Reducer<Text, DeadWritable, Text, DeadWritable> {

    DeadWritable deadWritable = new DeadWritable();

    @Override
    protected void reduce(Text key, Iterable<DeadWritable> values, Reducer<Text, DeadWritable, Text, DeadWritable>.Context context) throws IOException, InterruptedException {
        int deadCount = 0;
        for (DeadWritable value : values) {
            deadCount += value.getDeadCount();
        }
        deadWritable.setProvinceShortName(String.valueOf(key));
        deadWritable.setDeadCount(deadCount);
        context.write(null, deadWritable);
    }
}
