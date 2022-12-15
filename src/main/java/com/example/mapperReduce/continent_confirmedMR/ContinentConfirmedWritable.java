package com.example.mapperReduce.continent_confirmedMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ContinentConfirmedWritable implements Writable {
    private String continents;//大洲名称
    private Integer currentConfirmedCount;//当前确诊人数

    public ContinentConfirmedWritable() {
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(continents);
        dataOutput.writeInt(currentConfirmedCount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.continents = dataInput.readUTF();
        this.currentConfirmedCount = dataInput.readInt();
    }


    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

