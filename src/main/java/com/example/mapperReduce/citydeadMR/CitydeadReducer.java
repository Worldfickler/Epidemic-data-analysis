package com.example.mapperReduce.citydeadMR;

import com.example.mapperReduce.deadMR.DeadWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CitydeadReducer extends Reducer<Text, CitydeadWritable, Text, CitydeadWritable> {

    CitydeadWritable citydeadWritable = new CitydeadWritable();

    @Override
    protected void reduce(Text key, Iterable<CitydeadWritable> values, Reducer<Text, CitydeadWritable, Text, CitydeadWritable>.Context context) throws IOException, InterruptedException {
        int deadCount = 0;
        for (CitydeadWritable value : values) {
            deadCount += value.getDeadCount();
        }
        citydeadWritable.setCityName(String.valueOf(key));
        citydeadWritable.setDeadCount(deadCount);
        context.write(null, citydeadWritable);
    }
}
