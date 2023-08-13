package com.vadim.newsservice.cache.factory;

import com.vadim.newsservice.cache.Cache;
import com.vadim.newsservice.cache.enums.CacheType;

public interface CacheFactory<K, V> {

   Cache<K, V> createCache(CacheType cacheType, int capacity);
}
