package com.example.spring.annotation.importtest.importseletor;

import com.example.spring.annotation.importtest.ImportService;
import org.springframework.stereotype.Component;


public class MyImportServiceImpl implements ImportService {

    public static String MY_IMPORT="my";

    @Override
    public String test() {
        return MY_IMPORT;
    }
}
