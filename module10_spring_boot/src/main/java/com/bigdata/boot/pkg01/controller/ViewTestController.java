package com.bigdata.boot.pkg01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name ViewTestController
 * @create 2024/9/19 16:25
 */

@Controller
public class ViewTestController {
    @GetMapping("/atguigu_20240919")
    public String atguigu(Model model) {
        model.addAttribute("msg", "hello");
        model.addAttribute("link","http://www.baidu.com");
        return "success_20240919";
    }
}

