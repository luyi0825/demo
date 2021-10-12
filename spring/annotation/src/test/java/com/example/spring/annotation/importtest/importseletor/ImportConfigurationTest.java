package com.example.spring.annotation.importtest.importseletor;


import com.example.spring.annotation.importtest.ImportService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author luyi
 */
@SpringBootTest
class ImportConfigurationTest {

    @Autowired
    private ImportService importService;


    @Test
    public void test() {
        System.out.println( importService.test());
      //  Assertions.assertNotEquals(, MyImportServiceImpl.MY_IMPORT);
    }


}