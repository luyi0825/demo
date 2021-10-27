package com.demo.shardingjdbc.rediskey;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luyi
 * 自定义主键生成策略
 */
public final class MyShardingKeyGenerator implements ShardingKeyGenerator {

    private final AtomicInteger integer = new AtomicInteger(0);
    private final Properties properties = new Properties();

    @Override
    public Comparable<?> generateKey() {
        long time = System.currentTimeMillis();
        time = time + integer.incrementAndGet();
        System.out.println("key:" + time);
        return time;
    }

    @Override
    public String getType() {
        return "MYKEY";
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties.putAll(properties);
    }


}
