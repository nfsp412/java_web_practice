package com.java.web.practice.tomcat.service.impl;

import com.java.web.practice.tomcat.dao.SysUserDao;
import com.java.web.practice.tomcat.dao.impl.SysUserDaoImpl;
import com.java.web.practice.tomcat.pojo.SysUser;
import com.java.web.practice.tomcat.service.SysUserService;
import com.java.web.practice.tomcat.util.JDBCUtil;

import java.sql.Connection;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserServiceImpl
 * @create 2024/12/3 15:34
 */

public class SysUserServiceImpl implements SysUserService {
    private Connection connection = JDBCUtil.getConnection();
    private SysUserDao dao = new SysUserDaoImpl();

    @Override
    public int register(SysUser sysUser) {
        //判断是否用户名存在
        List<SysUser> all = dao.getAll(connection);
        for (SysUser user : all) {
            if (user.getUsername().equals(sysUser.getUsername())) {
                //重复的用户名
                System.out.println("重复的用户名");
                return -1;
            }
        }
        return dao.insert(connection, sysUser);
    }

    @Override
    public SysUser findSysUser(String username, String password) {
        return dao.getSysUserByUsername(connection, username);
    }

    @Override
    public SysUser findSysUserByUsername(String username) {
        SysUser sysUser = dao.getSysUserByUsername(connection, username);
        System.out.println(sysUser);
        return sysUser;
    }
}
