package com.cyl.demo.model;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void info(){
        System.out.println(JSON.toJSONString(this));
    }
}
