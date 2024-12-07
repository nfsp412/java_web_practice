package org.example;

import org.example.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app.xml")
public class TestJdbcTemplate {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationContext ac;

    @Test
    public void test1() {
        UserController bean = ac.getBean(UserController.class);
        bean.handle(null,null);
    }

    @Test
    public void insert() {
        String sql = "insert into ssm.t_user (username, password) values(?, ?)";
        int rows = jdbcTemplate.update(sql, "zs", "000");
        System.out.println(rows);
    }
}
