package com.vadim.newsservice.cache.impl;

import com.vadim.newsservice.cache.Cache;

import java.util.Map;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class LfuCache<K, V> implements Cache<K, V> {

    private final int capacity;

    private final Map<K, V> cache;
    private final Map<K, Integer> frequencies;

    private final NavigableSet<K> orderedKeys;

    public LfuCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity in LRU cache must be positive");
        }
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
        if (key != null && value != null) {
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
    }

    @Override
    public V get(K key) {
        V value = cache.get(key);
        if (key != null && value != null) {
            int frequency = frequencies.get(key);
            frequencies.put(key, frequency + 1);
            orderedKeys.remove(key);
            orderedKeys.add(key);
        }
        return value;
    }

    @Override
    public void remove(K key) {
        if (key != null) {
            cache.remove(key);
            frequencies.remove(key);
            orderedKeys.remove(key);
        }
    }
}
