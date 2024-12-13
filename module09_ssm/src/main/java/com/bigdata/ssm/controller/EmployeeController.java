package com.bigdata.ssm.controller;

import com.bigdata.ssm.pojo.Employee;
import com.bigdata.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name EmployeeController
 * @create 2024/7/21 9:48
 */

@Controller
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @RequestMapping(
            value = "/emp",
            method = RequestMethod.GET
    )
    public String queryAllEmployees(Model model) {
        List<Employee> list = employeeService.getAllEmployees();
        System.out.println(list);
        model.addAttribute("list", list);
        return "emp_list";
    }


}
