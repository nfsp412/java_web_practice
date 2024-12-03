package com.java.web.practice.tomcat.dao.impl;

import com.java.web.practice.tomcat.dao.BaseDao;
import com.java.web.practice.tomcat.dao.SysUserDao;
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

public class SysUserDaoImpl extends BaseDao<SysUser> implements SysUserDao {
    @Override
    public int insert(Connection connection, SysUser sysUser) {
        String sql = "insert into sys_user(username,password) values (?, ?)";
        return update(connection, sql, sysUser.getUsername(), sysUser.getPassword());
    }

    @Override
    public int deleteById(Connection connection, int id) {
        String sql = "delete from sys_user where uid = ?";
        return update(connection, sql, id);
    }

    @Override
    public int updateById(Connection connection, SysUser sysUser) {
        String sql = "update sys_user set username = ?, password = ? where uid = ?";
        return update(connection, sql, sysUser.getUsername(), sysUser.getPassword(), sysUser.getUid());
    }

    @Override
    public SysUser getSysUserById(Connection connection, int id) {
        String sql = "select uid, username, password from sys_user where uid = ?";
        return query(connection, sql, id);
    }

    @Override
    public List<SysUser> getAll(Connection connection) {
        String sql = "select uid, username, password from sys_user";
        return queryList(connection, sql);
    }

    @Override
    public Object getUsernameById(Connection connection, int id) {
        String sql = "select username from sys_user where uid = ?";
        return queryValue(connection, sql, id);
    }

    @Override
    public SysUser getSysUserByUsername(Connection connection, String username) {
        String sql = "select uid, username, password from sys_user where username = ?";
        return query(connection, sql, username);
    }
}
