package com.java.web.practice.tomcat.dao.impl;

import com.java.web.practice.tomcat.dao.BaseDao;
import com.java.web.practice.tomcat.dao.SysScheduleDao;
import com.java.web.practice.tomcat.pojo.SysSchedule;

import java.sql.Connection;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysScheduleDaoImpl
 * @create 2024/12/3 15:08
 */

public class SysScheduleDaoImpl extends BaseDao<SysSchedule> implements SysScheduleDao {
    @Override
    public int insert(Connection connection, SysSchedule sysSchedule) {
        String sql = "insert into sys_schedule(uid, title, completed) values (?, ?, ?)";
        return update(connection, sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
    }

    @Override
    public int deleteById(Connection connection, int id) {
        String sql = "delete from sys_schedule where sid = ?";
        return update(connection, sql, id);
    }

    @Override
    public int updateById(Connection connection, SysSchedule sysSchedule) {
        String sql = "update sys_schedule set uid = ?, title = ?, completed = ? where sid = ?";
        return update(connection, sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted(), sysSchedule.getSid());
    }

    @Override
    public SysSchedule getSysScheduleById(Connection connection, int id) {
        String sql = "select sid, uid, title, completed from sys_schedule where sid = ?";
        return query(connection, sql, id);
    }

    @Override
    public List<SysSchedule> getAll(Connection connection) {
        String sql = "select sid, uid, title, completed from sys_schedule";
        return queryList(connection, sql);
    }

    @Override
    public Object getTitleById(Connection connection, int id) {
        String sql = "select title from sys_schedule where sid = ?";
        return queryValue(connection, sql, id);
    }
}
