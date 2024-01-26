package com.agaba.waacourse.AOP;

import com.agaba.waacourse.annotations.ExecutionTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class Execution {

   // @Around("(execution(* com.agaba.waacourse.annotations.*.*.*(..)))")
   long startTime = System.currentTimeMillis();
   @Around("@annotation(com.agaba.waacourse.annotations.ExecutionTime)")

    public void showExecutionTime(JoinPoint joinPoint) throws Throwable {
        final Logger logger = LoggerFactory.getLogger(getClass());

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        //Object result = proceedingJoinPoint.proceed();

        logger.info("{} executed in {} ms", joinPoint, executionTime);
       // return result;


    }
}


