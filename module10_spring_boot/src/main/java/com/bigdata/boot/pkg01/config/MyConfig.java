package com.bigdata.boot.pkg01.config;

import ch.qos.logback.core.db.DBHelper;
import com.bigdata.boot.pkg01.bean.Pet;
import com.bigdata.boot.pkg01.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name MyConfig
 * @create 2024/7/21 10:40
 */

@Configuration(
        proxyBeanMethods = true
)
@Import(value = {User.class, DBHelper.class})
@EnableConfigurationProperties(Car.class)
//@ConditionalOnBean(name = "tom")
public class MyConfig {

    @Bean("u1")
//    @ConditionalOnBean(name = "tom")
    public User user1(Car car) {
        System.out.println(car.brand);
        return new User();
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat", 1.1);
    }

    @Bean("u2")
    @ConditionalOnBean(name = "tom")
    public User user01() {
        return new User();
    }
}
