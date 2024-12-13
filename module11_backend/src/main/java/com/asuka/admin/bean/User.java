package com.asuka.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name User
 * @create 2024/9/20 8:44
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
}
