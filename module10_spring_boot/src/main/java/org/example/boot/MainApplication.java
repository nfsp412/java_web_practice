package org.example.boot;

import org.example.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
//        User u1 = run.getBean(User.class);
//        User u2 = run.getBean(User.class);
//        System.out.println("是否单例" + (u1 == u2));

//        User user = run.getBean("user", User.class);
//        System.out.println(user);

    }
}
