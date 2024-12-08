package com.asuka.practice.mybatis.pojo;

public class Dept {
    private Integer deptId;
    private String deptName;

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
