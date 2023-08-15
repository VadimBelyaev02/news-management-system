package com.vadim.newsservice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CacheConfig {

    @Configuration
    @Profile("prod")
    @EnableCaching
    public static class ProdConfig {

        @Bean
        public CacheManager cacheManager() {

        }
    }

    @Configuration
    @Profile("dev")
    @EnableCaching
    public static class DevConfig {

    }

    @Configuration
    @Profile("!prod && !dev")
    public static class DefaultConfig {

    }
}
