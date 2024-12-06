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
        System.out.println("注册用户: "+sysUser);
        //注册
//        int i = userService.register(new SysUser(username, password));
        int i = userService.register(sysUser);
        if (i > 0) {
//            response.sendRedirect("/success");
            WebUtil.writeJson(response,Result.ok(null));
        } else {
//            response.sendRedirect("/failed");
            WebUtil.writeJson(response,Result.build(null,ResultCodeEnum.USERNAME_USED));
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        SysUser sysUser = WebUtil.readJson(request, SysUser.class);
        System.out.println("登陆用户: "+sysUser);
//        int i = userService.findSysUser(username, password);
        SysUser resultSysUser = userService.findSysUser(
                sysUser.getUsername(),
                sysUser.getPassword()
        );
        if (!resultSysUser.getUsername().equals(sysUser.getUsername())) {
            System.out.println("该用户不存在");
            WebUtil.writeJson(response,Result.build(null,ResultCodeEnum.USERNAME_ERROR));
        } else if (!resultSysUser.getPassword().equals(sysUser.getPassword())) {
            System.out.println("密码错误");
            WebUtil.writeJson(response,Result.build(null,ResultCodeEnum.PASSWORD_ERROR));
        }else if (resultSysUser == null) {
            System.out.println("null");
            WebUtil.writeJson(response,Result.build(null,ResultCodeEnum.USERNAME_ERROR));
        }else {
            //将用户uid和username返回
            SysUser user = new SysUser(resultSysUser.getUid(), resultSysUser.getUsername());
            WebUtil.writeJson(response,Result.ok(user));
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
