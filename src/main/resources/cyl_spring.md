
## Ioc 容器中装载Bean
### 基本配置
* 装配bean

```xml
    <bean id="person" class="com.cyl.demo.model.Person">
        <property name="age" value="12" />
        <property name="name" value="caoyulong" />
    </bean>
```
 * bean的命名    
spring 配置文件中不允许出现两个相同的**id**，但是却可以出现两个相同的**name** 。 如果存在多个name
相同的<bean>，那么通过getBean(beanName)获取bean时，将返回后面声明的那个bean。原因是后面的bean覆盖
了前面同名的bean


### 依赖注入
spring 支持三种注入方式，分别是**属性注入** ，**构造函数注入** 和 **工厂方法注入**

#### 属性注入
属性注入要求Bean提供一个默认的构造函数，并为需要注入的属性提供Setter方法
> javaBean对于属性变量名的要求 ：java 的属性变量名一般以小写字母开头，但也存在特许情况，但是需要满足“变量的前两个字母
要么全部大写，要么全部小写”

#### 构造方法注入
构造方法注入的前提是**Bean必须提供带参的构造函数**