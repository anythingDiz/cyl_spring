package com.cyl.demo.aop.springAop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Description 异常增强
 *  ThrowsAdvice 接口没有定义任何方法，它是一个标签接口，在运行期Srping使用反射机制自行判断，必须采用以下标签形式定义异
 *  常抛出的增强方法
 *   void afterThrowing(Method method, Object[] args, Object target, Throwable throwable);
 *   方法名必须为 afterThrowing, 方法入参规定如下：前3个入参Method method,Object[] args, Object target 是可选的（3个参数
 *   要么全提供，要么全不提供）， 而最后一个参数是Throwable 或其子类。 如以下方法都是合法的
 *   afterThrowing(SQLException e).
 *   afterThrowing(RuntimeException e)
 *   afterThrowing(Method method, Object[] args, Object target, RuntimeException e)
 *
 *   可以在同一个异常增强中定义多个afterThrowing()方法，当目标方法抛出异常时，spring会自动选用最匹配的增强方法。假设增强
 *   中定义了两个方法
 *   afterThrowing(SQLException e)
 *   afterThrowing(Throwable e)
 *
 *   当目标方法抛出一个SQLException时，将调用afterThrowing(SQLException e)进行增强
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/2
 */
public class CylThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target , Exception ex){
        System.out.println(">> ====================================");
        System.out.println(">> method: " + method.getName());
        System.out.println(">> 抛出异常：" + ex.getMessage());
        System.out.println(">> 成功回滚事务");
    }

}
