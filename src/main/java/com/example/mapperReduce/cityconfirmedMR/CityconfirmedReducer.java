package com.example.mapperReduce.cityconfirmedMR;

import com.example.mapperReduce.confirmedMR.ConfirmedWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CityconfirmedReducer extends Reducer<Text, CityconfirmedWritable, Text, CityconfirmedWritable> {

    CityconfirmedWritable cityconfirmedWritable = new CityconfirmedWritable();

    @Override
    protected void reduce(Text key, Iterable<CityconfirmedWritable> values, Reducer<Text, CityconfirmedWritable, Text, CityconfirmedWritable>.Context context) throws IOException, InterruptedException {
        System.out.println("reduce执行");
        int confirmedCount = 0;
        for (CityconfirmedWritable value : values) {
            confirmedCount += value.getCityconfirmedCount();
        }
        cityconfirmedWritable.setCityName(String.valueOf(key));
        cityconfirmedWritable.setCityconfirmedCount(confirmedCount);
        context.write(null, cityconfirmedWritable);
    }
}