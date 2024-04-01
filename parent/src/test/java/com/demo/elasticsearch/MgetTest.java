package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * mget测试
 */
@SpringBootTest
public class MgetTest {

    @Resource
    private ElasticsearchClient elasticsearchClient;
}
