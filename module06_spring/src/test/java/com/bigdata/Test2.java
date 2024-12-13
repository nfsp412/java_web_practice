package com.bigdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Test2
 * @create 2024/7/19 7:45
 */

//指定当前测试类Test2在Spring的测试环境中运行,此时就可以通过依赖注入直接获取IOC容器的bean对象
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:applicationContext1.xml")
public class Test2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test1() {
//        jdbcTemplate.query();
    }
}
