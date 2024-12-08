package org.example.controller;

import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {
    @Autowired()
    @Qualifier("userServiceImpl")
    private UserService service;

    public void handle(HttpServletRequest request, HttpServletResponse response){
        System.out.println(this.service);
        System.out.println("handle");
    }

//    public void setService(UserService service) {
//        this.service = service;
//    }
}
