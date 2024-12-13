package com.bigdata.pojo;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name User
 * @create 2024/7/19 9:46
 */

public class User {
    public Integer id;
    public String userName;
    public String password;
    public Integer age;
    public String sex;

    public User(Integer id, String userName, String password, Integer age, String sex) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
