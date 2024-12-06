package com.java.web.practice.tomcat.controller;

import com.java.web.practice.tomcat.common.Result;
import com.java.web.practice.tomcat.common.ResultCodeEnum;
import com.java.web.practice.tomcat.pojo.SysSchedule;
import com.java.web.practice.tomcat.pojo.SysUser;
import com.java.web.practice.tomcat.service.SysScheduleService;
import com.java.web.practice.tomcat.service.impl.SysScheduleServiceImpl;
import com.java.web.practice.tomcat.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserController
 * @create 2024/12/3 15:26
 */

@WebServlet("/sysSchedule/*")
public class SysScheduleController extends BaseController {
    private SysScheduleService service = new SysScheduleServiceImpl();

    public void queryAll(HttpServletRequest request, HttpServletResponse response){
        int uid = Integer.parseInt(request.getParameter("uid"));
        List<SysSchedule> list = service.queryAllSysSchedule(uid);
        list.forEach(System.out::println);
        WebUtil.writeJson(response, Result.ok(list));
    }

    public void updateItem(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        SysSchedule schedule = WebUtil.readJson(request, SysSchedule.class);

        System.out.println("upsert: " + schedule);
        int rows = service.updateSysScheduleBySid(schedule);
        if (rows <= 0){
            WebUtil.writeJson(response,Result.build(null, ResultCodeEnum.USERNAME_ERROR));
        }else {
            WebUtil.writeJson(response,Result.ok(null));
        }
    }

    public void addItem(HttpServletRequest request,HttpServletResponse response) {
        int uid = Integer.parseInt(request.getParameter("uid"));
        int rows = service.insertSysSchedule(uid);
        if (rows <= 0){
            WebUtil.writeJson(response,Result.build(null, ResultCodeEnum.USERNAME_ERROR));
        }else {
            WebUtil.writeJson(response,Result.ok(null));
        }
    }

    public void deleteItem(HttpServletRequest request,HttpServletResponse response) {
        int sid = Integer.parseInt(request.getParameter("sid"));
        System.out.println("删除sid: "+sid);
        int rows = service.deleteSysScheduleBySid(sid);
        if (rows <= 0){
            WebUtil.writeJson(response,Result.build(null, ResultCodeEnum.USERNAME_ERROR));
        }else {
            WebUtil.writeJson(response,Result.ok(null));
        }
    }



}
