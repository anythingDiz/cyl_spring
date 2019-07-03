package com.cyl.demo.aop.aspectJAopDemo;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface NeedTest {
    /**
     * 是否需要进行增强
     * @return
     */
    boolean value() default true;
}
