package com.example.sprinecom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.sprinecom.service.ProductService.getProduct(..)) && args(id)")
    public Object validate(ProceedingJoinPoint joinPoint, int id) throws Throwable {

        if (id < 0) {
            LOGGER.info("id value is negative, updating it...");
            id = -id;
            LOGGER.info("new id value is " + id);
        }

        Object obj = joinPoint.proceed(new Object[]{id});

        return obj;
    }
}
