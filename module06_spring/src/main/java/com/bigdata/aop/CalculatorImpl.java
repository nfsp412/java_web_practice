package com.bigdata.aop;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Calculator
 * @create 2024/7/19 6:56
 */

public class CalculatorImpl implements Calculator{
    @Override
    public void add(Integer n1, Integer n2) {
        System.out.println(n1 + n2);
    }
}
