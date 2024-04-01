package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.bulk.*;
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
    public void create() throws IOException {
        List<Product> products = fetchProducts();

        BulkRequest.Builder br = new BulkRequest.Builder();
        for (Product product : products) {
            br.operations(new BulkOperation.Builder().create(new CreateOperation.Builder<Product>().index("products").document(product).build()).build());
        }
        BulkResponse result = client.bulk(br.build());
        if (result.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }
    }

    @Test
    public void index() throws IOException {
        List<Product> products = fetchProducts();

        BulkRequest.Builder br = new BulkRequest.Builder();
        for (Product product : products) {
            br.operations(new BulkOperation.Builder().index(new IndexOperation.Builder<>().index("products").document(product).build()).build());
        }
        BulkResponse result = client.bulk(br.build());
        if (result.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }
    }

    @Test

    public void update() throws IOException {
        Product product = new Product();
        product.setProductCode("bulkUpdateCode");
        product.setProductName("bulkUpdateName");
        product.setProductName("bulkUpdateRemark");

        BulkRequest.Builder br = new BulkRequest.Builder();

        UpdateOperation<Product, Product> updateOperation = new UpdateOperation.Builder<Product, Product>().index("products").id("1").action(new UpdateAction.Builder<Product, Product>().doc(product).build()).build();
        br.operations(new BulkOperation.Builder().update(updateOperation).build());

        BulkResponse result = client.bulk(br.build());
        if (result.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }
    }

    /**
     * bulk删除操作
     */
    @Test
    public void delete() throws IOException {
        BulkRequest.Builder br = new BulkRequest.Builder();
        DeleteOperation deleteOperation = new DeleteOperation.Builder().id("1").index("products").build();
        br.operations(new BulkOperation.Builder().delete(deleteOperation).build());
        BulkResponse result = client.bulk(br.build());
        if (result.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }
    }


    @Test
    public void testBulk() throws IOException {
        List<Product> products = fetchProducts();

        BulkRequest.Builder br = new BulkRequest.Builder();

        for (Product product : products) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index("products" + (int) (Math.random() * 100))
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
