# 数据库事务
数据库事务的4个特性：原子性（atomic），一致性（consistency），隔离性（isolation）和持久性（durabily） 简称acid

# spring 对事务管理的支持
spring 为事务管理提供了一致的编程模板，在高层次建立了统一的事务抽象。
事务管理模板类TransactionTemplate。通过TransactionTemplate并配合使用事务回调TransactionCallback指定具体的持久化操作。

## spring 事务管理关键抽象
在spring 事务管理spi 的抽象层主要包含三个接口 PlatformTransactionManager,TransactionDefinition和 TransactionStatus.

- TransactioinDefinition: 用于描述事务的隔离级别、超时时间、是否为只读是事务和事务传播规则等控制事务具体行为的事务属性，这
写事务属性可以通过Xml配置或者注解描述，也可以通过手工编程的方式设置
    * 隔离级别
    * 传播行为
    * 事务超时
    * 只读状态
- PlatformTransactionManager 根据TransactionDefinition提供的事务属性配置信息创建事务，并呀ongoingTransactionStatus描述这
个激活事务的状态。
    * 三个接口方法
        * TransactionStatus getTransaction(TransactionDefinition definition): 该方法根据事务定义信息，从事务环境中返回一个已
        存在的事务，或者创建一个新的事务
        * void commit(TransactionStatus status): 根据事务的状态提交事务。如果事务状态已经被标识为rollback-only,则该方法将执行
        一个回滚事务的操作
        * void rollback(TransactionStatus status): 将事务回滚。当commit方法抛出异常，rollback方法会被隐士调用.
    * 实现类
        * JpaTransactionManager->jpa
        * HibernateTransactionManager->hibernate
        * DataSourceTransactionManager -> spring jdbc,mybatis
        * JdoTransactionManager -> Jdo
        * JtaTransactionManager -> 具有多个数据源的全局事务使用该事务管理器
        
- TransactionStatus ：代表一个事务的具体运行状态。事务管理器可以通过该接口获取事务运行期的状态信息,也可以通过该接口间接的
回滚事务,它相比于抛出异常时回滚事务的方式更具可控性。该接口继承于 SavepointManager接口
    * SavepointManager 接口拥有以下几个方法
        * Object createSavepoint()：创建一个保存点对象。
        * void rollbackToSavepoint(Object savePoint)：将事务回滚到特定的保存点上，被回滚的保存点将自动释放掉
        * void releaseSavepoint(Object savepoint): 释放一个保存点。如果事务提交，则所有的保存点会被自动释放，无须手工清除.
        
    * 扩展的方法
        * boolean hasSavepoint():判断当前事务是否在内部创建了一个保存点；
        * boolean isNewTransaction()：判断当前事务是否是一个新的事务。
        * boolean isCompleted(): 判断当前事务是否已经结束(已经提交或者回滚)
        * boolean isRollbackOnly():判断当前事务是否已经被标识为rollback-only;
        * void setRollbackOnly(): 将当前事务设置为rollback-only.

## spring 事务同步管理器
 Spring 将jdbc的connection，hibernate的session等访问数据库的连接或者会话对象统称为资源，这些资源在同一时刻是不能线程共享
 的。为了让Dao,Service类可以做到Singleton，Spring的事务同步管理器 org.springframework.tracsaction.support.TransactionSyn
 chronizationManager使用 ThreadLocal为不同的事务新城提供独立的资源副本。同步事务管理器是Spring事务管理的基础，不管用户使
 用的是编程式事务管理，还是声明式事务管理，都离不开事务同步管理器。
 
 Spring框架为不同的持久化技术提供了一套从TransactionSynchroinzationManager中获取对应线程绑定资源的工具类
    * springjdbc或者 mybatis ->DataSourceUtils
    * hibernate -> SessionFactoryUtils
    * Jpa -> EntityManagerFactoryUtils
    * jdo -> PersistenceManagerFactoryUtils
   
   
# spring声明式事务的实现

    * 根据命名空间找到相应的namespaceHandler -》TxNamespaceHandler 
    * 在TxNamespaceHandler的init方法中注册AnnotationDrivenBeanDefinitionParser
    * AnnotationDrivenBeanDefinitionParser的parse方法进行标签的解析
    * AopAutoProxyConfigurer.configureAutoProxyCreator(element, parserContext)