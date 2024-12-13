package com.example.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mappers.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PageTest {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1() {
        Page<User> page = new Page<>(2,3);
//        List<User> list = userService.list(page);
//        list.forEach(System.out::println);
        userService.page(page);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }

    @Test
    public void test2() {
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }

    @Test
    public void test3() {
        Page<User> page = new Page<>(2,3);
        userMapper.selectCustomer(page);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }

    @Test
    public void test4() {
        Page<User> page = new Page<>(2,3);
        userMapper.selectUserPage(page);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }
}
