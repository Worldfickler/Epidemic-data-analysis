package com.example.mapperReduce.curedMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CovidBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CuredMapper extends Mapper<LongWritable, Text, Text, CuredWritable> {

    Text text = new Text();
    CuredWritable curedWritable = new CuredWritable();
    CovidBean covidBean = new CovidBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, CuredWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
        covidBean = JSON.parseObject(String.valueOf(line), CovidBean.class);
        text.set(covidBean.getProvinceShortName());
        curedWritable.setProvinceShortName(covidBean.getProvinceShortName());
        curedWritable.setCuredCount(covidBean.getCuredCount());
        context.write(text, curedWritable);
    }
}
