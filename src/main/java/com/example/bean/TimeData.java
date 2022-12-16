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
public class TimeData {

    private String dateId;
    private Integer confirmedCount;//累计确诊
//    private Integer currentConfirmedCount;
    private Integer confirmedIncr;//新增确诊
    private Integer curedCount;//累计治愈
//    private Integer currentConfirmedIncr;
//    private Integer curedIncr;
    private Integer suspectedCount;//疑似病例
//    private Integer suspectedCountIncr;
    private Integer deadCount;//累计死亡

}
