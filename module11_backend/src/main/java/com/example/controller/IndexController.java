package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView main(String username,
                             String password,
                             HttpSession session,
                             ModelAndView modelAndView) {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && "111".equals(password)) {
            session.setAttribute("username", username);
            modelAndView.setViewName("redirect:/main.html");
        } else {
            modelAndView.addObject("msg", "error");
            modelAndView.addObject("code", "404");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @GetMapping("/main.html")
    public ModelAndView mainPage(HttpSession session
            , ModelAndView modelAndView) {
        if (session.getAttribute("username") != null) {
            modelAndView.setViewName("main");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
