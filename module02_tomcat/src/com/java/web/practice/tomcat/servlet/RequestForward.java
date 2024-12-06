package com.java.web.practice.tomcat.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name RequestForward
 * @create 2024/12/3 11:04
 */

public class RequestForward extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletA");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login");
        requestDispatcher.forward(req,resp);
    }
}
