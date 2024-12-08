package com.headline.dao;

import com.headline.pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {
    List<NewsType> queryAllTypes();
}
