package com.example.module18_spring_boot_redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Module18SpringBootRedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        System.out.println(redisTemplate);
    }

    @Test
    void test1() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("k1","v1");
    }

    @Test
    void test2() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String o =(String) valueOperations.get("k1");
        System.out.println(o);
    }

    @Test
    void test3() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.increment("abc");
    }

    @Test
    void test4() {
        stringRedisTemplate.opsForValue().set("username","zs");
    }

}
