package com.vadim.newsservice.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.vadim.newsservice.cache.factory.CacheFactory;
import com.vadim.newsservice.cache.factory.impl.CacheFactoryImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfig {

    @Configuration
    @Profile("prod")
    @EnableCaching
    public static class ProdConfig {

        @Bean
        public Caffeine caffeine() {
            return Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES);
        }

        @Bean
        public CacheManager cacheManager(Caffeine caffeine) {
            CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
            caffeineCacheManager.setCaffeine(caffeine);
            return caffeineCacheManager;
        }

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
