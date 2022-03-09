package com.datasource.demo.config;

import com.datasource.demo.enums.DatabaseType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 因为代码中需要动态的设置数据源，所以数据源需要通过继承AbstractRoutingDataSource
 * contextHolder 是线程变量，因为每个请求是一个线程，所以通过这样来区分使用哪个库
 * determineCurrentLookupKey是重写的AbstractRoutingDataSource的方法，
 * 主要是确定当前应该使用哪个数据源的key，
 * 因为AbstractRoutingDataSource 中保存的多个数据源是通过Map的方式保存的
 * @author Wu Zicong
 * @create 2022-03-08 17:06
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    @Override
    protected Object determineCurrentLookupKey() {
        return contextHolder.get();
    }


    public static void master(){
        contextHolder.set(DatabaseType.Master);
    }


    public static void slave(){
        contextHolder.set(DatabaseType.Slave);
    }

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getType(){
        return contextHolder.get();
    }
}

