package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author dell
 * @version 1.0
 */

@Configuration
@Data
public class HdfsConfig {

    //要与配置文件中一致
    // hdfs nameNode连接URL
    @Value("${hdfs.url}")
    private String nameNodeUrl;

    // 操作用户
    @Value("${hdfs.username}")
    private String hdfsUserName;

}
