package com.bigdata.boot.pkg02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name TestController
 * @create 2024/9/11 11:03
 */

@RestController
public class TestController {
    @RequestMapping("/w")
    public String handle01() {
        return "W";
    }
}

