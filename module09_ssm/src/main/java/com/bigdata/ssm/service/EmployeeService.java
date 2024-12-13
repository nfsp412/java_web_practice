package com.bigdata.ssm.service;

import com.bigdata.ssm.pojo.Employee;

import java.util.List;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name EmployeeService
 * @create 2024/7/21 9:47
 */

public interface EmployeeService {
    List<Employee> getAllEmployees();
}
