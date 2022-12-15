package com.example.mapperReduce.currentMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CurrentWritable implements Writable {

    private String provinceShortName;//省份短名
    private Integer curedCount;//治愈人数

    public CurrentWritable(String provinceShortName, Integer curedCount) {
        this.provinceShortName = provinceShortName;
        this.curedCount = curedCount;
    }

    public CurrentWritable() {
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public Integer getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(Integer curedCount) {
        this.curedCount = curedCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(provinceShortName);
        dataOutput.writeInt(curedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        provinceShortName = dataInput.readUTF();
        curedCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
