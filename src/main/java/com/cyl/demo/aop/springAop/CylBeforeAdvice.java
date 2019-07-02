package com.cyl.demo.aop.springAop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description 前置增强
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class CylBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String customerName = (String) args[0];

        System.out.println(">> How are you ! Mr." + customerName);
    }
}
