import com.cyl.demo.model.Car;
import com.cyl.demo.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
    private static final String CLASSPATH_PREFIX = "classpath:";
    private static final String FILE_PATH = "springAppContext.xml";

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

        Person person = bf.getBean("person", Person.class);
        System.out.println(">> car bean is read for use");
        person.info();

    }
}
