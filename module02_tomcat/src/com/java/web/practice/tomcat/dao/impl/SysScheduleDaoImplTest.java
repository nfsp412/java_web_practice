package com.java.web.practice.tomcat.dao.impl;

import com.java.web.practice.tomcat.dao.BaseDao;
import com.java.web.practice.tomcat.dao.SysScheduleDao;
import com.java.web.practice.tomcat.pojo.SysSchedule;
import com.java.web.practice.tomcat.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysScheduleDaoImpl
 * @create 2024/12/3 15:08
 */

public class SysScheduleDaoImplTest {
    private SysScheduleDaoImpl dao = new SysScheduleDaoImpl();
    private Connection connection = JDBCUtil.getConnection();

    @Test
    public void insert() {
        int i = dao.insert(connection, new SysSchedule(1, "t1", 1));
        System.out.println(i);
    }

    @Test
    public void deleteById() {
        int i = dao.deleteById(connection, 1);
        System.out.println(i);
    }

    @Test
    public void updateById() {
        int i = dao.updateById(connection, new SysSchedule(1, 2, "t2", 0));
        System.out.println(i);
    }

    @Test
    public void getSysScheduleById() {
        SysSchedule sysSchedule = dao.getSysScheduleById(connection, 1);
        System.out.println(sysSchedule);
    }

    @Test
    public void getAll() {
        List<SysSchedule> all = dao.getAll(connection);
        all.forEach(System.out::println);
    }

    @Test
    public void getTitleById() {
        Object title = dao.getTitleById(connection, 1);
        System.out.println(title.toString());
    }
}
