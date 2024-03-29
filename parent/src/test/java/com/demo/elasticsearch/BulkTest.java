package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import com.demo.elasticsearch.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class BulkTest {

    @Resource
    private ElasticsearchClient client;

    @Test
    public void testBulk() throws IOException {
        List<Product> products = fetchProducts();

        BulkRequest.Builder br = new BulkRequest.Builder();

        for (Product product : products) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index("products" + (int)(Math.random() * 100))
                            .id(product.getProductCode())
                            .document(product)
                    )
            );
        }

        BulkResponse result = client.bulk(br.build());

// Log errors, if any
        if (result.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }
    }

    private List<Product> fetchProducts() {


        List<Product> products = new ArrayList<>(1000);
        for (int i = 0; i < 10000; i++) {
            Product product = new Product();
            product.setProductName("productName" + i);
            product.setProductCode("productCode" + i);
            products.add(product);
        }
        return products;


    }
}
