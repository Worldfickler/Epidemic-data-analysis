package com.example.mapperReduce.curedMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CuredReducer extends Reducer<Text, CuredWritable, Text, CuredWritable> {

    CuredWritable curedWritable = new CuredWritable();

    @Override
    protected void reduce(Text key, Iterable<CuredWritable> values, Reducer<Text, CuredWritable, Text, CuredWritable>.Context context) throws IOException, InterruptedException {
        int curedCount = 0;
        for (CuredWritable value : values) {
            curedCount += value.getCuredCount();
        }
        curedWritable.setProvinceShortName(String.valueOf(key));
        curedWritable.setCuredCount(curedCount);
        context.write(null, curedWritable);
    }
}
