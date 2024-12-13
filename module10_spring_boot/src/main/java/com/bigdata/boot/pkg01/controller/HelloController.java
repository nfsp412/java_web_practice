package com.bigdata.boot.pkg01.controller;

import com.bigdata.boot.pkg01.bean.Person;
import com.bigdata.boot.pkg01.bean.User;
import com.bigdata.boot.pkg01.config.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name HelloController
 * @create 2024/7/21 10:15
 */

//@Controller
//@ResponseBody
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String handle01() {
        return "Hello";
    }

    @RequestMapping("/hello1")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @Autowired
    public Car car;

    @RequestMapping("/car")
//    @ResponseBody
    public Car car() {
        System.out.println(car.brand);
        return car;
    }

    @Autowired
    @Qualifier("u1")
    public User user;

    @RequestMapping("/aaa")
    public String aaa() {
        System.out.println(user);
        return "aaa";
    }

    @Autowired
    public Person person;

    @RequestMapping("/person")
    @ResponseBody
    public Person person() {
        return person;
    }
}
