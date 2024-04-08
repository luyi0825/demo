package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.MgetRequest;
import co.elastic.clients.elasticsearch.core.MgetResponse;
import com.demo.elasticsearch.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * mget测试
 */
@SpringBootTest
public class MgetTest {

    @Resource
    private ElasticsearchClient elasticsearchClient;


    /**
     * 获取同一个索引的数据
     * @throws IOException
     */
    @Test
    void mgetOneIndex() throws IOException {
        MgetRequest mgetRequest = new MgetRequest.Builder().index("products").ids("productCode1", "productCode2").build();
        MgetResponse<Product> mgetResponse = elasticsearchClient.mget(mgetRequest, Product.class);
        List<Product> productList = new ArrayList<>();
        mgetResponse.docs().forEach(e -> {
            if (e.isFailure()) {
                System.out.println("失败:" + e.toString());
            } else {
                productList.add(e.result().source());
            }
        });
        System.out.println(productList);
    }

    @Test
    void getDifferentIndex() throws IOException {
        MgetRequest mgetRequest = new MgetRequest.Builder().index("products").ids("productCode1", "productCode2").build();
        MgetResponse<Product> mgetResponse = elasticsearchClient.mget(mgetRequest, Product.class);
        List<Product> productList = new ArrayList<>();
        mgetResponse.docs().forEach(e -> {
            if (e.isFailure()) {
                System.out.println("失败:" + e.toString());
            } else {
                productList.add(e.result().source());
            }
        });
        System.out.println(productList);
    }
}
