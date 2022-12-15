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
public class Result {

    private Object data;//响应的数据
    private Integer code;//状态码
    private String message;//返回信息

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode(400);
        result.setMessage("fail");
        return result;
    }

}
