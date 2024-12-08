package com.headline.test;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsUserDao;
import com.headline.dao.impl.NewsTypeDaoImpl;
import com.headline.dao.impl.NewsUserDaoImpl;
import com.headline.pojo.NewsUser;
import com.headline.utils.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

public class TestNewsUserDaoImpl {
    private Connection connection = JDBCUtil.getConnection();
    private NewsUserDaoImpl dao = new NewsUserDaoImpl();
    @Test
    public void test1() {
        String sql = "select uid, username, user_pwd as userPwd, nick_name as nickName from news_user where username = ?";
        NewsUser user = dao.query(NewsUser.class,connection, sql, "zhangsan");
        System.out.println(user);
    }
}
