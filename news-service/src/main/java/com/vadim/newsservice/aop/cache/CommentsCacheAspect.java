//package com.vadim.newsservice.aop.cache;
//
//import com.vadim.newsservice.cache.Cache;
//import com.vadim.newsservice.cache.enums.CacheType;
//import com.vadim.newsservice.cache.factory.impl.CacheFactoryImpl;
//import com.vadim.newsservice.model.entity.Comment;
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
//@Component
//@Aspect
//@Profile("dev || prod")
//public class CommentsCacheAspect {
//
//    private final Cache<UUID, Comment> cache;
//
//    @Value("${application.cache.algorithm}")
//    private CacheType cacheType;
//
//    @Value("${application.cache.capacity}")
//    private int capacity;
//
//    public CommentsCacheAspect() {
//        this.cache = CacheFactoryImpl.<UUID, Comment>newTagFactory().createCache(cacheType, capacity);
//    }
//
//    @Around("execution(* com.vadim.newsservice.repository.CommentRepository.findById(..))")
//    public Optional<Comment> aroundFindById(ProceedingJoinPoint joinPoint) throws Throwable {
//        UUID id = (UUID) joinPoint.getArgs()[0];
//        Optional<Comment> optionalComment = Optional.ofNullable(cache.get(id));
//
//        if (optionalComment.isEmpty()) {
//            optionalComment = (Optional<Comment>) joinPoint.proceed();
//            optionalComment.ifPresent(obj -> cache.put(obj.getId(), obj));
//        }
//
//        return optionalComment;
//    }
//
//    @Around("execution(* com.vadim.newsservice.repository.CommentRepository.save(..))")
//    public Comment aroundSaveMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        Comment comment = (Comment) joinPoint.proceed();
//        cache.put(comment.getId(), comment);
//        return comment;
//    }
//
//    @Around("execution(* com.vadim.newsservice.repository.CommentRepository.deleteById(..))")
//    public Object aroundDeleteByIdMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        UUID id = (UUID) joinPoint.getArgs()[0];
//        Object object = joinPoint.proceed();
//        cache.remove(id);
//        return object;
//    }
//}
