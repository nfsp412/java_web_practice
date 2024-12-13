package com.bigdata.clz;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name C2
 * @create 2024/7/18 20:08
 */

public class Student {
    Integer id;
    String name;
    Hobby hobby;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Hobby getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
