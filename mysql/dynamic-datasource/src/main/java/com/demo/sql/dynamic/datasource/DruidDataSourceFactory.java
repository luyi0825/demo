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
 * 阿里的druid数据源工厂类
 */
@Component
public class DruidDataSourceFactory implements ApplicationContextAware, DataSourceFactory {

    private AbstractApplicationContext applicationContext;

    private final Map<String, DataSource> dataSourceCache = new ConcurrentHashMap<>(3);


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (AbstractApplicationContext) applicationContext;
    }

    @Override
    public DataSource get(String key) {
        Assert.notNull(key, "key不能为空");
        String dataSourceBeanName = DataSourceFactory.getDataSourceName(key);
        DataSource dataSource = dataSourceCache.get(dataSourceBeanName);
        if (dataSource == null) {
            dataSource = applicationContext.getBean(dataSourceBeanName, DataSource.class);
            dataSourceCache.putIfAbsent(dataSourceBeanName, dataSource);
        }
        return dataSource;
    }

    /**
     * 注册数据源
     *
     * @param key        移除数据源
     * @param dataSource 阿里druid数据源信息
     */
    @Override
    public void register(String key, DataSource dataSource) {
        String dataSourceBeanName = DataSourceFactory.getDataSourceName(key);
        synchronized (DruidDataSourceFactory.class) {
            if (applicationContext.containsBean(dataSourceBeanName)) {
                throw new DataSourceException("数据源【" + key + "】已经存在");
            }
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
            beanFactory.registerSingleton(dataSourceBeanName, dataSource);
            dataSourceCache.put(dataSourceBeanName, dataSource);
        }
    }

    @Override
    public void remove(String key) {
        String dataSourceBeanName = DataSourceFactory.getDataSourceName(key);
        synchronized (DruidDataSourceFactory.class) {
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
            beanFactory.destroySingleton(dataSourceBeanName);
            dataSourceCache.remove(dataSourceBeanName);
        }
    }
}
