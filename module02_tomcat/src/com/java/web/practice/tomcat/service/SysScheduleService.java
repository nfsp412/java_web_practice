package com.java.web.practice.tomcat.service;

import com.java.web.practice.tomcat.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleService {
    List<SysSchedule> queryAllSysSchedule(int uid);

    int updateSysScheduleBySid(SysSchedule schedule);

    int insertSysSchedule(int uid);

    int deleteSysScheduleBySid(int sid);
}
