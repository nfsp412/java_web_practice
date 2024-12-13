package com.bigdata.factory;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name UserA
 * @create 2024/7/18 21:14
 */

public class UserA {
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
        return "UserA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
