package com.java.web.practice.tomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name ServletSession1
 * @create 2024/12/3 16:16
 */

@WebServlet("/session1")
public class ServletSession1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = session.getId();
        System.out.println(id);

        boolean aNew = session.isNew();
        System.out.println(aNew);

        session.setAttribute("username","ls");

    }
}
