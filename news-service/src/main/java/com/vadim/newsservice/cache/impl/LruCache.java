package com.vadim.newsservice.cache.impl;

import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.cache.Cache;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LruCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final ConcurrentLinkedDeque<K> keys;

    public LruCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity in LRU cache must be positive");
        }
        this.capacity = capacity;
        cache = new ConcurrentHashMap<>(capacity);
        keys = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void put(K key, V value) {
        if (key != null && value != null) {
            if (cache.containsKey(key)) {
                keys.remove(key);
                cache.replace(key, value);
            } else {
                while (cache.size() >= capacity) {
                    K evictedKey = keys.removeLast();
                    cache.remove(evictedKey);
                }
                cache.put(key, value);
            }
            keys.addFirst(key);
        }

    }

    @Override
    public V get(K key) {
        V value = cache.get(key);
        if (Objects.nonNull(key) && Objects.nonNull(value)) {
            keys.remove(key);
            keys.addFirst(key);
        }
        return value;
    }

    @Override
    public void remove(K key) {
        if (key != null) {
            cache.remove(key);
            keys.remove(key);
        }
    }
}
