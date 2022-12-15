package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityCured {
    private String cityName;//城市名

    private Integer curedCount;//治愈人数
}
