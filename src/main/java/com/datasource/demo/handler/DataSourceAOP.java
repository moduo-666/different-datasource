package com.datasource.demo.handler;

/**
 * 数据源切入面
 * @author Wu Zicong
 * @create 2022-03-09 9:17
 */

import com.datasource.demo.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DataSourceAOP {

    @Before("execution(* com.datasource.demo.service.*.select*(..)) || execution(* com.datasource.demo.service.*.get*(..))")
    public void setReadDataSourceType() {
        DynamicDataSource.slave();
        log.info("dataSource切换到：slave");
    }

    @Before("execution(* com.datasource.demo.service.*.insert*(..)) || execution(* com.datasource.demo.service.*.update*(..)) || execution(* com.datasource.demo.service.*.delete*(..)) || execution(* com.datasource.demo.service.*.add*(..))")
    public void setWriteDataSourceType() {
        DynamicDataSource.master();
        log.info("dataSource切换到：master");
    }

}
