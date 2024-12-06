package com.headline.dao.impl;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsUserDao;
import com.headline.pojo.NewsUser;
import com.headline.utils.JDBCUtil;

import java.sql.Connection;

public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    private Connection connection = JDBCUtil.getConnection();
    @Override
    public NewsUser queryUserByUsername(String username) {
        String sql = "select uid, username, user_pwd as userPwd, nick_name as nickName from news_user where username = ?";
        return query(NewsUser.class,connection, sql, username);
    }

    @Override
    public NewsUser queryUserByUserId(int userId) {
        String sql = "select uid, username, user_pwd as userPwd, nick_name as nickName from news_user where uid = ?";
        return query(NewsUser.class,connection,sql,userId);
    }

    @Override
    public int insertNewsUser(NewsUser user) {
        String sql = "insert into news_user (username, user_pwd, nick_name) values (?, ?, ?)";
        return update(connection, sql, user.getUsername(), user.getUserPwd(), user.getNickName());
    }
}
