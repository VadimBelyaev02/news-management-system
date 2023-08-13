package com.vadim.newsservice.cache.enums;

public enum CacheType {
    LRU("LRU"),
    LFU("LFU");

    private final String cacheType;

    CacheType(String cacheType) {
        this.cacheType = cacheType;
    }
}
