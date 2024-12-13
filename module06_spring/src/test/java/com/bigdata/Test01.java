package com.bigdata;

import com.alibaba.druid.pool.DruidDataSource;

import com.bigdata.aop.CalculatorImpl;
import com.bigdata.aop.ProxyFactory;
import com.bigdata.aop.aspectj1.CalculatorPureImpl;
import com.bigdata.aop.aspectj1.Calculator;
import com.bigdata.factory.UserA;
import com.bigdata.input.Person;
import com.bigdata.ioc.MyAbstractClass;
import com.bigdata.ioc.MyInterface;
import com.bigdata.ioc.User;
import com.bigdata.mvc.controller.UserController;
import com.bigdata.special.People;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Test01
 * @create 2024/7/18 17:28
 */

public class Test01 {
    @Test
    public void test1() {
        System.out.println("spring");
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        User bean = applicationContext.getBean("user", User.class);
        System.out.println(bean);
        applicationContext.close();
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        //id+class
        User bean = applicationContext.getBean("user", User.class);
        //id
        User bean1 = (User) applicationContext.getBean("user");
        //class
        User bean2 = applicationContext.getBean(User.class);
        System.out.println(bean);
        applicationContext.close();
    }

    @Test
    public void test4() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        MyAbstractClass bean = applicationContext.getBean(MyAbstractClass.class);
        MyInterface bean1 = applicationContext.getBean(MyInterface.class);
    }

    @Test
    public void test5() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Person p1 = applicationContext.getBean("p1", Person.class);
        System.out.println(p1);
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Person p2 = applicationContext.getBean("p2", Person.class);
        System.out.println(p2);
    }

    @Test
    public void test7() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        People bean = applicationContext.getBean(People.class);
        System.out.println(bean);
    }

    @Test
    public void test8() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        DataSource bean = applicationContext.getBean(DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test9() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserA bean = applicationContext.getBean(UserA.class);
        System.out.println(bean);
    }

    @Test
    public void test10() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserController bean = applicationContext.getBean(UserController.class);
        bean.handle01();
        applicationContext.close();
    }

    @Test
    public void test11() throws SQLException {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        //虽然不知道proxy对应的类型,但是由于该方法实现目标对象接口了,所以可以写目标对象接口类型
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
    }

    @Test
    public void test12() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        //应该通过代理对象而不是目标对象访问,但是代理对象不知道是什么类型,所以可以通过目标对象实现的接口获取
//        CalculatorPureImpl bean = applicationContext.getBean(CalculatorPureImpl.class);
        Calculator bean = applicationContext.getBean(Calculator.class);
        System.out.println(bean.add(1, 2));
    }

    @Test
    public void test13() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        JdbcTemplate bean = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        //增删改
//        bean.update("");
        //查询单条
//        bean.queryForObject("",new BeanPropertyRowMapper<>(XXX.class, 1));
        //查询多条
//        bean.query("", new BeanPropertyRowMapper<>(XXX.class));
        //查询单值
//        bean.queryForObject("", Integer.class);
    }
}
