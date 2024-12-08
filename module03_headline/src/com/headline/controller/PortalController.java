package com.headline.controller;

import com.headline.common.Result;
import com.headline.common.ResultCodeEnum;
import com.headline.pojo.NewsType;
import com.headline.pojo.vo.HeadlineDetailVo;
import com.headline.pojo.vo.HeadlinePageVo;
import com.headline.pojo.vo.HeadlineQueryVo;
import com.headline.service.NewsHeadlineService;
import com.headline.service.NewsTypeService;
import com.headline.service.impl.NewsHeadlineServiceImpl;
import com.headline.service.impl.NewsTypeServiceImpl;
import com.headline.utils.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户控制器
 * 不需要登陆,不需要增删改的门户页面的请求,在这里处理
 * 方便后续微服务拆分
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController {
    private NewsTypeService service = new NewsTypeServiceImpl();

    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    /**
     * 查询所有news的types并返回list
     *
     * @param request
     * @param response
     */
    public void findAllTypes(HttpServletRequest request, HttpServletResponse response) {
        List<NewsType> newsTypeList = service.findAllTypes();
        WebUtil.writeJson(response, Result.ok(newsTypeList));
    }

    public void findNewsPage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Result result = Result.build(null, ResultCodeEnum.PAGE_NUM_ERROR);
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(request, HeadlineQueryVo.class);
        if (headlineQueryVo != null) {
            Integer pageNum = headlineQueryVo.getPageNum();
            if (pageNum > 0) {
                //页数大于0才查询
                Map pageInfo = headlineService.findPages(headlineQueryVo);
                HashMap<String, Map> map = new HashMap<>();
                map.put("pageInfo", pageInfo);
                result = Result.ok(map);
            }
        }
        WebUtil.writeJson(response, result);
    }

    public void showHeadlineDetail(HttpServletRequest request, HttpServletResponse response) {
        Result result = Result.build(null, ResultCodeEnum.PAGE_NUM_ERROR);
        String hid = request.getParameter("hid");
        if (hid != null) {
            Integer hid1 = Integer.parseInt(hid);
            HeadlineDetailVo headlineDetailVo = headlineService.findDetails(hid1);
            Map map = new HashMap();
            map.put("headline", headlineDetailVo);
            result = Result.ok(map);
        }
        WebUtil.writeJson(response, result);
    }
}
