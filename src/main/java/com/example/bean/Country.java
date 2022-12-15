package com.example.bean;

import org.apache.hadoop.io.Text;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    private Integer id;//每个地区的id
    private String continents;//大陆名称
    private String countryName;//国家名称
    private Integer currentConfirmedCount;//当前确诊人数
    private Integer curedCount;//治愈人数
    private Integer deadCount;//死亡人数
    private Integer suspectedCount;//疑似病例
    private String countryShortCode;//国家简称

//    public CountryBean() {
//    }
//    //序列化
//    @Override
//    public void write(DataOutput dataOutput) throws IOException {
//        dataOutput.writeInt(country_id);
//        dataOutput.writeUTF(continents);
//        dataOutput.writeUTF(countryName);
//        dataOutput.writeInt(country_currentConfirmedCount);
//        dataOutput.writeInt(country_curedCount);
//        dataOutput.writeInt(country_deadCount);
//        dataOutput.writeInt(country_suspectedCount);
//        dataOutput.writeUTF(countryShortCode);
//
//    }
//    //反序列化
//    @Override
//    public void readFields(DataInput dataInput) throws IOException {
//        this.country_id = dataInput.readInt();
//        this.continents = dataInput.readUTF();
//        this.countryName = dataInput.readUTF();
//        this.country_currentConfirmedCount = dataInput.readInt();
//        this.country_curedCount = dataInput.readInt();
//        this.country_deadCount = dataInput.readInt();
//        this.country_suspectedCount = dataInput.readInt();
//        this.countryShortCode = dataInput.readUTF();
//    }



//    public Integer getCountry_id() {
//        return country_id;
//    }
//
//    public void setCountry_id(Integer country_id) {
//        this.country_id = country_id;
//    }
//
//    public String getContinents() {
//        return continents;
//    }
//
//    public void setContinents(String continents) {
//        this.continents = continents;
//    }
//
//    public String getCountryName() {
//        return countryName;
//    }
//
//    public void setCountryName(String countryName) {
//        this.countryName = countryName;
//    }
//
//    public Integer getCountry_currentConfirmedCount() {
//        return country_currentConfirmedCount;
//    }
//
//    public void setCountry_currentConfirmedCount(Integer country_currentConfirmedCount) {
//        this.country_currentConfirmedCount = country_currentConfirmedCount;
//    }
//
//    public Integer getCountry_curedCount() {
//        return country_curedCount;
//    }
//
//    public void setCountry_curedCount(Integer country_curedCount) {
//        this.country_curedCount = country_curedCount;
//    }
//
//    public Integer getCountry_deadCount() {
//        return country_deadCount;
//    }
//
//    public void setCountry_deadCount(Integer country_deadCount) {
//        this.country_deadCount = country_deadCount;
//    }
//
//    public Integer getCountry_suspectedCount() {
//        return country_suspectedCount;
//    }
//
//    public void setCountry_suspectedCount(Integer country_suspectedCount) {
//        this.country_suspectedCount = country_suspectedCount;
//    }
//
//    public String getCountryShortCode() {
//        return countryShortCode;
//    }
//
//    public void setCountryShortCode(String countryShortCode) {
//        this.countryShortCode = countryShortCode;
//    }
//
//    @Override
//    public String toString() {
//        return "CountryBean{" +
//                "country_id=" + country_id +
//                ",continents='" + continents + '\'' +
//                ", countryName='" + countryName + '\'' +
//                ", country_currentConfirmedCount=" + country_currentConfirmedCount +
//                ", country_curedCount=" + country_curedCount +
//                ", country_deadCount=" + country_deadCount +
//                ", country_suspectedCount=" + country_suspectedCount +
//                ", countryShortCode='" + countryShortCode + '\'' +
//                '}';
//    }
}
