package com.example.mapperReduce.continentMR;

import com.example.bean.CountryBean;
import com.example.mapperReduce.confirmedMR.ConfirmedWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class continentReducer extends Reducer<Text, continentWritable, Text, continentWritable> {

    continentWritable continentWritable = new continentWritable();

    @Override
    protected void reduce(Text key, Iterable<continentWritable> values, Reducer<Text, continentWritable, Text, continentWritable>.Context context) throws IOException, InterruptedException {

        System.out.println("reduce已经运行了");

        int confirmedCount = 0;
        for( continentWritable value : values) {
            confirmedCount += value.getCurrentConfirmedCount();
        }
        continentWritable.setCountryShortCode(String.valueOf(key));
        continentWritable.setCurrentConfirmedCount(confirmedCount);
        context.write(null, continentWritable);

    }
}
