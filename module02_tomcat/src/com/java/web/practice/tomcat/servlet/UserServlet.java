package com.java.web.practice.tomcat.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name UserServlet
 * @create 2024/12/3 9:52
 */

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        System.out.println(username);
        if ("atguigu".equals(username)) {
            resp.getWriter().write("NO");
        } else {
            resp.getWriter().write("正确");
        }
    }
}
