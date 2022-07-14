package com.example.spring.doc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件
 * @author luyi
 */
@RestController
public class DocController {

    @GetMapping
    public String test() {
        return "5";
    }
}
