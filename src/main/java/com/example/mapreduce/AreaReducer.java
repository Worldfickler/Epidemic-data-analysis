package com.example.mapreduce;

import com.example.bean.AreaBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class AreaReducer extends Reducer<Text, AreaBean, Text, AreaBean> {

    private AreaBean outV = new AreaBean();

    @Override
    protected void reduce(Text key, Iterable<AreaBean> values, Reducer<Text, AreaBean, Text, AreaBean>.Context context) throws IOException, InterruptedException {

        //遍历集合累加值输出
        long city_confirmedCount = 0;
        long city_suspectedCount = 0;
        long city_curedCount = 0;
        long city_deadCount = 0;
        for (AreaBean value : values) {
            city_confirmedCount += value.getCity_confirmedCount();
            city_suspectedCount += value.getCity_suspectedCount();
            city_curedCount += value.getCity_curedCount();
            city_deadCount += value.getCity_deadCount();
        }

        outV.setCity_zipCode(key);
        outV.setCity_confirmedCount(city_confirmedCount);
        outV.setCity_suspectedCount(city_suspectedCount);
        outV.setCity_curedCount(city_curedCount);
        outV.setCity_deadCount(city_deadCount);

        context.write(null, outV);

    }
}
