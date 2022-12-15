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
public class Suspected {

    private String provinceShortName;//省份短名
    private Integer suspectedCount;//疑似病例人数

}
