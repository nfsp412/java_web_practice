package com.java.web.practice.tomcat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUser
 * @create 2024/12/3 11:50
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysUser {
    private Integer uid;
    private String username;
    private String password;


    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
