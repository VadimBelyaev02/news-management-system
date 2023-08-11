package com.vadim.newsservice.utils.cache.factory;

import com.vadim.newsservice.utils.cache.Cache;
import com.vadim.newsservice.utils.cache.enums.CacheType;

public interface CacheFactory<K, V> {

    Cache<K, V> createCache(CacheType cacheType, int capacity);
}
