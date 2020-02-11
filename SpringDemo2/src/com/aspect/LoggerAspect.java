package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 辅助功能:日志切面
 */
public class LoggerAspect {
    //根据xml中的around参数，这里的切面是做环绕通知，会覆盖切入点原有方法，通过反射(proceed)调用原有方法
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("start log:"+joinPoint.getSignature().getName());
        //调用原有方法
        Object object = joinPoint.proceed();
        System.out.println("end log:"+joinPoint.getSignature().getName());
        return object;
    }
}
