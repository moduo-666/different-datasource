package com.datasource.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Wu Zicong
 * @create 2022-03-09 10:20
 */
@ConfigurationProperties(prefix = "spring.slave")
@EnableConfigurationProperties
@Data
@Component
public class SlaveInfo {
    private String url;
    private String username;
    private String password;
    private String driverClassNamel;
    private String type;

    private Integer maxActive;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxWait;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
}
