package com.vadim.newsservice.utils.cache.impl;

import com.vadim.newsservice.utils.cache.Cache;
import org.antlr.v4.runtime.misc.FlexibleHashMap;
import org.apache.tomcat.util.collections.ConcurrentCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class LfuCache<K, V> implements Cache<K, V> {

    private final int capacity;

    private final Map<K, V> cache;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();

    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }
}
