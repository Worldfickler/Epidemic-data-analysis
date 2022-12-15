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
public class Import {

    private String cityName;
    private String provinceShortName;
    private Integer confirmedCount;

}
