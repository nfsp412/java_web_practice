package com.bigdata.ioc;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name User
 * @create 2024/7/18 17:31
 */

public class User {
    String name;
    Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
