package com.bigdata.boot.pkg01.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Car
 * @create 2024/7/21 17:34
 */

@ConfigurationProperties(prefix = "mycar")
//@Component
//@Configuration
public class Car {
    @Value("${mycar.brand}")
    public String brand;

    @Value("${mycar.price}")
    public Double price;

//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
