package com.example.mapperReduce.cityconfirmedMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class CityconfirmedWritable implements Writable {

    private String cityName; //城市名

    private Integer cityconfirmedCount;// 累计确诊人数

    public CityconfirmedWritable(String cityName,Integer cityconfirmedCount){
        this.cityName = cityName;
        this.cityconfirmedCount = cityconfirmedCount;
    }

    public CityconfirmedWritable(){
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityconfirmedCount() {
        return cityconfirmedCount;
    }

    public void setCityconfirmedCount(Integer cityconfirmedCount) {
        this.cityconfirmedCount = cityconfirmedCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(cityName);
        dataOutput.writeInt(cityconfirmedCount);
    }


    @Override
    public void readFields(DataInput dataInput) throws IOException {
        cityName = dataInput.readUTF();
        cityconfirmedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


}
