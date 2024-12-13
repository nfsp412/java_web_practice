package com.bigdata.clz;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name C1
 * @create 2024/7/18 20:08
 */

public class Hobby {
    Integer id;
    String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "C1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
