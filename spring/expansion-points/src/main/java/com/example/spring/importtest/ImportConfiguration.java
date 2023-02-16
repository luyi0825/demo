package com.example.spring.importtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luyi
 * 导入的配置类
 */
@Configuration
public class ImportConfiguration {

    public void init() {
        System.out.println("importConfiguration init");
    }

   // @ConditionalOnMissingBean
    @Bean
    public ImportService importService() {
        return new DefaultImportServiceImpl();
    }
}
