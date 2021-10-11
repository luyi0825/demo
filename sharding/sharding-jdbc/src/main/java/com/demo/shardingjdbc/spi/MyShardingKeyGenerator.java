package com.demo.shardingjdbc.spi;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luyi
 * 自定义主键生成策略
 */
public class MyShardingKeyGenerator implements ShardingKeyGenerator {

    private final AtomicInteger integer = new AtomicInteger(0);

    @Override
    public Comparable<?> generateKey() {
        long time = System.currentTimeMillis();
        time = time + integer.incrementAndGet();
        System.out.println("key:" + time);
        return time;
    }

    @Override
    public String getType() {
        return "myKey";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }


}
