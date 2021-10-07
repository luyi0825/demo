package com.demo.shardingjdbc;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author luyi
 * 精确对表分片
 */
public class MyPreciseTable implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> preciseShardingValue) {
        long value = preciseShardingValue.getValue();
        //逻辑表名
        String logicTableName = preciseShardingValue.getLogicTableName();
        //t_user_${(id % 2)+1}
        long mod = value % 2 + 1;
        String tableName = logicTableName + "_" + mod;
        if (availableTargetNames.contains(tableName)) {
            return tableName;
        }
        throw new IllegalArgumentException("tableName is illegal");
    }
}
