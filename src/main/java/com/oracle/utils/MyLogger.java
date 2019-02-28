package com.oracle.utils;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的操作
 *
 * @author 牛向前
 * @version 1.0
 */
@Aspect
@Component("logger")
public class MyLogger {


    static Logger logger = LogManager.getLogger(MyLogger.class.getName());

    @Pointcut("execution(* com.oracle.service.impl.*.*(..))")
    private void printLog() {
    }

    /**
     * 前置通知
     */
    @Before("printLog()")
    public void beforPrintLog(JoinPoint joinpoint) {
        logger.info("前置通知: 》》被调用类:!>>" + joinpoint.getTarget().getClass().getName() + "<<!");
        logger.info("      	     》》被调用方法:(" + joinpoint.getSignature().getName() + ")");
        logger.info("          》》请求参数列表:" + Arrays.toString(joinpoint.getArgs()));
    }

    /**
     * 后置通知
     */
    @AfterReturning(value = "printLog()", returning = "returnVal")
    public void afterReturnPrintLog(JoinPoint joinpoint, Object returnVal) {
        logger.info("后置通知: 》》(" + joinpoint.getSignature().getName() + ")方法的返回值为:" + returnVal);
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "printLog()", throwing = "error")
    public void afterErrorPrintLog(JoinPoint joinpoint, Throwable error) {

        logger.error("异常通知: 》》发生异常信息:", error.getMessage());
        // logger.error("异常通知: 》》发生异常信息:", error.getLocalizedMessage());
    }

    /**
     * 最终通知
     */
    @After("printLog()")
    public void afterPrintLog(JoinPoint joinpoint) {
        logger.info("最终通知: 》》(" + joinpoint.getSignature().getName() + ")执行结束");
    }

    /**
     * 环绕通知
     */
//	@Around()
    public Object aroundPrintLog(ProceedingJoinPoint point) {
        Object rtValue = null;

        try {
            System.out.println("aroundPrintLog开始记录日志了。。。前置");
            rtValue = point.proceed();
            System.out.println("aroundPrintLog开始记录日志了。。。后置");
        } catch (Throwable e) {
            System.out.println("aroundPrintLog开始记录日志了。。。异常");
            e.printStackTrace();
        } finally {
            System.out.println("aroundPrintLog开始记录日志了。。。最终");
        }
        return rtValue;
    }
}
