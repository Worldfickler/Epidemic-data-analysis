package com.example.mapperReduce.importMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class ImportReducer extends Reducer<Text, ImportWritable, Text, ImportWritable> {

    ImportWritable importWritable = new ImportWritable();

    @Override
    protected void reduce(Text key, Iterable<ImportWritable> values, Reducer<Text, ImportWritable, Text, ImportWritable>.Context context) throws IOException, InterruptedException {
        int confirmedCount = 0;
        for (ImportWritable value : values) {
            confirmedCount += value.getConfirmedCount();
        }
        importWritable.setProvinceShortName(String.valueOf(key));
        importWritable.setConfirmedCount(confirmedCount);
        context.write(null, importWritable);
    }
}
