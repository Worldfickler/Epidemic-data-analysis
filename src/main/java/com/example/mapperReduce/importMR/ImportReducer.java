package com.example.mapperReduce.importMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class ImportReducer extends Reducer<ImportWritable, Text, Text, ImportWritable> {

    ImportWritable importWritable = new ImportWritable();

    @Override
    protected void reduce(ImportWritable key, Iterable<Text> values, Reducer<ImportWritable, Text, Text, ImportWritable>.Context context) throws IOException, InterruptedException {
        System.out.println("进入reduce");
//        int confirmedCount = 0;
//        for (Text value : values) {
//            if (value.getCityName().equals("境外输入")) confirmedCount += value.getConfirmedCount();
//        }
//        importWritable.setProvinceShortName(String.valueOf(key));
//        importWritable.setConfirmedCount(confirmedCount);
//        context.write(null, importWritable);
        for (Text value : values) {
            context.write(null, key);
        }
    }
}
