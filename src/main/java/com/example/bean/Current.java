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
public class Current {

    private String provinceShortName;//省份短名
    private Integer currentConfirmedCount;//确诊人数

}
