package com.vadim.newsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestNewsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(NewsServiceApplication::main).with(TestNewsServiceApplication.class).run(args);
    }

}
