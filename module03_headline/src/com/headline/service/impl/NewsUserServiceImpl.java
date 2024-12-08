package com.headline.service.impl;

import com.headline.dao.NewsUserDao;
import com.headline.dao.impl.NewsUserDaoImpl;
import com.headline.pojo.NewsUser;
import com.headline.service.NewsTypeService;
import com.headline.service.NewsUserService;
import com.headline.utils.MD5Util;

public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao dao = new NewsUserDaoImpl();
    @Override
    public NewsUser findUserByUsername(String username) {
        return dao.queryUserByUsername(username);
    }

    @Override
    public NewsUser findUserByUserId(int userId) {
        return dao.queryUserByUserId(userId);
    }

    @Override
    public int insertNewsUser(NewsUser user) {
        //MD5加密
        String pwd = user.getUserPwd();
        String s = MD5Util.encrypt(pwd);
        user.setUserPwd(s);
        return dao.insertNewsUser(user);
    }
}
