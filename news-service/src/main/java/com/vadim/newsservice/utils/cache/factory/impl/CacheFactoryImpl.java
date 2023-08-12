package com.vadim.newsservice.utils.cache.factory.impl;

import com.vadim.newsservice.utils.cache.Cache;
import com.vadim.newsservice.utils.cache.enums.CacheType;
import com.vadim.newsservice.utils.cache.factory.CacheFactory;
import com.vadim.newsservice.utils.cache.impl.LfuCache;
import com.vadim.newsservice.utils.cache.impl.LruCache;
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
