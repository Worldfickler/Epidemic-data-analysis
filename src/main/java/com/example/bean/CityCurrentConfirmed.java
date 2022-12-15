package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityCurrentConfirmed {
    private String cityName;//城市名
    private Integer currentConfirmedCount;//目前人数
}
