package com.cyl.demo.aop.springAop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置增强
 */
public class CylAfterReturningAdvice implements AfterReturningAdvice {

    /**
     *
     * @param returnValue 返回的结果值
     * @param method 执行的方法
     * @param args 参数
     * @param target
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        System.out.println(">> Please enjoy yourself");

        System.out.println(returnValue);

        //证明了无法改变返回值
        returnValue = "hhh";

    }
}
