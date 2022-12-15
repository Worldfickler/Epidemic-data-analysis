package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinentDead {

    private String continents;//大洲名
    private Integer deadCount;//当前确诊人数
}
