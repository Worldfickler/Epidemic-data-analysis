package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dell
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityConfirmed {

    private String cityName; //城市名

    private Integer cityconfirmedCount;// 累计确诊人数

}
