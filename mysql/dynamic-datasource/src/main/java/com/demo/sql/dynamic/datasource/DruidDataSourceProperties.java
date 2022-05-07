package com.demo.sql.dynamic.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties("spring.datasource")
public class DruidDataSourceProperties extends DruidDataSource {

    private Map<String,DruidDataSource> druid;



    public Map<String, DruidDataSource> getDruid() {
        return druid;
    }

    public void setDruid(Map<String, DruidDataSource> druid) {
        this.druid = druid;
    }
}
