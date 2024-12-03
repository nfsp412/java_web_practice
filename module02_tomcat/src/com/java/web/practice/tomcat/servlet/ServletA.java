package com.java.web.practice.tomcat.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name ServletA
 * @create 2024/12/3 10:26
 */

public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        //获取的是自己配置的参数信息,访问该servlet时会获取到
        //每一个servlet都有一个独有的servlet config
        String p1 = servletConfig.getInitParameter("p1");
        System.out.println(p1);

        //servlet context每个app有一个,所有servlet共享
        //上下文对象
        ServletContext context = this.getServletContext();
        String pp1 = context.getInitParameter("pp1");
        System.out.println(pp1);

        //获取资源的路径
        String realPath = context.getRealPath("servletA");
        System.out.println(realPath);
        String realPath1 = context.getRealPath("login.html");
        System.out.println(realPath1);

        //上下文路径???/module02_tomcat_Web_exploded 这个
        String contextPath = context.getContextPath();
        System.out.println(contextPath);



    }
}
