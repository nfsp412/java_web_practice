package com.headline.controller;

import com.headline.common.Result;
import com.headline.common.ResultCodeEnum;
import com.headline.pojo.NewsHeadline;
import com.headline.service.NewsHeadlineService;
import com.headline.service.impl.NewsHeadlineServiceImpl;
import com.headline.utils.JwtHelper;
import com.headline.utils.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController {
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    public void publish(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String token = request.getHeader("token");
        Long userId = JwtHelper.getUserId(token);

        Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);
        NewsHeadline newsHeadline = WebUtil.readJson(request, NewsHeadline.class);
        if (newsHeadline != null) {
            newsHeadline.setPublisher(userId.intValue());
            int rows = headlineService.addNewsHeadline(newsHeadline);
            if (rows > 0) {
                result = Result.ok(null);
            }
        }
        WebUtil.writeJson(response, result);
    }

    public void findHeadlineByHid(HttpServletRequest request, HttpServletResponse response) {
        Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);
        String token = request.getHeader("token");
        int userId = JwtHelper.getUserId(token).intValue();
        String hid = request.getParameter("hid");
        if (hid != null) {
            Integer hid1 = Integer.parseInt(hid);
            NewsHeadline newsHeadline = headlineService.findHeadlineByHid(hid1);
            Map map = new HashMap();
            map.put("headline", newsHeadline);
            result = Result.ok(map);
        }
        WebUtil.writeJson(response, result);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");

        Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);

        NewsHeadline newsHeadline = WebUtil.readJson(request, NewsHeadline.class);

        if (newsHeadline != null) {

            int rows = headlineService.updateHeadlineByHid(newsHeadline);
            if (rows > 0) {
                result = Result.ok(null);
            }
        }
        WebUtil.writeJson(response, result);
    }

    public void removeByHid(HttpServletRequest request, HttpServletResponse response) {
        Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);

        String hid = request.getParameter("hid");
        String token = request.getHeader("token");

        if (hid != null) {
            Integer userId = Integer.parseInt(hid);
            if (token != null) {
                if (!JwtHelper.isExpiration(token)) {
                    //delete
                    int rows = headlineService.deleteHeadlineByHid(userId);
                    if (rows > 0) {
                        result = Result.ok(null);
                    }
                }
            }
        }

        WebUtil.writeJson(response, result);
    }
}
