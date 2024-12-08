package com.headline.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public <T> T query(Class<T> clazz, Connection connection, String sql, Object... args) {
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public <T> List<T> queryList(Class<T> clazz, Connection connection, String sql, Object... args) {
        List<T> list = null;
        try {
//            Arrays.stream(args).forEach(System.out::println);
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
