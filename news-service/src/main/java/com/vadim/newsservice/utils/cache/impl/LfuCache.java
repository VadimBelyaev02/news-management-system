package com.vadim.newsservice.utils.cache.impl;

import com.vadim.newsservice.exception.NotFoundException;
import com.vadim.newsservice.utils.cache.Cache;
import org.antlr.v4.runtime.misc.FlexibleHashMap;
import org.apache.tomcat.util.collections.ConcurrentCache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

public class LfuCache<K, V> implements Cache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final Map<K, Integer> frequencies;

    private final NavigableSet<K> orderedKeys;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.frequencies = new ConcurrentHashMap<>();
        this.cache = new ConcurrentHashMap<>();
        this.orderedKeys = new ConcurrentSkipListSet<>((k1, k2) -> {
            int freq1 = frequencies.getOrDefault(k1, 0);
            int freq2 = frequencies.getOrDefault(k2, 0);
            return freq1 == freq2 ? k1.hashCode() - k2.hashCode() : freq1 - freq2;
        });
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value in LFU cache is null");
        }
        if (cache.containsKey(key)) {
            int frequency = frequencies.get(key);
            frequencies.replace(key, frequency + 1);
            orderedKeys.remove(key);
            cache.replace(key, value);
        } else {
            while (cache.size() >= capacity) {
                K evictedKey = orderedKeys.pollFirst();
                cache.remove(evictedKey);
                frequencies.remove(evictedKey);
            }
            frequencies.put(key, 1);
            cache.put(key, value);
        }
        orderedKeys.add(key);
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Key is null");
        }
        V value = cache.get(key);
        if (value == null) {
            throw new NotFoundException("Value by key = " + key + " is not found");
        }
        int frequency = frequencies.get(key);
        frequencies.put(key, frequency + 1);
        orderedKeys.remove(key);
        orderedKeys.add(key);
        return value;
    }

    @Override
    public void remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        }
        cache.remove(key);
        frequencies.remove(key);
        orderedKeys.remove(key);
     }
}
