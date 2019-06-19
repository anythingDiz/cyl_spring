package com.cyl.demo.beanLifecycleINBeanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcesser implements BeanPostProcessor {

    // 在调用init-method方法之前调用
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof BeanLifecycleDemo) {

            BeanLifecycleDemo demo = (BeanLifecycleDemo) bean;
            System.out.println(">> 调用BeanPostProcesser.postProcesserBeforeInitialization() -> 哈哈我要把name给改啦");
            demo.setName("哈哈颤抖吧");
        }

        return bean;

    }

    //在调用init-method之后调用
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof BeanLifecycleDemo) {
            BeanLifecycleDemo demo = (BeanLifecycleDemo) bean;

            System.out.println(">> 调用BeanPostProcesser.postProcesserAfterInitialization() -> 最后一次机会 我要吧age改了");
            demo.setAge(10000);
        }
        return bean;
    }
}
