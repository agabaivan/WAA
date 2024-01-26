package com.agaba.waacourse.service.impl;

import com.agaba.waacourse.entity.Logger;
import com.agaba.waacourse.repo.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
@Aspect
@Configuration
public class LoggerServiceImpl{
    @Autowired
    LoggerRepository loggerRepository;

    @Before("execution(* com.agaba.waacourse.service.impl.*.*(..))")
    public void logOperation(JoinPoint joinPoint) {
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setTime(new Date());
        logger.setPrinciple("FakeUser");
        logger.setOperation(joinPoint.getSignature().getName());

        loggerRepository.save(logger);


    }
}
