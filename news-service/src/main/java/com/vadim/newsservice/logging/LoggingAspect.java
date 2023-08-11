package com.vadim.newsservice.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(@com.vadim.newsservice.logging.annotations.LogAnnotation * *(..))")
    private void annotatedMethods() {
    }

    @Pointcut("within(@com.vadim.newsservice.logging.annotations.LogAnnotation *)")
    private void annotatedClass() {
    }
}
