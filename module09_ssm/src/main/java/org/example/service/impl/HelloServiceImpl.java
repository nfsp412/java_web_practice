package org.example.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mappers.EmployeeMapper;
import org.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private EmployeeMapper employeeMapper;
}
