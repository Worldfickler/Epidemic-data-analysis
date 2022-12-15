package com.example.mapperReduce.nationalMR;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author dell
 * @version 1.0
 */

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class NationalWritable implements Writable {

    private String datetime;//时间
    private Integer currentConfirmedCount;//当前确诊人数
    private Integer confirmedCount;//累计确诊人数
    private Integer suspectedCount;//疑似病例人数
    private Integer curedCount;//治愈人数
    private Integer deadCount;//死亡人数

    public NationalWritable(String datetime, Integer currentConfirmedCount, Integer confirmedCount, Integer suspectedCount, Integer curedCount, Integer deadCount) {
        this.datetime = datetime;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
    }

    public NationalWritable() {
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public Integer getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public Integer getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(Integer suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public Integer getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(Integer curedCount) {
        this.curedCount = curedCount;
    }

    public Integer getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(Integer deadCount) {
        this.deadCount = deadCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(datetime);
        dataOutput.writeInt(currentConfirmedCount);
        dataOutput.writeInt(confirmedCount);
        dataOutput.writeInt(suspectedCount);
        dataOutput.writeInt(curedCount);
        dataOutput.writeInt(deadCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        datetime = dataInput.readUTF();
        currentConfirmedCount = dataInput.readInt();
        confirmedCount = dataInput.readInt();
        suspectedCount = dataInput.readInt();
        curedCount = dataInput.readInt();
        deadCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
