package com.bigdata.boot.pkg01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name MyBean
 * @create 2024/7/21 17:27
 */

@ImportResource("classpath:bean1.xml")
@Configuration
public class MyBean {
}
