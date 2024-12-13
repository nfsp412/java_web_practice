package com.bigdata.boot.pkg01.controller;

import com.bigdata.boot.pkg01.bean.People;
import com.bigdata.boot.pkg01.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name ResponseControllerTest
 * @create 2024/9/13 14:21
 */

//@RestController
@Controller
public class ResponseControllerTest {
    @GetMapping("/get/people")
    @ResponseBody
    public People getPeople() {
        People people = new People();
        people.setUser("a");
        people.setPassword("123");
        people.setPet(new Pet("aaa", 11.1));
        return people;
    }
}
