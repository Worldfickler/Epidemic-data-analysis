package com.example.mapperReduce.importMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CityBean;
import com.example.bean.CovidBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class ImportMapper extends Mapper<LongWritable, Text, Text, ImportWritable> {

    Text text = new Text();
    ImportWritable importWritable = new ImportWritable();
    CityBean cityBean = new CityBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, ImportWritable>.Context context) throws IOException, InterruptedException {
        String line = new String(value.getBytes(),0,value.getLength(),"GBK");
        cityBean = JSON.parseObject(String.valueOf(line), CityBean.class);
        text.set(cityBean.getProvinceShortName());
        importWritable.setProvinceShortName(cityBean.getProvinceShortName());
        importWritable.setConfirmedCount(cityBean.getConfirmedCount());
        context.write(text, importWritable);
    }
}
