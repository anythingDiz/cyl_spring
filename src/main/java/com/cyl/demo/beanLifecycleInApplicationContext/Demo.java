package com.cyl.demo.beanLifecycleInApplicationContext;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class Demo implements BeanNameAware, ApplicationContextAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;
    private int age;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private String beanName;

    public Demo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public void setBeanName(String s) {

    }

    public void destroy() throws Exception {

    }

    public void afterPropertiesSet() throws Exception {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
