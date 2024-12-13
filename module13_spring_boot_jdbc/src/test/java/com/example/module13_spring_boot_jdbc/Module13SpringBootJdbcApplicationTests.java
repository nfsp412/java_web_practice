package com.example.module13_spring_boot_jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Module13SpringBootJdbcApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        String sql = "select count(1) from ssm.emp";
        Long rows = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(rows);
    }

}
