package com.java.web.practice.tomcat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name SysSchedule
 * @create 2024/12/3 11:51
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;

    @Override
    public String toString() {
        return "SysSchedule{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public SysSchedule(Integer uid, String title, Integer completed) {
        this.uid = uid;
        this.title = title;
        this.completed = completed;
    }
}
