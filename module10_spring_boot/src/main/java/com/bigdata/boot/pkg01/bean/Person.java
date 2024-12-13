package com.bigdata.boot.pkg01.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Person
 * @create 2024/7/21 19:54
 */

@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animals;
    private Map<String, Integer> score;
    private Set<Double> salary;
    private Map<String, List<Pet>> allPets;
}

