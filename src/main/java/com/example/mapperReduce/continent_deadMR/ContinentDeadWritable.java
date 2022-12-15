package com.example.mapperReduce.continent_deadMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ContinentDeadWritable implements Writable {

    private String continents;//国家简称
    private Integer deadCount;//当前确诊人数

    public ContinentDeadWritable() {
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public Integer getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(Integer deadCount) {
        this.deadCount = deadCount;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(continents);
        dataOutput.writeInt(deadCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.continents = dataInput.readUTF();
        this.deadCount = dataInput.readInt();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}

