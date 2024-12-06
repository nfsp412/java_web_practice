package com.headline.service.impl;

import com.headline.dao.NewsHeadLineDao;
import com.headline.dao.impl.NewsHeadLineDaoImpl;
import com.headline.pojo.NewsHeadline;
import com.headline.pojo.vo.HeadlineDetailVo;
import com.headline.pojo.vo.HeadlinePageVo;
import com.headline.pojo.vo.HeadlineQueryVo;
import com.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadLineDao headLineDao = new NewsHeadLineDaoImpl();
    @Override
    public Map findPages(HeadlineQueryVo headlineQueryVo) {
        //查询pageData
        List<HeadlinePageVo> list = headLineDao.findPageData(headlineQueryVo);
        //获取pageNum和pageSize
        Integer pageNum = headlineQueryVo.getPageNum();
        Integer pageSize = headlineQueryVo.getPageSize();
        //获取totalSize
        long totalSize = headLineDao.queryPageCount();
        //计算totalPage,使用totalSize计算
        long totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize) + 1;
        //封装pojo
        Map map = new HashMap();
        map.put("pageData",list);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("totalSize",totalSize);
        map.put("totalPage",totalPage);
        return map;
    }

    @Override
    public HeadlineDetailVo findDetails(Integer hid) {
        //浏览量+1
        int rows = headLineDao.addPageViews(hid);
        return headLineDao.findPageDetails(hid);
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        return headLineDao.addNewsHeadline(newsHeadline);
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        return headLineDao.findHeadlineByHid(hid);
    }

    @Override
    public int updateHeadlineByHid(NewsHeadline newsHeadline) {
        return headLineDao.updateHeadlineByHid(newsHeadline);
    }

    @Override
    public int deleteHeadlineByHid(Integer userId) {
        return headLineDao.deleteHeadlineByHid(userId);
    }
}
