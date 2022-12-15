package com.example.bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class CovidBean implements Writable {

    private String provinceName;//省份名称
    private String provinceShortName;//省份短名
    private String cityName;//城市名称
    private Integer currentConfirmedCount;//当前确诊人数
    private Integer confirmedCount;//累计确诊人数
    private Integer suspectedCount;//疑似病例人数
    private Integer curedCount;//治愈人数
    private Integer deadCount;//死亡人数
    private Integer locationId;//地区位置id
    private Integer pid;//城市所归属的省份的位置位置id(父id)
    private String statisticsData;//每一天的统计数据
    private String cities;//下属城市
    private String datetime;//时间

    public CovidBean() {
    }

    public CovidBean(String provinceName, String provinceShortName, String cityName, Integer currentConfirmedCount, Integer confirmedCount, Integer suspectedCount, Integer curedCount, Integer deadCount, Integer locationId, Integer pid, String statisticsData, String cities, String datetime) {
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.cityName = cityName;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.locationId = locationId;
        this.pid = pid;
        this.statisticsData = statisticsData;
        this.cities = cities;
        this.datetime = datetime;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getStatisticsData() {
        return statisticsData;
    }

    public void setStatisticsData(String statisticsData) {
        this.statisticsData = statisticsData;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(provinceName);
        dataOutput.writeUTF(provinceShortName);
        dataOutput.writeUTF(cityName);
        dataOutput.writeInt(currentConfirmedCount);
        dataOutput.writeInt(confirmedCount);
        dataOutput.writeInt(suspectedCount);
        dataOutput.writeInt(curedCount);
        dataOutput.writeInt(deadCount);
        dataOutput.writeInt(locationId);
        dataOutput.writeInt(pid);
        dataOutput.writeUTF(statisticsData);
        dataOutput.writeUTF(cities);
        dataOutput.writeUTF(datetime);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        provinceName = dataInput.readUTF();
        provinceShortName = dataInput.readUTF();
        cityName = dataInput.readUTF();
        currentConfirmedCount = dataInput.readInt();
        confirmedCount = dataInput.readInt();
        suspectedCount = dataInput.readInt();
        curedCount = dataInput.readInt();
        deadCount = dataInput.readInt();
        locationId = dataInput.readInt();
        pid = dataInput.readInt();
        statisticsData = dataInput.readUTF();
        cities = dataInput.readUTF();
        datetime = dataInput.readUTF();
    }

    @Override
    public String toString() {
        return "CovidBean{" +
                "provinceName='" + provinceName + '\'' +
                ", provinceShortName='" + provinceShortName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", currentConfirmedCount=" + currentConfirmedCount +
                ", confirmedCount=" + confirmedCount +
                ", suspectedCount=" + suspectedCount +
                ", curedCount=" + curedCount +
                ", deadCount=" + deadCount +
                ", locationId=" + locationId +
                ", pid=" + pid +
                ", statisticsData='" + statisticsData + '\'' +
                ", cities='" + cities + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
