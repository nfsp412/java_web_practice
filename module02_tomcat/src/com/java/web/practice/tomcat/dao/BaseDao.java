package com.java.web.practice.tomcat.dao;

import com.java.web.practice.tomcat.pojo.SysSchedule;
import com.java.web.practice.tomcat.pojo.SysUser;
import com.java.web.practice.tomcat.util.JDBCUtil;
import com.sun.xml.internal.ws.model.WrapperBeanGenerator;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name BaseDao
 * @create 2024/12/3 12:07
 */

public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz = null;

    // 对clazz进行实例化,可以放在代码块或者构造器
    {
        // 获取当前对象的类的带泛型的父类
        // 为啥用this 是因为你造的对象是具体实现的子类而不是父类,所以这里的this指的是具体实现子类,因为this指的是你具体实例化的那个
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        // 强转
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // 获取泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        // 获取数组的第一个,因为这里泛型只有一个,然后强转,然后赋值给clazz
        clazz = (Class<T>) actualTypeArguments[0];
    }

    public T query(Connection connection, String sql, Object... args) {
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public List<T> queryList(Connection connection, String sql, Object... args) {
        List<T> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int update(Connection connection, String sql, Object... args) {
        int count = 0;
        try {
            count = queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public Object queryValue(Connection connection, String sql, Object... args) {
        Object value = null;
        try {
            value = queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return value;
    }
}
