package com.demo.shardingjdbc;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author luyi
 * 范围对数据库分片
 * 处理：select * from t_user where id between 1 and 100
 */
public class MyRangeDataSource implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        long lowerEndpoint = rangeShardingValue.getValueRange().lowerEndpoint();
        long upperEndpoint = rangeShardingValue.getValueRange().upperEndpoint();

        if (lowerEndpoint != upperEndpoint) {
            return Arrays.asList("t_user_1", "t_user_2");
        }
        long mod = upperEndpoint % 2 + 1;
        return List.of("t_user_" + mod);
    }
}
