package com.java.web.practice.tomcat.service.impl;

import com.java.web.practice.tomcat.dao.SysScheduleDao;
import com.java.web.practice.tomcat.dao.impl.SysScheduleDaoImpl;
import com.java.web.practice.tomcat.pojo.SysSchedule;
import com.java.web.practice.tomcat.service.SysScheduleService;
import com.java.web.practice.tomcat.util.JDBCUtil;

import java.sql.Connection;
import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao dao = new SysScheduleDaoImpl();
    private Connection connection = JDBCUtil.getConnection();
    @Override
    public List<SysSchedule> queryAllSysSchedule(int uid) {
        return dao.getAllByUid(connection,uid);
    }

    @Override
    public int updateSysScheduleBySid(SysSchedule schedule) {
        return dao.updateById(connection, schedule);
    }

    @Override
    public int insertSysSchedule(int uid) {
        SysSchedule schedule = new SysSchedule(uid, "请输入日程", 0);
        return dao.insert(connection,schedule);
    }

    @Override
    public int deleteSysScheduleBySid(int sid) {
        return dao.deleteById(connection, sid);
    }
}
