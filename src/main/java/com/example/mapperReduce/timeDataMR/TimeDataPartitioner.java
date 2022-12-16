package com.example.mapperReduce.timeDataMR;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author dell
 * @version 1.0
 */
public class TimeDataPartitioner extends Partitioner<Text, Text> {
    @Override
    public int getPartition(Text text, Text Text, int i) {
        String name = String.valueOf(text);
        int partition;
        if ("上海".equals(name)) partition = 0;
        else if ("云南".equals(name)) partition = 1;
        else if ("内蒙古".equals(name)) partition = 2;
        else if ("北京".equals(name)) partition = 3;
        else if ("台湾".equals(name)) partition = 4;
        else if ("吉林".equals(name)) partition = 5;
        else if ("四川".equals(name)) partition = 6;
        else if ("天津".equals(name)) partition = 7;
        else if ("宁夏".equals(name)) partition = 8;
        else if ("安徽".equals(name)) partition = 9;
        else if ("山东".equals(name)) partition = 10;
        else if ("山西".equals(name)) partition = 11;
        else if ("广东".equals(name)) partition = 12;
        else if ("广西".equals(name)) partition = 13;
        else if ("新疆".equals(name)) partition = 14;
        else if ("江苏".equals(name)) partition = 15;
        else if ("江西".equals(name)) partition = 16;
        else if ("河北".equals(name)) partition = 17;
        else if ("河南".equals(name)) partition = 18;
        else if ("浙江".equals(name)) partition = 19;
        else if ("海南".equals(name)) partition = 20;
        else if ("湖北".equals(name)) partition = 21;
        else if ("湖南".equals(name)) partition = 22;
        else if ("澳门".equals(name)) partition = 23;
        else if ("甘肃".equals(name)) partition = 24;
        else if ("福建".equals(name)) partition = 25;
        else if ("西藏".equals(name)) partition = 26;
        else if ("贵州".equals(name)) partition = 27;
        else if ("辽宁".equals(name)) partition = 28;
        else if ("重庆".equals(name)) partition = 29;
        else if ("陕西".equals(name)) partition = 30;
        else if ("青海".equals(name)) partition = 31;
        else if ("香港".equals(name)) partition = 32;
        else partition = 33;
        return partition;
    }
}
