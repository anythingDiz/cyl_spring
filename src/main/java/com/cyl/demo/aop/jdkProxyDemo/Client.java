package com.cyl.demo.aop.jdkProxyDemo;

import com.cyl.demo.aop.service.CylService;
import com.cyl.demo.aop.service.CylServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        CylService target = new CylServiceImpl();
        CylInvocationHandler handler = new CylInvocationHandler(target);

        CylService proxyService = (CylService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        proxyService.add();

    }
}
