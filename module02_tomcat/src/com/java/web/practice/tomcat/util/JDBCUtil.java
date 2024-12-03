package com.java.web.practice.tomcat.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdk.nashorn.internal.scripts.JD;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author sp
 * @version v1.0
 * @package java_web_practice
 * @name JDBCUtil
 * @create 2024/12/3 11:52
 */

public class JDBCUtil {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void releaseConnection() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            threadLocal.remove();
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(JDBCUtil.getDataSource());
        System.out.println(JDBCUtil.getConnection());
        JDBCUtil.releaseConnection();
    }
}
