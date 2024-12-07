package com.asuka.test.mybatis.mapper;

import com.asuka.practice.mybatis.mappers.UserMapper;
import com.asuka.practice.mybatis.pojo.Emp;
import com.asuka.practice.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserMapper {
    private SqlSession session;
    private UserMapper userMapper;
    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession(true);
        userMapper = session.getMapper(UserMapper.class);
    }
    /**
     * int insertUser();
     */
    @Test
    public void testInsertUser(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int rows = userMapper.insertUser();
        System.out.println("insert rows is " + rows);

    }

    /**
     * int deleteUser();
     */
    @Test
    public void testDeleteUser(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int rows = userMapper.deleteUser();
        System.out.println("delete rows is " + rows);
    }

    /**
     * int updateUser();
     */
    @Test
    public void testUpdateUser(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int rows = userMapper.updateUser();
        System.out.println("update rows is " + rows);
    }

    /**
     * User getUserById();
     */
    @Test
    public void testGetUserById(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User userById = userMapper.getUserById();
        System.out.println(userById);
    }

    /**
     * List<User> getUserList();
     */
    @Test
    public void testGetUserList(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetUserById1(){
        User userById = userMapper.getUserById1(2);
        System.out.println(userById);
    }

    @Test
    public void testStep1(){
        Emp emp = userMapper.step1(1);
        System.out.println(emp);
    }

    @Test
    public void testLazy(){
        Emp emp = userMapper.step1(1);
        String gender = emp.getGender();
        System.out.println(gender);
    }

    @Test
    public void testOne() {
        User u1 = userMapper.getUserById1(1);
        System.out.println(u1);

        User u2 = userMapper.getUserById1(1);
        System.out.println(u2);
    }

    @Test
    public void testTwo() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //s1
        SqlSession session1 = sqlSessionFactory.openSession(true);
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        User u1 = mapper1.getUserById1(2);
        System.out.println(u1);
        session1.close();
        //s2
        SqlSession session2 = sqlSessionFactory.openSession(true);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User u2 = mapper2.getUserById1(2);
        System.out.println(u2);
        session2.close();
    }
}
