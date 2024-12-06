package com.java.web.practice.tomcat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name LoginFilter
 * @create 2024/12/3 16:35
 */

//@WebFilter(urlPatterns = {"/showSchedule", "/sysSchedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object sysUser = session.getAttribute("sysUser");
        if (sysUser == null) {
            //用户没登录,重定向登录页
            System.out.println("用户未登录,重定向登录页");
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
