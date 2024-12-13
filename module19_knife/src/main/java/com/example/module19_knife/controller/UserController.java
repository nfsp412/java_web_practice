package com.example.module19_knife.controller;

import com.example.module19_knife.pojo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户信息")
public class UserController {

    @GetMapping("/h1")
    @Operation(summary = "返回用户")
    public User handler01(@Parameter(description = "用户ID") @RequestParam("id") Integer id) {
        User user = new User("zs","111");
        return user;
    }
}
