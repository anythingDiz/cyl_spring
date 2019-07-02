package com.cyl.demo.aop.springAop;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/1
 */
public class NativeWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println(">> 执行了greetTo方法");
    }

    @Override
    public void serveTo(String name) {
        System.out.println(">> 执行了 serveTo方法");
    }

    @Override
    public String giveTo(String name) {
        System.out.println(">> 执行了 giveTo 方法");
        return "give you a book";
    }
}
