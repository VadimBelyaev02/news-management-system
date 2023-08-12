package com.vadim.newsservice.utils.cache.impl;

import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.utils.cache.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LruCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final ConcurrentLinkedDeque<K> keys;

    public LruCache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity in LRU cache is negative");
        }
        this.capacity = capacity;
        cache = new ConcurrentHashMap<>(capacity);
        keys = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Key or value in LRU cache is null");
        }
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

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        V value = cache.get(key);
        if (value == null) {
            throw new NotFoundException("Value by key = " + key + " is not found");
        }
        keys.remove(key);
        keys.addFirst(key);
        return value;
    }

    @Override
    public void remove(K key) {
        if (key == null) {
            throw new NullPointerException("Key is null");
        }
        cache.remove(key);
        keys.remove(key);
    }
}
