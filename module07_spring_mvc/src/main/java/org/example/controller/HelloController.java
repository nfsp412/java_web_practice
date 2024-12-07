package org.example.controller;

import org.example.pojo.User;
import org.example.utils.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/test1")
    public String test1(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return "success";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/test3")
    public String test3(HttpServletRequest request){
        User user = WebUtil.readJson(request, User.class);
        System.out.println(user);
        return "success";
    }
}
