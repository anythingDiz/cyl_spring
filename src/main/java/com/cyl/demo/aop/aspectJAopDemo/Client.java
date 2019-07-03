package com.cyl.demo.aop.aspectJAopDemo;

import com.cyl.demo.aop.service.NativeWaiter;
import com.cyl.demo.aop.service.Waiter;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/2
 */
public class Client {

    public static void main(String[] args) {
//        codeMode();
        xmlMode();
    }
    
    // 编码的方式使用 aspectJ
    public static void codeMode(){
        Waiter target = new NativeWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        
        //设置目标对象
        factory.setTarget(target);
        
        // 添加切面
        factory.addAspect(CylAspect.class);
        
        // 生成织入切面的代理对象
        Waiter proxy = factory.getProxy();

        proxy.greetTo("caoyulong");
        System.out.println();
        proxy.hello("caoyulong");

    }

    public static void xmlMode(){
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("aopAspectJDemo2.xml");

        Waiter waiter = (Waiter) application.getBean("waiter");

        waiter.hello("caoyulong");
//        waiter.giveTo("caoyulong");
    }
    
}
