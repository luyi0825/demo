package com.demo.sql.dynamic.datasource;

import com.baomidou.dynamic.datasource.processor.DsProcessor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author luyi
 */
public class DynamicDsProcessor extends DsProcessor {


    @Override
    public boolean matches(String key) {
        return true;
    }

    @Override
    public String doDetermineDatasource(MethodInvocation invocation, String ds) {
        String key = (String) invocation.getArguments()[0];
        return DataSourceFactory.getDataSourceName(key);
    }
}
