package ioc;

import com.cyl.demo.beanLifecycleINBeanFactory.BeanLifecycleDemo;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/18
 */
public class XmlBeanFactoryTest {
    private String name;
    private static final String CLASSPATH_PREFIX = "classpath:";
    private static final String FILE_PATH = "springAppContext.xml";

    /* bean 标签的属性 id name class parent scope abstract:boolean lazy-init:boolean autowire depends-on
     *  autowire-candidate:boolean primary:boolean init-method destroy-method factory-method factory-bean
     *
     * bean 标签的子标签
     *
     * ioc 注入类型 构造方法注入，setter注入，接口注入
     *
     */

    @Test
    public void testXmlBeanFactoryTest() throws IOException {


        //ClassPathResource resource = new ClassPathResource("springAppContext.xml");
        //XmlBeanFactory factory = new XmlBeanFactory(resource);

        // XmlBeanFactory 已经弃用，建议使用 XmlBeanDefinitionReader 和 DefaultListableBeanFactory替换
        String configPath = CLASSPATH_PREFIX+FILE_PATH;

        //获取配置文件资源
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource(configPath);

        // 创建BeanFactory 和 XmlBeanDefinitionReader
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);

        //加载配置文件
        reader.loadBeanDefinitions(resource);

        System.out.println(">> Init BeanFactory");

//        Person person = bf.getBean("person", Person.class);
//        System.out.println(">> car bean is read for use");
//        person.info();

        BeanLifecycleDemo bean = bf.getBean(BeanLifecycleDemo.class);
        bf.getBean("name");
        bean.info();


    }
}
