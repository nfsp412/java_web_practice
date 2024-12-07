package org.example;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloWorld {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld bean =(HelloWorld) ac.getBean("helloWorld");
        bean.say();
    }
}
