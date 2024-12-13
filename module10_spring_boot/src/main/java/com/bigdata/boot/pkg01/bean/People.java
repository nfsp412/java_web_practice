package com.bigdata.boot.pkg01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name People
 * @create 2024/9/13 13:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    private String user;
    private String password;
    private Pet pet;
}
