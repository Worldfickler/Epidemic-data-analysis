package com.example.mapperReduce.citycurrentMR;

import com.example.mapperReduce.currentMR.CurrentWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Jasper
 * @version 1.0
 */
public class CitycurrentReducer extends Reducer<Text, CitycurrentWritable, Text, CitycurrentWritable> {

    CitycurrentWritable citycurrentWritable = new CitycurrentWritable();

    @Override
    protected void reduce(Text key, Iterable<CitycurrentWritable> values, Reducer<Text, CitycurrentWritable, Text, CitycurrentWritable>.Context context) throws IOException, InterruptedException {
        int currentCount = 0;
        for (CitycurrentWritable value : values) {
            currentCount += value.getCurrentConfirmedCount();
        }
        citycurrentWritable.setCityName(String.valueOf(key));
        citycurrentWritable.setCurrentConfirmedCount(currentCount);
        context.write(null, citycurrentWritable);
    }
}
