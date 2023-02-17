package com.example.spring.importselector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author luyi
 * 导入的配置类
 */
@Configuration
@Import({MyImportSelector.class,MyDeferredImportSeletor.class,MyImportBeanDefinitionRegistrar.class})
public class ImportConfiguration {

    public void init() {
        System.out.println("importConfiguration init");
    }


}
