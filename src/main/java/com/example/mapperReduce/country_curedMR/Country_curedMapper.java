package com.example.mapperReduce.country_curedMR;

import com.alibaba.fastjson2.JSON;
import com.example.bean.CountryBean;
import com.example.mapperReduce.continentMR.continentWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Country_curedMapper extends Mapper<LongWritable, Text, Text, Country_curedWritable> {
    Text text = new Text();
    Country_curedWritable country_curedWritable = new Country_curedWritable();
    CountryBean countryBean = new CountryBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Country_curedWritable>.Context context) throws IOException, InterruptedException {
        countryBean = JSON.parseObject(String.valueOf(value), CountryBean.class);


        text.set(countryBean.getCountryShortCode());
        country_curedWritable.setCountryShortCode(countryBean.getCountryShortCode());
        country_curedWritable.setCuredCount(countryBean.getCuredCount());
        context.write(text, country_curedWritable);

    }

}
