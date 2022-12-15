package com.example.mapperReduce.timeDataMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class TimeDataWritable implements Writable {

    private String provinceShortName;//省份短名
    private String statisticsData;//省份内的时间信息

    public TimeDataWritable() {
    }

    public TimeDataWritable(String provinceShortName, String statisticsData) {
        this.provinceShortName = provinceShortName;
        this.statisticsData = statisticsData;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public String getStatisticsData() {
        return statisticsData;
    }

    public void setStatisticsData(String statisticsData) {
        this.statisticsData = statisticsData;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(provinceShortName);
        dataOutput.writeUTF(statisticsData);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        provinceShortName = dataInput.readUTF();
        statisticsData = dataInput.readUTF();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
