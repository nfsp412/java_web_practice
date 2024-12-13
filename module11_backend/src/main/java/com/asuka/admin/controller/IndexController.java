package com.asuka.admin.controller;

import com.asuka.admin.bean.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name IndexController
 * @create 2024/9/19 17:26
 */

@Controller
public class IndexController {
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        // 接收前端form表单传参,封装到pojo类
        if (StringUtils.isNotEmpty(user.getUsername()) && StringUtils.isNoneEmpty(user.getPassword())) {
            //登录成功,用户信息存储到session
            session.setAttribute("loginUser", user);
            //重定向到跳转主页
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            model.addAttribute("code", "409");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        //在这里需要判断是否登录,即session中是否有数据,一般要使用拦截器,这里为了简单演示
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            //登录成功
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            model.addAttribute("code", "408");
            return "login";
        }
    }

//    @PostMapping("/login")
//    public String main(String username, String password) {
//        return "main";
//    }
}
