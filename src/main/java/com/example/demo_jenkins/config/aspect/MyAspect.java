package com.example.demo_jenkins.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.example.demo.controller..*(..))")
    public Object handleControllerMethod (ProceedingJoinPoint pjp) throws Throwable {
        logger.info("进入切片..." + new Date().getTime());
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            logger.info("参数值为：..." + args[i] );
        }
        Object proceed = pjp.proceed();
        return proceed;
    }
}
