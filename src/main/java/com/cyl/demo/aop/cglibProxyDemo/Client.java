package com.cyl.demo.aop.cglibProxyDemo;

import com.cyl.demo.aop.service.CylServiceImpl;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        CylMethodInterceptor<CylServiceImpl> interceptor = new CylMethodInterceptor<>();

        CylServiceImpl proxy = interceptor.getProxy(CylServiceImpl.class);

        proxy.add();
    }
}
