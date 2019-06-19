package com.cyl.demo.beanLifecycleInApplicationContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        System.out.println(">> 调用BeanFactoryPostProcesser.postProcessBeanFactory()");

        BeanDefinition bd = bf.getBeanDefinition("demo");
        bd.getPropertyValues().addPropertyValue("name","laoshihao");
    }
}
