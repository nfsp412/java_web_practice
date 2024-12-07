package com.asuka.practice.mybatis.mappers;

import com.asuka.practice.mybatis.pojo.Dept;
import com.asuka.practice.mybatis.pojo.Emp;
import com.asuka.practice.mybatis.pojo.Page1;
import com.asuka.practice.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     *
     * @return
     */
    int insertUser();

    int deleteUser();

    int updateUser();

    User getUserById();

    List<User> getUserList();

    User getUserById1(int id);

    Emp step1(Integer empId);

    Dept step2(Integer deptId);

    List<Page1> selectAll();
}
