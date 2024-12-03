package com.java.web.practice.tomcat.service;

import com.java.web.practice.tomcat.pojo.SysUser;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserService
 * @create 2024/12/3 15:33
 */

public interface SysUserService {
    int register(SysUser sysUser);

    int findSysUser(String username,String password);

    SysUser findSysUserByUsername(String username);
}
