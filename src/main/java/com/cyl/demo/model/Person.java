package com.cyl.demo.model;

import lombok.Data;

@Data
public class Person {
    Integer age;
    String name;

    public void say(){
        System.out.println(">> hello");
    }

    public void info(){
        System.out.println(">> info: {name: "+name+", age: "+age+"}");
    }

}
