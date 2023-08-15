package com.vadim.newsservice.cache.factory.impl;

import com.vadim.newsservice.cache.impl.LfuCache;
import com.vadim.newsservice.cache.impl.LruCache;
import com.vadim.newsservice.cache.Cache;
import com.vadim.newsservice.cache.enums.CacheType;
import com.vadim.newsservice.cache.factory.CacheFactory;
import lombok.NoArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.lang.NonNullApi;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(staticName = "newTagFactory")
public class CacheFactoryImpl<K, V> implements CacheFactory<K, V>, CacheManager {
    @Override
    public Cache<K, V> createCache(CacheType cacheType, int capacity) {
        return switch (cacheType) {
            case LFU -> new LfuCache<>(capacity);
            case LRU -> new LruCache<>(capacity);
        };
    }

    @Override
    public org.springframework.cache.Cache getCache(String name) {
        return new ConcurrentMapCache(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return List.of("comment", "news");
    }
}
