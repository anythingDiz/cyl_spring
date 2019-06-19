package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class ClasspathXmlApplicationContextTest {

    public void testClasspathXmlApplicationContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springAppContext.xml");

    }
}
