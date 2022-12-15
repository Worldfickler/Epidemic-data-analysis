package com.example.mapperReduce.timeDataMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author dell
 * @version 1.0
 */
public class TimeDataPartitioner extends Partitioner<Text, TimeDataWritable> {
    @Override
    public int getPartition(Text text, TimeDataWritable timeDataWritable, int i) {
        return 0;
    }
}
