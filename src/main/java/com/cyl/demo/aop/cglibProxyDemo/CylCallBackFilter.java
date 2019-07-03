package com.cyl.demo.aop.cglibProxyDemo;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/3
 */
public class CylCallBackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("greetTo")){
            return 0;
        }else{
            return 1;
        }
    }
}
