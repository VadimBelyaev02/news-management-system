package com.vadim.newsservice.utils.cache.factory.impl;

import com.vadim.newsservice.utils.cache.Cache;
import com.vadim.newsservice.utils.cache.enums.CacheType;
import com.vadim.newsservice.utils.cache.factory.CacheFactory;

public class CacheFactoryImpl<K, V> implements CacheFactory<K, V> {
    @Override
    public Cache<K, V> createCache(CacheType cacheType, int capacity) {
        switch (cacheType) {
            case LFU ->new
        }
    }
}
