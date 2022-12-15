package com.example.mapperReduce.continent_deadMR;

import com.example.mapperReduce.continentMR.continentWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ContinentDeadReducer extends Reducer<Text, ContinentDeadWritable, Text, ContinentDeadWritable> {

    ContinentDeadWritable continentDeadWritable = new ContinentDeadWritable();

    @Override
    protected void reduce(Text key, Iterable<ContinentDeadWritable> values, Reducer<Text, ContinentDeadWritable, Text, ContinentDeadWritable>.Context context) throws IOException, InterruptedException {
        System.out.println("reduce已经运行了");

        int DeadCount = 0;
        for( ContinentDeadWritable value : values) {
            DeadCount += value.getDeadCount();
        }
        continentDeadWritable.setContinents(String.valueOf(key));
        continentDeadWritable.setDeadCount(DeadCount);
        context.write(null, continentDeadWritable);

    }
}
