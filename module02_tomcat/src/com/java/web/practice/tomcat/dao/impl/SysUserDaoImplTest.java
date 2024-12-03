package com.java.web.practice.tomcat.dao.impl;

import com.java.web.practice.tomcat.pojo.SysUser;
import com.java.web.practice.tomcat.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserDao
 * @create 2024/12/3 13:41
 */

public class SysUserDaoImplTest {
    private SysUserDaoImpl dao = new SysUserDaoImpl();
    private Connection connection = JDBCUtil.getConnection();

    @Test
    public void insert() {
        int i = dao.insert(connection, new SysUser("zs", "123"));
        System.out.println(i);
    }

    @Test
    public void deleteById() {
        int i = dao.deleteById(connection, 3);
        System.out.println(i);
    }

    @Test
    public void updateById() {
        int i = dao.updateById(connection, new SysUser(4, "lll", "ssss"));
        System.out.println(i);
    }

    @Test
    public void getSysUserById() {
        SysUser sysUser = dao.getSysUserById(connection, 1);
        System.out.println(sysUser);

    }

    @Test
    public void getAllById() {
        List<SysUser> all = dao.getAll(connection);
        all.forEach(System.out::println);
    }

    @Test
    public void getUsernameById() {
        Object username = dao.getUsernameById(connection, 1);
        System.out.println(username.toString());
    }

    @Test
    public void getSysUserByUsername() {
        SysUser sysUser = dao.getSysUserByUsername(connection, "zs");
        System.out.println(sysUser);
    }

}
