package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom");
        List<User> list = userService.list(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Tom")
                .select("name","id")
                .orderByDesc("id");
        List<User> list = userService.list(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test3() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id","10")
                .set("name","sunpeng");
        userService.update(wrapper);
    }



}
