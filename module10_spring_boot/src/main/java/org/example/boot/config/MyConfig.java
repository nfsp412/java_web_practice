package org.example.boot.config;

import ch.qos.logback.core.db.DBHelper;
import org.example.boot.bean.Car;
import org.example.boot.bean.Pet;
import org.example.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Configuration
@Import({DBHelper.class})
@ImportResource("classpath:spring.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {


    @Bean
    public Pet pet() {
        return new Pet();
    }

    @Bean("hehe")
    @ConditionalOnBean(name = "pet")
    public User user(){
        return new User();
    }
}

