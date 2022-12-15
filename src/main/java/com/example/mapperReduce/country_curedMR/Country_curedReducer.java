package com.example.mapperReduce.country_curedMR;

import com.example.mapperReduce.continentMR.continentWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Country_curedReducer extends Reducer<Text, Country_curedWritable, Text, Country_curedWritable> {
    Country_curedWritable country_curedWritable = new Country_curedWritable();

    @Override
    protected void reduce(Text key, Iterable<Country_curedWritable> values, Reducer<Text, Country_curedWritable, Text, Country_curedWritable>.Context context) throws IOException, InterruptedException {

        System.out.println("reduce已经运行了");

        int curedCount = 0;
        for( Country_curedWritable value : values) {
            curedCount += value.getCuredCount();
        }
        country_curedWritable.setCountryShortCode(String.valueOf(key));
        country_curedWritable.setCuredCount(curedCount);
        context.write(null, country_curedWritable);

    }
}
