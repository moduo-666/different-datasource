package com.datasource.demo.config;

/**
 * @author Wu Zicong
 * @create 2022-03-08 17:46
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.datasource.demo.enums.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private MasterInfo masterInfo;
    @Autowired
    private SlaveInfo slaveInfo;

    public DatabaseConfig(){
        System.out.println("####################  DataBaseConfiguration");
    }

    public DataSource master() {
        System.out.println("注入Master druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(masterInfo.getUrl());
        datasource.setDriverClassName(masterInfo.getDriverClassNamel());
        datasource.setUsername(masterInfo.getUsername());
        datasource.setPassword(masterInfo.getPassword());
        datasource.setInitialSize(masterInfo.getInitialSize());
        datasource.setMinIdle(masterInfo.getMinIdle());
        datasource.setMaxWait(masterInfo.getMaxWait());
        datasource.setMaxActive(masterInfo.getMaxActive());
        datasource.setMinEvictableIdleTimeMillis(masterInfo.getMinEvictableIdleTimeMillis());
        try {
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }

    public DataSource slave() {
        System.out.println("Slave druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(slaveInfo.getUrl());
        datasource.setDriverClassName(slaveInfo.getDriverClassNamel());
        datasource.setUsername(slaveInfo.getUsername());
        datasource.setPassword(slaveInfo.getPassword());
        datasource.setInitialSize(slaveInfo.getInitialSize());
        datasource.setMinIdle(slaveInfo.getMinIdle());
        datasource.setMaxWait(slaveInfo.getMaxWait());
        datasource.setMaxActive(slaveInfo.getMaxActive());
        datasource.setMinEvictableIdleTimeMillis(slaveInfo.getMinEvictableIdleTimeMillis());
        try {
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DataSource master = master();
        DataSource slave = slave();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DatabaseType.Master, master);
        targetDataSources.put(DatabaseType.Slave, slave);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(master);
        return dataSource;
    }
}