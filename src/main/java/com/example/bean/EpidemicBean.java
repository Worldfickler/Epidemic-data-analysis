package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author dell
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpidemicBean {

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


    //序列化
//    @Override
//    public void write(DataOutput dataOutput) throws IOException {
//        dataOutput.writeUTF(provinceName);
//        dataOutput.writeUTF(provinceShortName);
//        dataOutput.writeUTF(cityName);
//        dataOutput.writeInt(currentConfirmedCount);
//        dataOutput.writeInt(confirmedCount);
//        dataOutput.writeInt(suspectedCount);
//        dataOutput.writeInt(curedCount);
//        dataOutput.writeInt(deadCount);
//        dataOutput.writeInt(locationId);
//        dataOutput.writeInt(pid);
//        dataOutput.writeUTF(statisticsData);
//        dataOutput.writeUTF(cities);
//        dataOutput.writeUTF(datetime);
//    }
//
//    //反序列化
//    @Override
//    public void readFields(DataInput dataInput) throws IOException {
//        provinceName = dataInput.readUTF();
//        provinceShortName = dataInput.readUTF();
//        cityName = dataInput.readUTF();
//        currentConfirmedCount = dataInput.readInt();
//        confirmedCount = dataInput.readInt();
//        suspectedCount = dataInput.readInt();
//        curedCount = dataInput.readInt();
//        deadCount = dataInput.readInt();
//        locationId = dataInput.readInt();
//        pid = dataInput.readInt();
//        statisticsData = dataInput.readUTF();
//        cities = dataInput.readUTF();
//        datetime = dataInput.readUTF();
//    }
}
