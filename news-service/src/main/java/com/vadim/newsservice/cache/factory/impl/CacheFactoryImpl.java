package com.vadim.newsservice.cache.factory.impl;

import com.vadim.newsservice.cache.impl.LfuCache;
import com.vadim.newsservice.cache.impl.LruCache;
import com.vadim.newsservice.cache.Cache;
import com.vadim.newsservice.cache.enums.CacheType;
import com.vadim.newsservice.cache.factory.CacheFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "newTagFactory")
public class CacheFactoryImpl<K, V> implements CacheFactory<K, V> {
    @Override
    public Cache<K, V> createCache(CacheType cacheType, int capacity) {
        return switch (cacheType) {
            case LFU -> new LfuCache<>(capacity);
            case LRU -> new LruCache<>(capacity);
        };
    }
}
