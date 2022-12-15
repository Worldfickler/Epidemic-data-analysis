package com.example.mapperReduce.currentMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CurrentReducer extends Reducer<Text, CurrentWritable, Text, CurrentWritable> {

    CurrentWritable currentWritable = new CurrentWritable();

    @Override
    protected void reduce(Text key, Iterable<CurrentWritable> values, Reducer<Text, CurrentWritable, Text, CurrentWritable>.Context context) throws IOException, InterruptedException {
        int currentCount = 0;
        for (CurrentWritable value : values) {
            currentCount += value.getCurrentConfirmedCount();
        }
        currentWritable.setProvinceShortName(String.valueOf(key));
        currentWritable.setCurrentConfirmedCount(currentCount);
        context.write(null, currentWritable);
    }
}
