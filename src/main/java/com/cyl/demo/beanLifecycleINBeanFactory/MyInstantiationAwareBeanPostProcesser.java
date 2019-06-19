package com.cyl.demo.beanLifecycleINBeanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcesser extends InstantiationAwareBeanPostProcessorAdapter {

    //在实例化bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        //只对BeanLifeCycleDemo 的 bean进行处理
        if(beanClass.isAssignableFrom(BeanLifecycleDemo.class)){
            System.out.println(">> 调用 InstantiationAwareBeanPostProcesser.postProcessBeforeInstantiation()");
        }

        return null;
    }

    // 在实例化bean之后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        //只对beanLifeCycleDemo 的bean进行处理

        if(bean instanceof BeanLifecycleDemo){
            System.out.println(">> 调用 InstantiationAwareBeanPostProcesser.postProcessAfterInstantiation()");
        }

        return true;
    }


    //在设置某个属性的时候调用
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {


        //只对beanLifeCycleDemo 的bean进行处理
        if(bean instanceof BeanLifecycleDemo){
            System.out.println(">> 调用InstantiationAwareBeanPostProcesser.postProcessProperties()");
        }

        return pvs;
    }


}
