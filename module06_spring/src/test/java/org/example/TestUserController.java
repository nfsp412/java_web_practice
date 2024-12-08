package org.example;

import org.example.controller.UserController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserController {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
        UserController bean = ac.getBean(UserController.class);
        bean.handle(null,null);

    }
}
