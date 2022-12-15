package com.example.mapperReduce.nationalMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class NationalReducer extends Reducer<Text, NationalWritable, Text, NationalWritable> {

    NationalWritable nationalWritable = new NationalWritable();

    @Override
    protected void reduce(Text key, Iterable<NationalWritable> values, Reducer<Text, NationalWritable, Text, NationalWritable>.Context context) throws IOException, InterruptedException {
        int currentConfirmedCount = 0;
        int confirmedCount = 0;
        int suspectedCount = 0;
        int curedCount = 0;
        int deadCount = 0;
        for (NationalWritable value : values) {
            currentConfirmedCount += value.getCurrentConfirmedCount();
            confirmedCount += value.getConfirmedCount();
            suspectedCount += value.getSuspectedCount();
            curedCount += value.getCuredCount();
            deadCount += value.getDeadCount();
        }
        nationalWritable.setCurrentConfirmedCount(currentConfirmedCount);
        nationalWritable.setConfirmedCount(confirmedCount);
        nationalWritable.setSuspectedCount(suspectedCount);
        nationalWritable.setCuredCount(curedCount);
        nationalWritable.setDeadCount(deadCount);
        nationalWritable.setDatetime(String.valueOf(key));
        context.write(null, nationalWritable);
    }

    //    @Override
//    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
//
//        System.out.println("reduce已经运行了");
//
//        int sum = 0;
//        for (IntWritable value : values) {
//            System.out.println("sum的值为" + sum);
//            sum += value.get();
//        }
//        intWritable.set(sum);
//        context.write(null, intWritable);
//
//    }
}
