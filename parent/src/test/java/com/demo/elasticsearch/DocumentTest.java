package com.demo.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.IdsQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.*;
import com.demo.elasticsearch.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Executors;

@SpringBootTest
public class DocumentTest {


    @Resource
    private ElasticsearchClient elasticsearchClient;

    private String index = "products";

    @Test
    public void createDocument() throws IOException {
        for (int i = 0; i < 100000; i++) {
            Product product = new Product();
            product.setProductCode(UUID.randomUUID().toString());
            product.setProductName("productName" + product.getProductCode());
            IndexRequest<Product> indexRequest = new IndexRequest.Builder<Product>().index(index).id(product.getProductCode()).document(product).build();
            IndexResponse indexResponse = elasticsearchClient.index(indexRequest);
            System.out.println(indexResponse);
        }

    }

    @Test
    public void createDocument2() throws IOException {
        Product product = new Product();
        product.setProductCode("1");
        product.setProductName("productName" + product.getProductCode());
        product.setRemark("remark" + 1);
        CreateRequest<Product> indexRequest = new CreateRequest.Builder<Product>().index(index).id(product.getProductCode()).document(product).build();
        CreateResponse createResponse = elasticsearchClient.create(indexRequest);
        System.out.println(createResponse);
    }


    @Test
    public void getDocument() throws IOException {
        String id = "1";
        GetRequest getRequest = new GetRequest.Builder().index(index).id(id).build();
        GetResponse<Product> getResponse = elasticsearchClient.get(getRequest, Product.class);
        if (getResponse.found()) {
            System.out.println(getResponse.source());
        } else {
            System.out.println("not found");
        }
    }

    /**
     * 相当于部分更新_update
     *
     * @throws IOException
     */
    @Test
    public void updateDocument1() throws IOException {
        String id = "1";
        Product product = new Product();
        product.setProductCode(id);
        product.setProductName("update_productName" + id);

        UpdateRequest<Product, Product> updateRequest = new UpdateRequest.Builder<Product, Product>().index(index).id(id).doc(product).build();
        UpdateResponse<Product> updateResponse = elasticsearchClient.update(updateRequest, Product.class);
        System.out.println(updateResponse);
    }

    /**
     * 相当于部分更新_update
     *
     * @throws IOException
     */
    @Test
    public void updateDocumentByVersion() throws IOException {
        String id = "1";
        Product product = new Product();
        product.setProductCode(id);
        product.setProductName("update_productName" + id);

        UpdateRequest<Product, Product> updateRequest = new UpdateRequest.Builder<Product, Product>().index(index).id(id).doc(product).ifSeqNo(0L).ifPrimaryTerm(1L).build();
        UpdateResponse<Product> updateResponse = elasticsearchClient.update(updateRequest, Product.class);
        System.out.println(updateResponse);
    }

    /**
     * 相当于PUT(全量更新）
     */
    @Test
    public void updateDocumentAll() throws IOException {
        String id = "1";
        Product product = new Product();
        product.setProductCode(id);
        product.setProductName("update_productName" + id);
        IndexResponse indexResponse = elasticsearchClient.index(e -> e.index(index).id(id).document(product));
        System.out.println(indexResponse);
    }

    /**
     * updateByQuery---部分更新
     */
    @Test
    public void updateByQuery() throws IOException {
        String id = "1";
        Product product = new Product();
        product.setProductCode(id);
        product.setProductName("updateByQuery" + id);

        UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest.Builder().index(index).maxDocs(1L)
                .query(new Query.Builder().ids(new IdsQuery.Builder().values("1").build()).build()).build();

        UpdateByQueryResponse updateResponse = elasticsearchClient.updateByQuery(updateByQueryRequest);
        System.out.println(updateResponse);
    }


    /**
     * 删除文档
     */
    @Test
    public void deleteDocument() throws IOException {
        String id = "1";
        DeleteRequest deleteRequest = new DeleteRequest.Builder().index(index).id(id).build();
        DeleteResponse deleteResponse = elasticsearchClient.delete(deleteRequest);
        System.out.println(deleteResponse);
    }

}
