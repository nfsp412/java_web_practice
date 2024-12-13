package com.example.mappers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void test3() {
        User user = new User(null,"zs",11,"zs@111");
        int rows = userMapper.insert(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void test4() {
        User user = new User(7L, "ls", null, null);
        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

    @Test
    public void test5() {
        int rows = userMapper.deleteById(7);
        System.out.println(rows);
    }

}