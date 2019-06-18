import com.cyl.demo.config.BeanConfig;
import com.cyl.demo.model.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  Spring 为基于注解的配置提供了专门的ApplicationContext 实现类
 *  AnnotationConfigApplicationContext
 *
 */
public class AnnotationConfigApplicationContextTest {

    /**
     * AnnotationConfigApplicationContext的使用
     */
    @Test
    public void testAnnotationConfigApplicationContext(){

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Car bean = context.getBean(Car.class);

        bean.info();
    }
}
