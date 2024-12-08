package com.headline.dao.impl;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsTypeDao;
import com.headline.pojo.NewsType;
import com.headline.utils.JDBCUtil;

import java.sql.Connection;
import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    private Connection connection = JDBCUtil.getConnection();
    @Override
    public List<NewsType> queryAllTypes() {
        String sql = "select tid, tname from news_type";
        return queryList(NewsType.class,connection, sql);
    }
}
