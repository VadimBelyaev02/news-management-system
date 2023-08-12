package com.vadim.newsservice.aop.cache;

import com.vadim.newsservice.model.entity.News;
import com.vadim.newsservice.utils.cache.Cache;
import com.vadim.newsservice.utils.cache.enums.CacheType;
import com.vadim.newsservice.utils.cache.factory.CacheFactory;
import com.vadim.newsservice.utils.cache.factory.impl.CacheFactoryImpl;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
@Profile("dev || prod")
public class NewsCacheAspect {

    private final Cache<UUID, News> cache;

    @Value("${application.cache.algorithm}")
    private CacheType cacheType;

    @Value("${application.cache.capacity}")
    private int capacity;

    public NewsCacheAspect() {
        this.cache = CacheFactoryImpl.<UUID, News>newTagFactory().createCache(cacheType, capacity);
    }

}
