package com.demo.model;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author luyi
 */
@MapperScan("com.demo.model.dao")
@Configuration
public class ModelConfigure {
}
