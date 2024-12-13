package com.bigdata.boot.pkg01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Pet
 * @create 2024/7/21 19:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private String name;
    private Double weight;
}
