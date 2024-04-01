package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
public class IndexTest {

    @Resource
    private ElasticsearchClient elasticsearchClient;

    private final String index = "products";

    /**
     * 创建索引
     */
    @Test
    public void addIndex() throws IOException {

        elasticsearchClient.indices().create(c -> c
                .index(index)
                .settings(indexSetting -> indexSetting.numberOfShards("2").numberOfReplicas("3"))
        );
    }


    /**
     * 判断索引是否存在
     */
    @Test
    public void existIndex() throws IOException {
        ExistsRequest existsRequest = new ExistsRequest.Builder().index(index).build();
        BooleanResponse booleanResponse = elasticsearchClient.indices().exists(existsRequest);
        System.out.println(booleanResponse.value());
    }

    /**
     * @throws IOException
     */
    @Test
    public void getIndex() throws IOException {
        GetIndexResponse getIndexResponse = elasticsearchClient.indices().get(e -> e.index(index));
        System.out.println(getIndexResponse.get(index));
    }

    @Test
    public void deleteIndex() throws IOException {
        elasticsearchClient.indices().delete(e -> e.index(index));
    }

}
