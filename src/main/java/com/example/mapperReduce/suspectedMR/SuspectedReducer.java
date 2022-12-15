package com.example.mapperReduce.suspectedMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class SuspectedReducer extends Reducer<Text, SuspectedWritable, Text, SuspectedWritable> {

    SuspectedWritable suspectedWritable = new SuspectedWritable();

    @Override
    protected void reduce(Text key, Iterable<SuspectedWritable> values, Reducer<Text, SuspectedWritable, Text, SuspectedWritable>.Context context) throws IOException, InterruptedException {
        int suspectedCount = 0;
        for (SuspectedWritable value : values) {
            suspectedCount += value.getSuspectedCount();
        }
        suspectedWritable.setProvinceShortName(String.valueOf(key));
        suspectedWritable.setSuspectedCount(suspectedCount);
        context.write(null, suspectedWritable);
    }
}
