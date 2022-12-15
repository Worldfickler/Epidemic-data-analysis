package com.example.mapperReduce.importMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class ImportWritable implements WritableComparable<ImportWritable> {

    private String cityName;
    private String provinceShortName;
    private Integer confirmedCount;

    public ImportWritable() {
    }

    public ImportWritable(String cityName, String provinceShortName, Integer confirmedCount) {
        this.cityName = cityName;
        this.provinceShortName = provinceShortName;
        this.confirmedCount = confirmedCount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
    public int compareTo(ImportWritable o) {
        int confirmedCount;
        confirmedCount = Integer.compare(o.getConfirmedCount(), this.confirmedCount);
        if(confirmedCount == 0){
            confirmedCount = this.confirmedCount > o.getConfirmedCount() ? -1 : 1;
        }
        return confirmedCount;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
