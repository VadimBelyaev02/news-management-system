package com.vadim.newsservice.config;

import com.vadim.newsservice.cache.factory.CacheFactory;
import com.vadim.newsservice.cache.factory.impl.CacheFactoryImpl;
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


    }

    @Configuration
    @Profile("dev")
    @EnableCaching
    public static class DevConfig {
        @Bean
        public CacheManager cacheManager() {
            return CacheFactoryImpl.newCacheFactory();
        }
    }

    @Configuration
    @Profile("!prod && !dev")
    public static class DefaultConfig {

    }
}
