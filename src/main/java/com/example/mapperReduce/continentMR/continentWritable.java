package com.example.mapperReduce.continentMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class continentWritable implements Writable {

    private String provinceShortName;//省份短名
    private Integer confirmedCount;//累计确诊人数
}
