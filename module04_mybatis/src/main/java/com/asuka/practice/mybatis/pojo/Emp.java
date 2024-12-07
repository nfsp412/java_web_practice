package com.asuka.practice.mybatis.pojo;

public class Emp {
    private Integer empId;
    private String empName;
    private Integer age;
    private String gender;
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }

    public String getGender() {
        return gender;
    }
}
