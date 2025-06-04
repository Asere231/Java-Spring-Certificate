package com.example.sprinecom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* com.example.sprinecom.service.ProductService.*(..))")
    public void log(JoinPoint joinPoint) {
        LOGGER.info("Method " + joinPoint.getSignature().getName() + " Executed");
    }

    @AfterThrowing("execution(* com.example.sprinecom.service.ProductService.*(..))")
    public void logCrash(JoinPoint joinPoint) {
        LOGGER.info("Method " + joinPoint.getSignature().getName() + " Crashed");
    }

}
