package com.bigdata.boot.pkg01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name StaticController
 * @create 2024/7/21 20:27
 */

@RestController
public class StaticController {
    @RequestMapping("/test1.html")
    public String hello() {
        return "a";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "get";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String postUser() {
        return "post";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "put";
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String delUser() {
        return "del";
    }
}
