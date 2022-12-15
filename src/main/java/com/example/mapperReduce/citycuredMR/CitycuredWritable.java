package com.example.mapperReduce.citycuredMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author Jasper
 * @version 1.0
 */
public class CitycuredWritable implements Writable {

    private String cityName;//城市名
    private Integer curedCount;//治愈人数

    public CitycuredWritable(String cityName, Integer curedCount) {
        this.cityName = cityName;
        this.curedCount = curedCount;
    }

    public CitycuredWritable() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(Integer curedCount) {
        this.curedCount = curedCount;
    }


    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(cityName);
        dataOutput.writeInt(curedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        cityName = dataInput.readUTF();
        curedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
