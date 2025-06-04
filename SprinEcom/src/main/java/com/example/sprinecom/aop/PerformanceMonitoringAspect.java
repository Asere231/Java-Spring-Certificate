package com.example.sprinecom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.sprinecom.service.ProductService.*(..))")
    public Object logCrash(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object obj = joinPoint.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Method " + joinPoint.getSignature().getName() + " Executed in " + (end-start) + " ms");

        return obj;
    }

}
