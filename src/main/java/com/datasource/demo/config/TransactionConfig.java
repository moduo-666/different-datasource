package com.datasource.demo.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Wu Zicong
 * @create 2022-03-09 9:15
 */

@Configuration
@EnableTransactionManagement
@Slf4j
@AutoConfigureAfter({ MybatisConfiguration.class })
public class TransactionConfig extends DataSourceTransactionManagerAutoConfiguration {

    @Autowired
    public DataSourceTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {
        log.info("事物配置");
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}
