package com.cyl.demo.aop.cglibProxyDemo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/3
 */
public class CylMethodInterceptor1 implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(">> 調用了我哈哈");
        Object res = methodProxy.invokeSuper(obj, args);
        return  res;
    }
}
