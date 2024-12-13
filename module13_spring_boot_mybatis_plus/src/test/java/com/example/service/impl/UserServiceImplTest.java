package com.example.service.impl;

import com.example.pojo.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void test1() {
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void test2() {
        User user = new User(null,"ww",11,"ww");
        userService.saveOrUpdate(user);
    }

    @Test
    public void test3() {
        User user = new User(8L,"wwwwww",11,"ww");
        userService.saveOrUpdate(user);
    }

    @Test
    public void test6() {
        User user1 = new User(null,"wwwwww",11,"ww");
        User user2 = new User(null,"wwwwww",11,"ww");
        List<User> users = Arrays.asList(user1, user2);
        userService.saveBatch(users);
    }


    @Test
    public void test4() {
//        List<User> users = userService.getBaseMapper().selectList(null);
        List<User> users = userService.list();
        users.forEach(System.out::println);
    }

    @Test
    public void test5() {
        userService.removeById(8);
    }

}