package com.cyl.demo.aop.springAop;

import com.cyl.demo.aop.service.NativeWaiter;
import com.cyl.demo.aop.service.Waiter;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 前置增强的测试类
 */
public class Client {


    public static void main(String[] args) {

        xmlMode();

    }


    /**
     * 编码方式使用aop
     */
    public static void hardCode(){

        Waiter target = new NativeWaiter();
        BeforeAdvice advice = new CylBeforeAdvice();

        //spring 提供的代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();

        //设置代理目标
        proxyFactory.setTarget(target);

        //为代理目标设置增强
        proxyFactory.addAdvice(advice);

        // 生成代理实例
        Waiter proxy = (Waiter) proxyFactory.getProxy();

        proxy.greetTo("caoyulong");
    }



    /**
     * xml配置方式
     */
    public static void xmlMode(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("aopDemo.xml");

        Waiter waiter = (Waiter) applicationContext.getBean("waiter");
        String result = waiter.giveTo("caoyulong");

        System.out.println(result);
        waiter.hello("caoyulong");

    }

}
