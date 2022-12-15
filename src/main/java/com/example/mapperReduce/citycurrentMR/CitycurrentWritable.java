package com.example.mapperReduce.citycurrentMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author Jasper
 * @version 1.0
 */
public class CitycurrentWritable implements Writable {

    private String cityName;//城市名
    private Integer currentConfirmedCount;//治愈人数

    public CitycurrentWritable(String provinceShortName, Integer curedCount) {
        this.cityName = cityName;
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public CitycurrentWritable() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(cityName);
        dataOutput.writeInt(currentConfirmedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        cityName = dataInput.readUTF();
        currentConfirmedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
