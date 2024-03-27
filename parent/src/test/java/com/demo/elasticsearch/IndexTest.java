package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
public class IndexTest {

    @Resource
    private ElasticsearchClient elasticsearchClient;

    /**
     * 创建索引
     */
    @Test
    public void addIndex() throws IOException {

        elasticsearchClient.indices().create(c -> c
                .index("products")
                .settings(indexSetting -> indexSetting.numberOfShards("2").numberOfReplicas("3"))
        );
    }

    @Test
    public void deleteIndex() throws IOException {
        elasticsearchClient.indices().delete(e -> e.index("products"));
    }
}
