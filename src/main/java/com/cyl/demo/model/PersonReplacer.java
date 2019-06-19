package com.cyl.demo.model;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class PersonReplacer implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(">> 我被调用啦");
        Random random = new Random(12);
        Cat cat = new Cat();
        cat.setName("herry");
        cat.setAge(random.nextInt());
        System.out.println(">> "+cat);
        return cat;
    }
}
