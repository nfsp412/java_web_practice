package com.java.web.practice.tomcat.controller;

import com.java.web.practice.tomcat.common.Result;
import com.java.web.practice.tomcat.common.ResultCodeEnum;
import com.java.web.practice.tomcat.pojo.SysUser;
import com.java.web.practice.tomcat.service.SysUserService;
import com.java.web.practice.tomcat.service.impl.SysUserServiceImpl;
import com.java.web.practice.tomcat.util.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserController
 * @create 2024/12/3 15:26
 */

@WebServlet("/sysUser/*")
public class SysUserController extends BaseController {
    private SysUserService userService = new SysUserServiceImpl();

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        SysUser sysUser = WebUtil.readJson(request, SysUser.class);
        System.out.println(sysUser);
        //注册
//        int i = userService.register(new SysUser(username, password));
        int i = userService.register(sysUser);
        if (i > 0) {
//            response.sendRedirect("/success.html");
            WebUtil.writeJson(response,Result.ok(null));
        } else {
//            response.sendRedirect("/failed.html");
            WebUtil.writeJson(response,Result.build(null,ResultCodeEnum.USERNAME_USED));
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        SysUser sysUser = WebUtil.readJson(request, SysUser.class);
        System.out.println(sysUser);
//        int i = userService.findSysUser(username, password);
        int i = userService.findSysUser(
                sysUser.getUsername(),
                sysUser.getPassword()
        );
        if (i > 0) {
            //用户信息存入session
            HttpSession session = request.getSession();
            session.setAttribute("sysUser", i);
//            response.sendRedirect("/showSchedule.html");
            WebUtil.writeJson(response,Result.ok(null));
        } else {
//            response.sendRedirect("/failed.html");
            WebUtil.writeJson(response,Result.build(null,ResultCodeEnum.USERNAME_USED));
        }
    }

    public void checkUsernameUsed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        SysUser sysUser = userService.findSysUserByUsername(username);
        Result result = null;
        if (sysUser == null) {
            //响应JSON给前端
            result = Result.ok("未占用");
        } else {
            result = Result.build("已占用", ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(response, result);
    }
}
