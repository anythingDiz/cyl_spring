import com.alibaba.fastjson.JSON;
import com.cyl.demo.CylSpringApplication;
import com.cyl.demo.beanLifecycle4BeanFactory.BeanLifecycleDemo;
import com.cyl.demo.beanLifecycle4BeanFactory.MyBeanPostProcesser;
import com.cyl.demo.beanLifecycle4BeanFactory.MyInstantiationAwareBeanPostProcesser;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * bean的生命周期
 *  1> 调用 InstantiationAwareBeanPostProcesser.postProcessBeforeInstantiation()
 *  2> 实例化
 *  3> 调用 InstantiationAwareBeanPostProcesser.postProcessAfterInstantiation()
 *  4> 调用 InstantiationAwareBeanPostProcesser.postProcessPropertyValue()
 *  5> 设置属性
 *
 *  6> 调用+ BeanNameAware.setBeanName()
 *
 *  7> 调用+ BeanFactoryAware.setBeanFactory()
 *
 *  8> 调用 BeanPostProcesser.postProcessBeforeInstantiation()
 *
 *  9> 调用+ InitializingBean.afterPropertiesSet()
 *
 *  10> 调用 init-method属性配置的初始化的方法
 *  11> 调用 BeanPostProcesser.postProcessAfterInitialization();
 *  12> 如果prototype 将准备就绪的Bean交给调用者;如果是Singleton 放入缓存池
 *  13>  (Singleton)调用 + DisposableBean的destroy
 *  14> (Singleton)调用destroy-method的属性配置的方法
 */
public class BeanLifeCycleTest {

    /**
     * 测试bean的生命周期
     */
    @Test
    public void testBeanLifecycle() {

        //获取beanFactory
        BeanFactory beanFactory = CylSpringApplication.getBeanFactory();

        //注册MyInstantiationAwarePostProcesser
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcesser());

        //注册MyPostProcesser
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcesser());

        BeanLifecycleDemo bean = beanFactory.getBean(BeanLifecycleDemo.class);

        System.out.println();
        bean.info();
        System.out.println();


        ((ConfigurableBeanFactory) beanFactory).destroySingletons();
    }
}
