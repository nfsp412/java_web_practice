package com.bigdata.pojo;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name User
 * @create 2024/7/19 9:46
 */

public class User1 {
    public Integer id;
    public String username;
    public String password;
    public Integer age;
    public String gender;
    public String email;

    public User1(Integer id, String username, String password, Integer age, String gender, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
