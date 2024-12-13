package org.example.boot.controller;

import org.example.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String handle01() {
        return "hello spring boot";
    }

    @RequestMapping("/test")
    public String handle02() {
        return "success";
    }

    @Autowired
    private Car car;

    @RequestMapping("/car")
    @ResponseBody
    public Car car(){
        return car;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        System.out.println(10/0);
        return "hello";
    }
}
