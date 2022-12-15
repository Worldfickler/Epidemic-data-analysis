package com.example.mapperReduce.confirmedMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class ConfirmedWritable implements Writable {

    private String provinceShortName;//省份短名
    private Integer confirmedCount;//累计确诊人数

    public ConfirmedWritable(String provinceShortName, Integer confirmedCount) {
        this.provinceShortName = provinceShortName;
        this.confirmedCount = confirmedCount;
    }

    public ConfirmedWritable() {
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public Integer getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(provinceShortName);
        dataOutput.writeInt(confirmedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        provinceShortName = dataInput.readUTF();
        confirmedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
