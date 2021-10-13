package com.example.spring.annotation.importtest.beanregistrar;

import com.example.spring.annotation.importtest.ImportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ImportBeanDefinitionRegistrar测试
 *
 * @author luyi
 * @date 2021/10/13
 */
@SpringBootTest
public class ImportBeanDefinitionRegistrarTest {
    @Autowired(required = false)
    private ImportService importService;

    @Test
    public void test() {
        importService.test();
    }
}
