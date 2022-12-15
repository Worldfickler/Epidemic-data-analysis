package com.example.bean;

import org.apache.hadoop.io.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CountryBean implements Writable {

    private Integer id;//每个地区的id
    private String continents;//大陆名称
    private String provinceName;//国家名称
    private Integer currentConfirmedCount;//当前确诊人数
    private Integer country_curedCount;//治愈人数
    private Integer country_deadCount;//死亡人数
    private Integer country_suspectedCount;//疑似病例
    private String countryShortCode;//国家简称

    public CountryBean() {
    }
    //序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeUTF(continents);
        dataOutput.writeUTF(provinceName);
        dataOutput.writeInt(currentConfirmedCount);
        dataOutput.writeInt(country_curedCount);
        dataOutput.writeInt(country_deadCount);
        dataOutput.writeInt(country_suspectedCount);
        dataOutput.writeUTF(countryShortCode);

    }
    //反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.continents = dataInput.readUTF();
        this.provinceName = dataInput.readUTF();
        this.currentConfirmedCount = dataInput.readInt();
        this.country_curedCount = dataInput.readInt();
        this.country_deadCount = dataInput.readInt();
        this.country_suspectedCount = dataInput.readInt();
        this.countryShortCode = dataInput.readUTF();
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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public Integer getCountry_curedCount() {
        return country_curedCount;
    }

    public void setCountry_curedCount(Integer country_curedCount) {
        this.country_curedCount = country_curedCount;
    }

    public Integer getCountry_deadCount() {
        return country_deadCount;
    }

    public void setCountry_deadCount(Integer country_deadCount) {
        this.country_deadCount = country_deadCount;
    }

    public Integer getCountry_suspectedCount() {
        return country_suspectedCount;
    }

    public void setCountry_suspectedCount(Integer country_suspectedCount) {
        this.country_suspectedCount = country_suspectedCount;
    }

    public String getCountryShortCode() {
        return countryShortCode;
    }

    public void setCountryShortCode(String countryShortCode) {
        this.countryShortCode = countryShortCode;
    }

    @Override
    public String toString() {
        return "CountryBean{" +
                "country_id=" + id +
                ",continents='" + continents + '\'' +
                ", countryName='" +provinceName + '\'' +
                ", country_currentConfirmedCount=" + currentConfirmedCount +
                ", country_curedCount=" + country_curedCount +
                ", country_deadCount=" + country_deadCount +
                ", country_suspectedCount=" + country_suspectedCount +
                ", countryShortCode='" + countryShortCode + '\'' +
                '}';
    }


}
