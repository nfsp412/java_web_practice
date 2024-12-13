package com.bigdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name HelloController
 * @create 2024/7/19 16:32
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String helloWorld() {
        return "target";
    }
}
