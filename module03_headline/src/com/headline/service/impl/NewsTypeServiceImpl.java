package com.headline.service.impl;

import com.headline.dao.NewsTypeDao;
import com.headline.dao.impl.NewsTypeDaoImpl;
import com.headline.pojo.NewsType;
import com.headline.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao dao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAllTypes() {
        return dao.queryAllTypes();
    }
}
