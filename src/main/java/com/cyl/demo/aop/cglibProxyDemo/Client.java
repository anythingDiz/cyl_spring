package com.cyl.demo.aop.cglibProxyDemo;

import com.cyl.demo.aop.service.CylServiceImpl;
import com.cyl.demo.aop.service.NativeWaiter;
import com.cyl.demo.aop.service.Waiter;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
//        CylMethodInterceptor<CylServiceImpl> interceptor = new CylMethodInterceptor<>();
//
//        CylServiceImpl proxy = interceptor.getProxy(CylServiceImpl.class);
//
//        proxy.add();
        advancedUse();
    }

    /**
     * 高級用法使用了CallbackFilter
     */
    public static void advancedUse(){
//        Waiter target = new NativeWaiter();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NativeWaiter.class);
        enhancer.setCallbackFilter(new CylCallBackFilter());
        Callback[] callbacks = new Callback[]{new CylMethodInterceptor<>(), new CylMethodInterceptor1()};
        enhancer.setCallbacks(callbacks);

        Object o = enhancer.create();
        if(o instanceof NativeWaiter){
            NativeWaiter waiter = (NativeWaiter) o;
            waiter.greetTo("caoyulong");
            System.out.println("=============================");
            waiter.hello("caoyulong");
        }

    }
}
