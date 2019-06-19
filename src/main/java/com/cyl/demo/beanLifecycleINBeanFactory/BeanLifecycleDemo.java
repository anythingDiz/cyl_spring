package com.cyl.demo.beanLifecycleINBeanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * 接口方法的调用顺序
 *  BeanNameAware
 *  BeanFactoryAware
 *  InitializationBean
 *  DisposableBean
 */
public class BeanLifecycleDemo implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private BeanFactory beanFactory;
    private String beanName;

    private String name;
    private int age;

    public BeanLifecycleDemo() {
        System.out.println(">> 调用默认构造方法");
    }

    public void setName(String name) {
        System.out.println(">> 调用setter方法");
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }




    // 1> BeanNameAware
    public void setBeanName(String beanName) {
        System.out.println(">> 调用 BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    // 2> BeanFactoryAware
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(">> 调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    // 3> InitializationBean
    public void afterPropertiesSet() throws Exception {
        System.out.println(">> 调用Initialization.afterPropertiesSet()");
    }

    // 4> DisposableBean
    public void destroy() throws Exception {
        System.out.println(">> 调用DisposableBean.destroy()");
    }

    //init-method
    public void myInit(){
        System.out.println(">> 调用init-method所指的MyInit() -> 设置age=10");
        this.age = 10;
    }


    //destroy-method
    public void myDestroy(){
        System.out.println(">> 调用destroy-method所指的myDestroy()");
    }

    public void info() {
        System.out.println("info:{name: "+name+", age: "+age+"}");
    }
}
