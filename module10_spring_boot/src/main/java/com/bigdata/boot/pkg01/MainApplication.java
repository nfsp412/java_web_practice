package com.bigdata.boot.pkg01;

import com.bigdata.boot.pkg01.bean.Bean1;
import com.bigdata.boot.pkg01.bean.User;
import com.bigdata.boot.pkg01.config.Car;
import com.bigdata.boot.pkg01.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name MainApplication
 * @create 2024/7/21 10:14
 */

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = "com.bigdata.boot")
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.bigdata.boot")
public class MainApplication {
    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class, args);

        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

//        String[] beans = run.getBeanDefinitionNames();

//        Bean1 bean = run.getBean("bean1", Bean1.class);
//        System.out.println(bean);

//        String[] names = run.getBeanNamesForType(User.class);
//        Arrays.stream(names).forEach(System.out::println);
//
//        System.out.println(run.getBean("bean1", Bean1.class));
//
//        System.out.println(run.containsBean("tom"));
//        System.out.println(run.containsBean("u2"));

//        Car car = run.getBean("car", Car.class);
//        System.out.println(car);


    }
}
