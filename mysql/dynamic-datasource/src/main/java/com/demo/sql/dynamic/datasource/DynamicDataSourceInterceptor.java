package com.demo.sql.dynamic.datasource;

import com.baomidou.dynamic.datasource.aop.DynamicDataSourceAnnotationInterceptor;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.baomidou.dynamic.datasource.support.DataSourceClassResolver;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author luyi
 */
public class DynamicDataSourceInterceptor extends DynamicDataSourceAnnotationInterceptor {

    private final DsProcessor dsProcessor;
    private final DataSourceClassResolver dataSourceClassResolver;

    public DynamicDataSourceInterceptor(Boolean allowedPublicOnly, DsProcessor dsProcessor) {
        super(allowedPublicOnly, dsProcessor);
        dataSourceClassResolver = new DataSourceClassResolver(allowedPublicOnly);
        this.dsProcessor = dsProcessor;
    }


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            String dsKey = determineDatasourceKey(invocation);
            DynamicDataSourceContextHolder.push(dsKey);
            return invocation.proceed();
        } finally {
            DynamicDataSourceContextHolder.poll();
        }
    }


    private String determineDatasourceKey(MethodInvocation invocation) {
        String ds = dataSourceClassResolver.findDSKey(invocation.getMethod(), invocation.getThis());
        return dsProcessor.determineDatasource(invocation, ds);
    }
}
