package com.example.mapperReduce.country_curedMR;

import org.apache.hadoop.io.Writable;
import com.google.gson.Gson;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
public class Country_curedWritable implements Writable {

    private String countryShortCode;//国家简称
    private Integer curedCount;//治愈人数

    public Country_curedWritable() {

    }

    public String getCountryShortCode() {
        return countryShortCode;
    }

    public void setCountryShortCode(String countryShortCode) {
        this.countryShortCode = countryShortCode;
    }

    public Integer getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(Integer curedCount) {
        this.curedCount = curedCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(countryShortCode);
        dataOutput.writeInt(curedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.countryShortCode = dataInput.readUTF();
        this.curedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        return "Country_curedWritable{" +
                "countryShortCode='" + countryShortCode + '\'' +
                ", curedCount=" + curedCount +
                '}';
    }
}
