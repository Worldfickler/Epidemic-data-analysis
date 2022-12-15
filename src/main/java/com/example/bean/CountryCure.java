package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryCure {

    private String countryShortCode;//国家简称
    private Integer curedCount;//当前治愈人数

}
