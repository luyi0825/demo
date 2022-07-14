package com.demo.sql.dynamic.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luyi
 * 数据源工厂类
 */
public interface DataSourceFactory {
    String DATA_SOURCE_PREFIX = "datasource_";

    /**
     * 得到数据源
     *
     * @param key 数据源的标识
     * @return key 对应的数据源信息
     */
    DataSource get(String key);

    /**
     * 注册数据源
     *
     * @param key 数据源的标识
     * @param dataSource 阿里druid数据源信息
     */
    void register(String key, DataSource dataSource);


    /**
     * 移除数据源
     *
     * @param key 数据源的标识
     */
    void remove(String key);

    /**
     * 得到数据源名称
     *
     * @param key 数据源标识
     * @return 数据源标识对应的数据源名称
     */
     static String getDataSourceName(String key) {
        return (DATA_SOURCE_PREFIX + key).intern();
    }


}
