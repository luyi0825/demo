package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.IdsQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.MsearchRequest;
import co.elastic.clients.elasticsearch.core.MsearchResponse;
import co.elastic.clients.elasticsearch.core.msearch.MultiSearchResponseItem;
import co.elastic.clients.elasticsearch.core.msearch.MultisearchBody;
import co.elastic.clients.elasticsearch.core.msearch.MultisearchHeader;
import co.elastic.clients.elasticsearch.core.msearch.RequestItem;
import com.demo.elasticsearch.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
public class MSearchTest {

    @Resource
    private ElasticsearchClient elasticsearchClient;

    @Test
    void msearch() throws IOException {
        MultisearchBody multisearchBody = new MultisearchBody.Builder().query(new Query.Builder().ids(new IdsQuery.Builder().values("1").build()).build()).build();

        MultisearchHeader multisearchHeader = new MultisearchHeader.Builder().allowNoIndices(true).build();
        RequestItem requestItem = new RequestItem.Builder().body(multisearchBody).header(multisearchHeader).build();

        MsearchRequest msearchRequest = new MsearchRequest.Builder().index("products").searches(requestItem).build();
        MsearchResponse<Product> productMsearchResponse = elasticsearchClient.msearch(msearchRequest, Product.class);
        for (MultiSearchResponseItem<Product> responseItems : productMsearchResponse.responses()) {
            if (responseItems.isResult()) {
                responseItems.result().hits().hits().forEach(e -> System.out.println(e.source()));
            }
        }

    }
}
