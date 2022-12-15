package com.example.mapperReduce.citycuredMR;

import com.example.mapperReduce.curedMR.CuredWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author Jasper
 * @version 1.0
 */
public class CitycuredReducer extends Reducer<Text, CitycuredWritable, Text, CitycuredWritable> {

    CitycuredWritable citycuredWritable = new CitycuredWritable();

    @Override
    protected void reduce(Text key, Iterable<CitycuredWritable> values, Reducer<Text, CitycuredWritable, Text, CitycuredWritable>.Context context) throws IOException, InterruptedException {
        int curedCount = 0;
        for (CitycuredWritable value : values) {
            curedCount += value.getCuredCount();
        }
        citycuredWritable.setCityName(String.valueOf(key));
        citycuredWritable.setCuredCount(curedCount);
        context.write(null, citycuredWritable);
    }
}
