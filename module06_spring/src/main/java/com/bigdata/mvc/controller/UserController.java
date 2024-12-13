package com.bigdata.mvc.controller;

import com.bigdata.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name UserController
 * @create 2024/7/18 21:19
 */


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void handle01(){
        System.out.println(this.userService);
    }

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
