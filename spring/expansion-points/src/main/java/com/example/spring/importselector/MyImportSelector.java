package com.example.spring.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("MyImportSelector");
        return new String[]{MyImportSelectorBean.class.getName()};
    }

    class MyImportSelectorBean {

        MyImportSelectorBean() {
            System.out.println("MyImportSelectorBean init");
        }
    }
}
