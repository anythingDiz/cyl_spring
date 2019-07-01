package com.cyl.demo.aop.cglibProxyDemo;

import com.cyl.demo.aop.advice.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class CylMethodInterceptor<T>  implements MethodInterceptor{
    private Enhancer enhancer = new Enhancer();

    public T getProxy(Class<T> clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return (T) enhancer.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.start(obj.getClass().getName()+"."+method.getName());
        Object result = methodProxy.invokeSuper(obj, args);
        PerformanceMonitor.end();

        return result;
    }
}
