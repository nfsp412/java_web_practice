package com.headline.service;

import com.headline.pojo.NewsHeadline;
import com.headline.pojo.vo.HeadlineDetailVo;
import com.headline.pojo.vo.HeadlinePageVo;
import com.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    Map findPages(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findDetails(Integer hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(Integer hid);

    int updateHeadlineByHid(NewsHeadline newsHeadline);

    int deleteHeadlineByHid(Integer userId);
}
