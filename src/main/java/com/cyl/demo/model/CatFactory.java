package com.cyl.demo.model;

import lombok.Data;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
@Data
public class CatFactory {
    //非静态工厂方法
    public Cat getCat(){
        Cat cat = new Cat();
        cat.setAge(19);
        cat.setName("tom");

        return cat;
    }

    // 静态方法
    public static Cat getCat2(){
        Cat cat = new Cat();
        cat.setAge(20);
        cat.setName("tom");

        return cat;
    }
}
