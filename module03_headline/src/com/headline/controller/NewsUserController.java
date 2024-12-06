package com.headline.controller;

import com.headline.common.Result;
import com.headline.common.ResultCodeEnum;
import com.headline.pojo.NewsUser;
import com.headline.service.NewsUserService;
import com.headline.service.impl.NewsUserServiceImpl;
import com.headline.utils.JwtHelper;
import com.headline.utils.MD5Util;
import com.headline.utils.WebUtil;
import io.jsonwebtoken.Jwt;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@WebServlet("/user/*")
public class NewsUserController extends BaseController {
    private NewsUserService service = new NewsUserServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) {
        //获取post请求传入的参数
        NewsUser user = WebUtil.readJson(request, NewsUser.class);
        System.out.println("/user/login " + user);
        //查询数据库该用户是否存在
        NewsUser resultUser = service.findUserByUsername(user.getUsername());
        //判断
        Result result;
        if (resultUser != null) {
            //避免空指针报错,先判断不为空,再判断密码是否正确
            if (!MD5Util.encrypt(user.getUserPwd()).equalsIgnoreCase(resultUser.getUserPwd())) {
                //密码错误
                System.out.println("密码错误 " + user);
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            } else {
                //将uid转换成token返回
                String token = JwtHelper.createToken(resultUser.getUid().longValue());
                HashMap<String, String> map = new HashMap<>();
                map.put("token", token);
                result = Result.ok(map);
            }
        } else {
            //查询不到该用户
            System.out.println("查询不到该用户信息 " + user);
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        WebUtil.writeJson(response, result);
    }

    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        //获取传入的token,如果使用getParam则会抛出Jwt异常,这样则不会抛出异常
        String token = request.getHeader("token");
        Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);
        if (token != null && !("".equals(token))) {
            if (!JwtHelper.isExpiration(token)) {
                //token不为空并且没有过期时
                Integer userId = JwtHelper.getUserId(token).intValue();
                NewsUser user = service.findUserByUserId(userId);
                if (user != null) {
                    //成功找到token
                    user.setUserPwd("");
                    HashMap<String, NewsUser> map = new HashMap<>();
                    map.put("loginUser", user);
                    result = Result.ok(map);
                }
            }
        }
        WebUtil.writeJson(response, result);
    }

    public void checkUserName(HttpServletRequest request, HttpServletResponse response) {
        Result result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        String username = request.getParameter("username");
        if (username != null) {
            NewsUser resultUser = service.findUserByUsername(username);
            if (resultUser == null) {
                //没注册过的用户
                result = Result.ok(null);
            }
        }
        WebUtil.writeJson(response, result);
    }

    public void regist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Result result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        NewsUser user = WebUtil.readJson(request, NewsUser.class);
        if (user != null) {
            NewsUser resultUser = service.findUserByUsername(user.getUsername());
            if (resultUser == null) {
                //没注册过的用户
                int rows = service.insertNewsUser(user);
                if (rows > 0) {
                    result = Result.ok(null);
                }
            }
        }
        WebUtil.writeJson(response, result);
    }

    public void checkLogin(HttpServletRequest request,HttpServletResponse response){
        String token = request.getHeader("token");
        Result result = Result.build(null,ResultCodeEnum.NOT_LOGIN);
        if (token != null) {
            if (!JwtHelper.isExpiration(token)){
                result = Result.ok(null);
            }
        }
        WebUtil.writeJson(response,result);
    }
}
