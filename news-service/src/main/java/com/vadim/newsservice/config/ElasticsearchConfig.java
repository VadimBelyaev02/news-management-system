package com.vadim.newsservice.config;

import co.elastic.clients.elasticsearch.core.IndexRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.erhlc.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticsearchConfig {
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate() {
//        return new ElasticsearchTemplate(elasticsearchClient());
//    }
//
//    @Bean
//    public RestHighLevelClient elasticsearchClient() {
//        return new RestHighLevelClient(RestClient.builder(
//                new HttpHost("localhost", 9200, "http"),
//                new HttpHost("localhost", 9201, "http")
//        ));
//    }
//
//    @PostConstruct
//    public void createIndex() throws IOException {
//        IndexRequest indexRequest = new IndexRequest("my-index");
//        indexRequest.source(XContentFactory.jsonBuilder()
//                .startObject()
//                .field("name", "John Doe")
//                .field("age", 30)
//                .field("city", "New York")
//                .endObject());
//
//        elasticsearchTemplate().index(indexRequest);
//    }
}
