package com.headline.dao;

import com.headline.pojo.NewsHeadline;
import com.headline.pojo.vo.HeadlineDetailVo;
import com.headline.pojo.vo.HeadlinePageVo;
import com.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadLineDao {
    List<HeadlinePageVo> findPageData(HeadlineQueryVo headlineQueryVo);

    long queryPageCount();

    HeadlineDetailVo findPageDetails(Integer hid);

    int addPageViews(Integer hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(Integer hid);

    int updateHeadlineByHid(NewsHeadline newsHeadline);

    int deleteHeadlineByHid(Integer userId);
}
