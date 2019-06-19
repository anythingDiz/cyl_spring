package ioc;

/**
 * @Description  ApplicationContext 中bean的生命周期
 *  Bean在ApplicationContext 中的生命周期和在BeanFactory中的生命周期类似。
 *  不同的是：  1》 如果Bean实现了ApplicationContextAware接口，则会增加一个调用该接口的方法setApplicationContext()的步骤
 *              2》 此外如果配置文件中声明了BeanFactoryPostProcesser接口的实现类，则应用上下文在装载配置配置文件之后，初始化
 *              Bean的实例之前将调用这些BeanFactoryPostProcesser对配置信息进行处理
 *              3》 ApplicationContext会利用java反射 机制自动识别出配置文件中定义的BeanPostProcesser,InstantiationAwareBeanPostProcesser
 *              和BeanFactoryPostProcesser，并且将他们注册到应用上下文中。  BeanFactory需要手动注入
 *
 *
 *   Bean 在ApplicationContext中的生命周期
 *      1> 调用BeanFactoryPostProcesser.postProcessBeanFactory;
 *      2> 调用 InstantiationAwareBeanPostProcesser.postProcessBeforeInstantiation()
 *      3> 实例化
 *      4> 调用 InstantiationAwareBeanPostProcesser.postProcessAfterInstantiation()
 *      5> 调用 InstatiationAwareBeanPostProcesser.postProcessProperties();
 *      6> 设置属性
 *      7> 调用 BeanNameAware.setBeanName();
 *      8> 调用 BeanFactoryAware.setBeanFactory()
 *      9> 调用 ApplicationContextAware.setApplicationContext()
 *      10> 调用 BeanPostProcesser.postProcessBeforeInitialization();
 *      11> 调用InitializatingBean.afeterPropertiesSet()
 *      12> 调用 init-method 属性配置初始化方法
 *      13> 调用 BeanPostProcesser.postProcessAfterInitialization()
 *      14> prototype的类型的bean -> 将准备好的bean交给调用者\
 *      15> singleton 类型的 Bean放入spring缓存池中
 *      16> singleton 调动DisposableBean.destroy()方法
 *      17> singleton类型的bean 调用destroy-method属性配置的销毁方法
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class BeanLifecycleInApplicationContext {
}
