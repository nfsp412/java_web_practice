package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import java.util.List;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sat Dec 07 17:10:43 CST 2024
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbggenerated Sat Dec 07 17:10:43 CST 2024
     */
    List<Emp> selectAll();
}