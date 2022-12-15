package com.example.bean;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CityBean implements Writable {
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
    private String datetime;//时间

    public CityBean(){
    }

    //序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(provinceName);
        dataOutput.writeUTF(provinceShortName);
        dataOutput.writeUTF(statisticsData);
        dataOutput.writeUTF(cityName);
        dataOutput.writeUTF(datetime);
        dataOutput.writeInt(currentConfirmedCount);
        dataOutput.writeInt(confirmedCount);
        dataOutput.writeInt(suspectedCount);
        dataOutput.writeInt(curedCount);
        dataOutput.writeInt(deadCount);
        dataOutput.writeInt(locationId);
        dataOutput.writeInt(pid);
    }


    //反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.provinceName = dataInput.readUTF();
        this.provinceShortName = dataInput.readUTF();
        this.statisticsData = dataInput.readUTF();
        this.cityName = dataInput.readUTF();
        this.datetime = dataInput.readUTF();
        this.currentConfirmedCount = dataInput.readInt();
        this.confirmedCount = dataInput.readInt();
        this.suspectedCount = dataInput.readInt();
        this.curedCount = dataInput.readInt();
        this.deadCount = dataInput.readInt();
        this.locationId = dataInput.readInt();
        this.pid = dataInput.readInt();

    }

    @Override
    public String toString() {
        return "CityBean{"+
                "city_id"+locationId+
                ",pid'" + pid + '\'' +
                ", cityName='" + cityName + '\'' +
                ", city_currentConfirmedCount=" + currentConfirmedCount +
                ", city_curedCount=" + curedCount +
                ", city_deadCount=" + deadCount +
                ", city_suspectedCount=" + suspectedCount +
//                ", cityShortName='" + cityShortName + '\'' +
                '}';
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


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
