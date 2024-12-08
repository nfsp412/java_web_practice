package com.headline.dao.impl;

import com.headline.dao.BaseDao;
import com.headline.dao.NewsHeadLineDao;
import com.headline.pojo.NewsHeadline;
import com.headline.pojo.vo.HeadlineDetailVo;
import com.headline.pojo.vo.HeadlinePageVo;
import com.headline.pojo.vo.HeadlineQueryVo;
import com.headline.utils.JDBCUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class NewsHeadLineDaoImpl extends BaseDao implements NewsHeadLineDao {
    private Connection connection = JDBCUtil.getConnection();

    @Override
    public List<HeadlinePageVo> findPageData(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select hid, title, type, page_views as pageViews, timestampdiff(hour, create_time, now()) as pastHours, publisher from news_headline where is_deleted = 0 ");
        if (headlineQueryVo.getType() != 0) {
            //代表查询条件type
            sql.append(" and type = ? ");
            params.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords() != null && !"".equals(headlineQueryVo.getKeyWords())) {
            //拼接keyword
            sql.append(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }
        //拼接排序条件
        sql.append(" order by pastHours asc, page_views desc ");
        //拼接分页条件
        sql.append(" limit ?, ?");
        params.add((headlineQueryVo.getPageNum() - 1) * headlineQueryVo.getPageSize());
        params.add(headlineQueryVo.getPageSize());
        System.out.println("查询sql " + sql);
        return queryList(HeadlinePageVo.class, connection, sql.toString(), params.toArray());
    }

    @Override
    public long queryPageCount() {
        String sql = "select count(1) from news_headline where is_deleted = 0";
        return (long) queryValue(connection, sql);
    }

    @Override
    public HeadlineDetailVo findPageDetails(Integer hid) {
        String sql = "select t1.hid, t1.title, t1.article, t1.type, t2.tname as typeName, t1.page_views as pageViews, timestampdiff(hour, t1.create_time, now()) as pastHours, t1.publisher, t3.nick_name as author from news_headline t1 left join news_type t2 on t1.type = t2.tid left join news_user t3 on t1.publisher = t3.uid where hid = ?";
        return query(HeadlineDetailVo.class, connection, sql, hid);
    }

    @Override
    public int addPageViews(Integer hid) {
        String sql = "update news_headline set page_views = page_views + 1 where hid = ?";
        return update(connection,sql,hid);
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        String sql = "insert into news_headline (title, article, type, publisher) values (?, ?, ?, ?)";
        return update(connection,sql,
                newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getPublisher());
    }

    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        String sql = "select hid, title, article, type from news_headline where hid = ?";
        return query(NewsHeadline.class,connection,sql,hid);
    }

    @Override
    public int updateHeadlineByHid(NewsHeadline newsHeadline) {
        String sql = "update news_headline set title = ?, article = ?, type = ?, update_time = NOW() where hid = ?";
        return update(connection,sql,
                newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getHid());
    }

    @Override
    public int deleteHeadlineByHid(Integer userId) {
//        String sql = "delete from news_headline where hid = ?";
        String sql = "update news_headline set is_deleted = 1, update_time = NOW() where hid = ?";
        return update(connection,sql,userId);
    }
}
