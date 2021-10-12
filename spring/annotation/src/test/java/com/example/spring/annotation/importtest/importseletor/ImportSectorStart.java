package com.example.spring.annotation.importtest.importseletor;

import com.example.spring.annotation.importtest.ImportService;
import com.example.spring.annotation.importtest.MyDeferredImportSeletor;
import com.example.spring.annotation.importtest.MyImportSeletor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MyImportSeletor.class)
//@Import(MyDeferredImportSeletor.class)
public class ImportSectorStart {
    public static void main(String[] args) {
        SpringApplication.run(ImportSectorStart.class, args);
    }

    @Bean
    public ImportService myImport() {
        return new MyImportServiceImpl();
    }
}
