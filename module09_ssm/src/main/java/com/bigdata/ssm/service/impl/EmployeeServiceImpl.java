package com.bigdata.ssm.service.impl;

import com.bigdata.ssm.mapper.EmployeeMapper;
import com.bigdata.ssm.pojo.Employee;
import com.bigdata.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name EmployeeServiceImpl
 * @create 2024/7/21 9:47
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }
}
