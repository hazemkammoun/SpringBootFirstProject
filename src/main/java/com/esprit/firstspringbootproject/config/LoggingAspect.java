package com.esprit.firstspringbootproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.esprit.firstspringbootproject.services.FoyerService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    /*@After("….....")
    public void logMethodExit….*/

    @After("execution(* com.esprit.firstspringbootproject.services.FoyerService.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name= joinPoint.getSignature().getName();
        log.info("Out method : " + name);
    }

    @AfterReturning("execution(* com.esprit.firstspringbootproject.services.FoyerService.*(..))")
    public void logMethodExitReturning(JoinPoint joinPoint) {
        String name= joinPoint.getSignature().getName();
        log.info("Out method with succes : " + name);
    }
    @AfterThrowing("execution(* com.esprit.firstspringbootproject.services.FoyerService.*(..))")
    public void logMethodExitReturningEror(JoinPoint joinPoint) {
        String name= joinPoint.getSignature().getName();
        log.info("Out method with Error : " + name);
    }

}

