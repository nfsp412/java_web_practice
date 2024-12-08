package com.headline.service;

import com.headline.pojo.NewsUser;

public interface NewsUserService {
    NewsUser findUserByUsername(String username);

    NewsUser findUserByUserId(int userId);

    int insertNewsUser(NewsUser user);
}
