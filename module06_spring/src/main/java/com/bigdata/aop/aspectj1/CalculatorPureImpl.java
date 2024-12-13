package com.bigdata.aop.aspectj1;

import org.springframework.stereotype.Component;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name CalculatorPureImpl
 * @create 2024/7/19 7:08
 */

@Component
public class CalculatorPureImpl implements Calculator{
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
