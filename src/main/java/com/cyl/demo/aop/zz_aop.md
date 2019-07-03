# AOP术语
## JoinPoint 连接点
连接点是程序执行的某个特定位置，如类开始初始化前、类初始化后、类的某个方法调用前/调用后或者方法抛出异常后。一个类或一段
代码拥有一些具有边界性质的特定点，被称为“连接点”。**spring仅支持方法的连接点，即仅能在方法调用前、方法调用后、方法抛出异
时以及方法调用前后**

## PointCut 切点
切点是用于查询连接点的查询条件。类比于数据库：连接点就相当于数据库中的记录，而切点相当于查询条件。连接点和切点不是一对一
的关系，一个切点可以匹配多个连接点。

##  Advice 增强
增强是织入目标类连接点上的一段程序代码。在spring中，增强除了用于描述一段程序代码外，还拥有另外一个和连接点相关的信息，这
便是执行点的方位。正因为增强既包含用于添加到目标连接点上的一段逻辑代码，有包含用于定位连接点的方位信息，所以Spring所提供
的增强接口都是带有方位名的。如：BeforeAdvice,AfterReturningAdvice,ThrowAdvice等。

## Target 目标对象 
增强逻辑的织入目标类。

## Introduction 引介
引介是一种特殊的增强，它为类添加一些属性和方法，这样，及时一个业务类原本没有实现某个接口，通过aop的引介功能，也可以动态的
为该业务类添加接口的实现逻辑，让业务类称为这个接口的实现类。

## Weaving 织入 
织入是将增强添加到目标类的具体链接点上的过程。根据不同的实现技术,aop有三种织入方式。
* 编译期织入，这要求使用特殊的java编译器
* 类装载期织入，这要求使用特殊的类装载器
* 动态代理织入，在运行期为目标类添加增强生成子类的方式

spring采用动态代理织入，而AspectJ采用编译织入和类装载织入

## Proxy 
一个类被aop织入增强后，就产生了一个结果类，它是融合了原类和增强逻辑的代理类。

## Aspect切面
切面由切点和增强组成，它即包括很切逻辑的定义，也包括连接点的定义。

# JDK动态代理
 jdk1.3后java提供了动态代理技术，允许开发者在运行期创建接口的代理实例.
 jdk的动态代理主要涉及java.lang.reflect包中的两个类Proxy和InvocationHandler.
 
 # spring增强
 * BeforeAdvice,前置增强
 * AfterReturningAdvice， 后置增强
 * MethodInterceptor，环绕增强
 * ThrowsAdvice，异常增强
 * IntroductionInterceptor, 环绕增强
 
 # AspecJ
 在使用AspectJ 之前， 首先必须保证所使用的java是5.0及以上版本，否则无法使用注解技术。spring在处理@Aspect注解表达式时，需
 将Spring的asm模块添加到类路径中。 asm 是轻量级的自己吗处理框架，因为java的放射机制无法获取入参名，spring就利用ams处理
 @AspectJ中所棉袄书的方法入参名。
 此外， spring采用AspectJ提供的@AspectJ注解类库以及相应的解析类库，需要在pom.xml文件中添加aspectj.weaver 和 aspectj.tools
 类包的依赖
 
 
 ## AspectJ语法基础
 
 ### 切点表达式
 aspectJ5.0 的切点表达式 由关键字和操作参数组成。如切点表达式execution(* greetTo(..)), execution为关键字，而"* greetTo(..)"
 为参数
 execution(<修饰符>? <返回值> <方法名>(<参数>) <异常>?) 
 除了 返回值，方法名 和参数外，其他都是可选的
 1. 通过方法签名定义切点
     * execution(public * *(..)):匹配所有目标类的public方法
     * execution(* *To(..))：匹配目标类所以以To为后缀的方法
     
 2. 通过类定义切点
    * execution(* com.smart.Waiter.*(..)):匹配Waiter接口的所有方法
    * execution(* com.smart.Waiter+.*(.))：匹配Waiter接口及所有实现类的方法
  
 3. 通过包定义切点
    * execution(* com.smart.*(..)):匹配com.smart包下所有类的所有方法
    * execution(* com.smart..*(..)):匹配com.smart包以及其子孙包下偶遇欧类的所有方法
 ### AspectJ 所提供的几个增强注解
 @Before 前置增强
    value: 该成员用于定义切点
    argNames:由于java无法通过反射获取方法入参名，所以如果java编译时未启用调试信息，或者需要在运行期解析切点，就必须通过
    这个成员指定注解所标注增强方法的参数名（注意二者名字必须完全相同）,多个参数名用逗号分隔
    
 @AfterReturning 后置增强
    value: 该成员用于定义切点
    pointcut:表示切点的信息, 如果显示指定poincut的值，那么它将覆盖value的设置值
    returning: 将目标对象方法的返回值绑定给增强的方法
    argNames:如前所述
    
 @Around 环绕增强
    value: 该成员用于定义切点
    argNames: 如前所述
    
 @AfterThrowing 异常增强
    value:
    pointcut:
    throwing: 将抛出的异常绑定到增强方法中
    argNames:
  
 @After:final增强，不管是抛出异常还是正常退出， 可以把他看成ThrowsAdvice和AfterReturningAdvice的混合物，一般用于释放资源。
    value:
    argNames:
 
 @DeclareParents 引介增强
    value: 该程艳用于定义切点，它标识在哪个目标类上添加引介增强
    defaultImpl:默认的接口实现类
    
    
 ### 访问连接点信息
 AspectJ 使用org.aspectj.lang.JoinPoint 接口标识目标类连接点对象。如果是环绕增强，则使用org.aspectJ.lang.ProceedingJoinPoint
 标识连接对象
 
 JoinPoint
    java.lang.Object[] getArgs() : 获取连接点方法运行时的入参列表
    Signature getSignature(): 获取连接点的方法签名对象
    java.lang.Object getTarget(): 获取连接点所在的目标对象
    java.lang.Object getThis(): 获取代理对象本身
    
 ProceedingJoinPoint 继承与JoinPoint，它新增了两个用于执行连接点的方法
    java.lang.Object proceed() throws java.lang.Throwable ：通过反射执行目标对象的连接点处的方法
    java.lang.Object proceed(Object[] args) throws java.lang.Throwable: 通过反射执行目标对象连接点出的方法，不过使用新的
    入参替换原来的入参
    
    
 # JVM class 文件字节码转换基础知识
 
 ## java.lang.instrument
 java5.0 新增了一个java.lang.instrument包，该包中有两个能对jvm底层组件进行访问的类.具体的说，就是通过jvm的 -javaagent 代
理参数在启动时获取jvm内部组件的引用,以便在后续流程中使用.借助jdk动态代理，可以在jvm启动时装配并应用ClassTransformer,对字
节码进行转换，实现aop功能
两个重要接口
 ClassFileTransformer: Class文件转换器接口.
 Instrumentation: 代表jvm内部的一个组件。可以通过该接口的方法向jvm的内部“组件” 注册一些ClassFileTransformer.