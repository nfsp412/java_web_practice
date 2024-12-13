package com.asuka.admin.controller;

import com.asuka.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name TableController
 * @create 2024/9/20 11:09
 */

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String getBasicTablePage() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String getDynamicTablePage(Model model) {
        // 演示动态遍历表格内容
        List<User> list = Arrays.asList(
                new User("zs", "123"),
                new User("ls", "456"),
                new User("asuka", "789")
        );
        model.addAttribute("users", list);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String getResponsiveTablePage() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String getEditableTablePage() {
        return "table/editable_table";
    }
}
