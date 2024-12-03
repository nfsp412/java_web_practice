package com.java.web.practice.tomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name ServletRequest
 * @create 2024/12/3 10:52
 */

public class ServletRequest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求行
        System.out.println("请求行===============================");
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);//http://localhost:8081/module02_tomcat_Web_exploded/servletRequest


        String requestURI = req.getRequestURI();
        System.out.println(requestURI);///module02_tomcat_Web_exploded/servletRequest


        int serverPort = req.getServerPort();
        System.out.println(serverPort);//8081

        int localPort = req.getLocalPort();
        System.out.println(localPort);//8081

        int remotePort = req.getRemotePort();
        System.out.println(remotePort);//1703

        String scheme = req.getScheme();
        System.out.println(scheme);//http

        String protocol = req.getProtocol();
        System.out.println(protocol);//HTTP/1.1


        String method = req.getMethod();
        System.out.println(method);//GET

        //请求头
        System.out.println("请求头===============================");
        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String s = headerNames.nextElement();
//            System.out.println(s);
//        }
        String contentType = req.getContentType();
        System.out.println(contentType);//null

        //其他
        System.out.println("其他===============================");
        String servletPath = req.getServletPath();
        System.out.println(servletPath);///servletRequest




    }
}
