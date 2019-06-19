package com.cyl.demo;

import com.alibaba.fastjson.JSON;
import com.cyl.demo.model.Cat;
import com.cyl.demo.model.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class CylSpringApplication {
    private static final String CLASSPATH_PREFIX = "classpath:";
    private static final String FILE_PATH = "springAppContext.xml";

    private static final String config = CLASSPATH_PREFIX+FILE_PATH;

    //获取BeanFactory
    public static BeanFactory getBeanFactory(){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource(config);

        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);

        reader.loadBeanDefinitions(resource);

        return  bf;
    }

    public static void main(String[] args) {
        Person person =(Person) getBeanFactory().getBean("person");
        Cat cat = person.getCat();
        Cat cat1 = person.getCat();

        System.out.println(cat);
        System.out.println(cat1);
        System.out.println(cat.equals(cat1));
    }
}
