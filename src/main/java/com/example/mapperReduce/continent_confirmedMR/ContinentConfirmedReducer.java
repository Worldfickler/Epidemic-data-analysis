package com.example.mapperReduce.continent_confirmedMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ContinentConfirmedReducer extends Reducer<Text,  ContinentConfirmedWritable, Text,  ContinentConfirmedWritable> {
    ContinentConfirmedWritable continentConfirmedWritable = new ContinentConfirmedWritable();

    @Override
    protected void reduce(Text key, Iterable<ContinentConfirmedWritable> values, Reducer<Text, ContinentConfirmedWritable, Text, ContinentConfirmedWritable>.Context context) throws IOException, InterruptedException {
        System.out.println("reduce已经运行了");

        int continentConfirmed = 0;
        for( ContinentConfirmedWritable value : values) {
            continentConfirmed += value.getCurrentConfirmedCount();
        }
        continentConfirmedWritable.setContinents(String.valueOf(key));
        continentConfirmedWritable.setCurrentConfirmedCount(continentConfirmed);
        context.write(null, continentConfirmedWritable);

    }
}

