package com.bigdata.ssm.mapper;

import com.bigdata.ssm.pojo.Employee;

import java.util.List;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name EmployeeMapper
 * @create 2024/7/21 9:33
 */

public interface EmployeeMapper {
    List<Employee> getAllEmployees();

}
