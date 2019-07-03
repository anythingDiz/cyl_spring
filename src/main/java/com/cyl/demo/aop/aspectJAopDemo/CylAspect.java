package com.cyl.demo.aop.aspectJAopDemo;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/2
 */

@Aspect // 通过该注解将CylAspectJAspect 标识为一个切面
public class CylAspect {

    //对切点进行命名
    @Pointcut("execution(* greetTo(..))")
    public void process(){};

    @Pointcut("@annotation(com.cyl.demo.aop.aspectJAopDemo.NeedTest)")
    public void processAnnotation(){}

    // 定义切点和增强类型 前置增强
    @Before("process()")
    public void before(){ // 增强的横切逻辑
        System.out.println(">> How are you");
    }

    @Around("processAnnotation()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(">> --------------joinPointAccess----------");

        System.out.println(">> args: " + JSON.toJSONString(pjp.getArgs()));
        Signature signature = pjp.getSignature();
        System.out.println(">> signature:" + pjp.getTarget().getClass());
        pjp.proceed(new String[]{"hh"});

        System.out.println(">> --------------joinPointAccess----------------");
    }

    @AfterReturning(value = "processAnnotation()", returning = "resVal")
    public void returnValue(String resVal ){
        System.out.println(">> 返回的结果为："+ resVal);
    }
}
