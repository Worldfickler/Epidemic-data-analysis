package com.example.mapperReduce.timeDataMR;

import com.google.gson.Gson;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */
public class TimeDataWritable implements Writable {

//    private String provinceShortName;//省份短名
    private String statisticsData;//省份内的时间信息

    public TimeDataWritable() {
    }

    public TimeDataWritable(String provinceShortName, String statisticsData) {
//        this.provinceShortName = provinceShortName;
        this.statisticsData = statisticsData;
    }

//    public String getProvinceShortName() {
//        return provinceShortName;
//    }

//    public void setProvinceShortName(String provinceShortName) {
//        this.provinceShortName = provinceShortName;
//    }

    public String getStatisticsData() {
        return statisticsData;
    }

    public void setStatisticsData(String statisticsData) {
        this.statisticsData = statisticsData;
    }

    public static final int WRITE_READ_UTF_MAX_LENGTH = 65535;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
//        dataOutput.writeUTF(provinceShortName);
//        dataOutput.writeUTF(statisticsData);
        //如果超过限定长度，将进行截取多次写出
        if (this.statisticsData.length() > WRITE_READ_UTF_MAX_LENGTH) {
            for (int i = 1; i < this.statisticsData.length() / WRITE_READ_UTF_MAX_LENGTH + 2; i++) {
                dataOutput.writeUTF(this.statisticsData.substring(WRITE_READ_UTF_MAX_LENGTH * (i - 1), WRITE_READ_UTF_MAX_LENGTH * i < this.statisticsData.length() ? WRITE_READ_UTF_MAX_LENGTH * i : this.statisticsData.length()));
            }
        } else {
            //长度在0-65535默认写出
            dataOutput.writeUTF(this.statisticsData);
        }
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
//        provinceShortName = dataInput.readUTF();
//        statisticsData = dataInput.readUTF();
        String tempStr = dataInput.readUTF();
        StringBuilder sBulider = new StringBuilder();
        //如果长度大于等于65535，继续读取
        while(tempStr.length() >= WRITE_READ_UTF_MAX_LENGTH) {
            sBulider.append(tempStr);
            tempStr= dataInput.readUTF();
        }
        sBulider.append(tempStr);
        this.statisticsData = sBulider.toString();
    }

//    @Override
//    public String toString() {
//        Gson gson = new Gson();
//        return gson.toJson(this);
//    }



}
