package com.headline.dao;

import com.headline.pojo.NewsUser;

public interface NewsUserDao {
    NewsUser queryUserByUsername(String username);

    NewsUser queryUserByUserId(int userId);

    int insertNewsUser(NewsUser user);
}
