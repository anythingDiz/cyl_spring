package com.cyl.demo;

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

    public static BeanFactory getBeanFactory(){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource(config);

        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);

        reader.loadBeanDefinitions(resource);

        return  bf;

    }
}
