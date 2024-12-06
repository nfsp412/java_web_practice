package com.java.web.practice.tomcat.dao;

import com.java.web.practice.tomcat.pojo.SysSchedule;
import com.java.web.practice.tomcat.pojo.SysUser;

import java.sql.Connection;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysUserDao
 * @create 2024/12/3 13:41
 */

public interface SysScheduleDao {
    int insert(Connection connection, SysSchedule sysSchedule);

    int deleteById(Connection connection, int id);

    int updateById(Connection connection, SysSchedule sysSchedule);

    SysSchedule getSysScheduleById(Connection connection, int id);

    List<SysSchedule> getAll(Connection connection);

    Object getTitleById(Connection connection, int id);

    List<SysSchedule> getAllByUid(Connection connection,int uid);

}
