package com.imcaojie.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author caojie
 * @className ServiceLogAspect
 * @description
 **/
@Component
@Aspect
@Slf4j
public class ServiceLogAspect {
    @Around("execution(* com.imcaojie.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("====== 开始执行 {}.{} ======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        // 记录开始时间
        long begin = System.currentTimeMillis();

        // 执行目标 service
        Object result = joinPoint.proceed();

        // 记录结束时间
        long end = System.currentTimeMillis();
        long takeTime = end - begin;

        if (takeTime > 3000) {
            log.error("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else if (takeTime > 2000) {
            log.warn("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        } else {
            log.info("====== 执行结束，耗时：{} 毫秒 ======", takeTime);
        }

        return result;
    }
}
