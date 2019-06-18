package com.cyl.demo.config;

import com.cyl.demo.model.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Car car(){
        Car car = new Car();
        car.setBrand("bwm");
        car.setColor("red");
        car.setMaxSpeed(120);

        return car;
    }
}
