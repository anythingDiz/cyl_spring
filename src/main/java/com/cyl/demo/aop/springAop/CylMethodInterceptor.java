package com.cyl.demo.aop.springAop;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 环绕增强
 */
public class CylMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //获取入参
        Object[] arguments = invocation.getArguments();

        //在目标方法之前增强
        System.out.println(">> args:" + JSON.toJSONString(arguments));

        //通过反射机制调用目标方法
        Object result = invocation.proceed();

        //后置增强
        System.out.println(">> result:" + result);

        //可以改变返回值
        result = "hhh";
        return result;
    }
}
