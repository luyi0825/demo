package com.example.spring.annotation.importtest;

/**
 * @author luyi
 * 导入的service
 */
public class DefaultImportServiceImpl implements ImportService {

    @Override
    public String test() {
        return "default";
    }
}
