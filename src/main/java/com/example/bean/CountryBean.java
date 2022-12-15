package com.example.bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CountryBean implements Writable {

    private Integer id;//每个地区的id
    private String continents;//大陆名称
    private String countryName;//国家名称
    private Integer currentConfirmedCount;//当前确诊人数
    private Integer curedCount;//治愈人数
    private Integer deadCount;//死亡人数
    private Integer suspectedCount;//疑似病例
    private String countryShortCode;//国家简称

    public CountryBean() {
    }

    //序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeUTF(continents);
        dataOutput.writeUTF(countryName);
        dataOutput.writeInt(currentConfirmedCount);
        dataOutput.writeInt(curedCount);
        dataOutput.writeInt(deadCount);
        dataOutput.writeInt(suspectedCount);
        dataOutput.writeUTF(countryShortCode);

    }

    //反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.continents = dataInput.readUTF();
        this.countryName = dataInput.readUTF();
        this.currentConfirmedCount = dataInput.readInt();
        this.curedCount = dataInput.readInt();
        this.deadCount = dataInput.readInt();
        this.suspectedCount = dataInput.readInt();
        this.countryShortCode = dataInput.readUTF();
    }


    @Override
    public String toString() {
        return "CountryBean{" +
                "country_id=" + id +
                ",continents='" + continents + '\'' +
                ", countryName='" + countryName + '\'' +
                ", country_currentConfirmedCount=" + currentConfirmedCount +
                ", country_curedCount=" + curedCount +
                ", country_deadCount=" + deadCount +
                ", country_suspectedCount=" + suspectedCount +
                ", countryShortCode='" + countryShortCode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
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

    public Integer getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(Integer suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public String getCountryShortCode() {
        return countryShortCode;
    }

    public void setCountryShortCode(String countryShortCode) {
        this.countryShortCode = countryShortCode;
    }
}