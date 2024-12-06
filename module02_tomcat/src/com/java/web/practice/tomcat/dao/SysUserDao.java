package com.java.web.practice.tomcat.dao;

import com.java.web.practice.tomcat.pojo.SysUser;

import java.sql.Connection;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserDao
 * @create 2024/12/3 13:41
 */

public interface SysUserDao {
    int insert(Connection connection, SysUser sysUser);

    int deleteById(Connection connection, int id);

    int updateById(Connection connection, SysUser sysUser);

    SysUser getSysUserById(Connection connection, int id);

    List<SysUser> getAll(Connection connection);

    Object getUsernameById(Connection connection, int id);

    SysUser getSysUserByUsername(Connection connection, String username);

}
