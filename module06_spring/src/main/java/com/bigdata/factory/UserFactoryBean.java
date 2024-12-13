package com.bigdata.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name UserFactoryBean
 * @create 2024/7/18 21:13
 */

public class UserFactoryBean implements FactoryBean<UserA> {
    @Override
    public UserA getObject() throws Exception {
        return new UserA();
    }

    @Override
    public Class<?> getObjectType() {
        return UserA.class;
    }
}
