package com.example.mapperReduce.continentMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class continentWritable implements Writable {

    private String countryShortCode;//国家简称
    private Integer currentConfirmedCount;//当前确诊人数


    public continentWritable() {
    }

    public String getCountryShortCode() {
        return countryShortCode;
    }

    public void setCountryShortCode(String countryShortCode) {
        this.countryShortCode = countryShortCode;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(countryShortCode);
        dataOutput.writeInt(currentConfirmedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.countryShortCode = dataInput.readUTF();
        this.currentConfirmedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        return "continentWritable{" +
                "countryShortCode='" + countryShortCode + '\'' +
                ", currentConfirmedCount=" + currentConfirmedCount +
                '}';
    }
}
