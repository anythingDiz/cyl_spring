package com.cyl.demo.aop.jdkProxyDemo;

import com.cyl.demo.aop.advice.PerformanceMonitor;

import javax.naming.event.ObjectChangeListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class CylInvocationHandler implements InvocationHandler {

    private Object target;

    public CylInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 最终生成的代理实例，一般不会用到；
     * @param method 被代理的目标实例的摸个具体的方法
     * @param args 被代理的目标实例的某个方法的入参,在方法反射调用时使用
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.start(target.getClass().getName() + "." + method.getName());
        Object result = method.invoke(target, args);
        PerformanceMonitor.end();

        return result;
    }
}
