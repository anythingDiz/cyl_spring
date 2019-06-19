package com.cyl.demo.model;

import lombok.Data;

@Data
public class Person {
    Integer age;
    String name;
    private Cat cat;

    public void say(){
        System.out.println(">> hello");
    }

    public Cat getCat() {
        return cat;
    }

    public void info(){
        System.out.println(">> info: {name: "+name+", age: "+age+"}");
    }

}
