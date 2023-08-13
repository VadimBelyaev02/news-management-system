//package com.vadim.newsservice.aop.cache;
//
//import com.vadim.newsservice.cache.Cache;
//import com.vadim.newsservice.cache.enums.CacheType;
//import com.vadim.newsservice.cache.factory.impl.CacheFactoryImpl;
//import com.vadim.newsservice.model.entity.News;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Aspect
//@Component
//@Profile("dev || prod")
//public class NewsCacheAspect {
//
//    private final Cache<UUID, News> cache;
//
//    @Value("${application.cache.algorithm}")
//    private CacheType cacheType;
//
//    @Value("${application.cache.capacity}")
//    private int capacity;
//
//    public NewsCacheAspect() {
//        this.cache = CacheFactoryImpl.<UUID, News>newTagFactory().createCache(cacheType, capacity);
//    }
//
//    @Around("execution(* com.vadim.newsservice.repository.NewsRepository.findById(..))")
//    public Optional<News> aroundFindById(ProceedingJoinPoint joinPoint) throws Throwable {
//        UUID id = (UUID) joinPoint.getArgs()[0];
//        Optional<News> optionalNews = Optional.ofNullable(cache.get(id));
//
//        if (optionalNews.isEmpty()) {
//            optionalNews = (Optional<News>) joinPoint.proceed();
//            optionalNews.ifPresent(obj -> cache.put(obj.getId(), obj));
//        }
//
//        return optionalNews;
//    }
//
//    @Around("execution(* com.vadim.newsservice.repository.NewsRepository.save(..))")
//    public News aroundSaveMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        News news = (News) joinPoint.proceed();
//        cache.put(news.getId(), news);
//        return news;
//    }
//
//    @Around("execution(* com.vadim.newsservice.repository.NewsRepository.deleteById(..))")
//    public Object aroundDeleteByIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        UUID id = (UUID) joinPoint.getArgs()[0];
//        Object object = joinPoint.proceed();
//        cache.remove(id);
//        return object;
//    }
//}
