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
public class Continent {

    private String countryShortCode;//国家简称
    private Integer currentConfirmedCount;//当前确诊人数

}
