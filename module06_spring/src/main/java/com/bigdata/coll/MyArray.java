package com.bigdata.coll;

import java.util.Arrays;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name MyArray
 * @create 2024/7/18 20:34
 */

public class MyArray {
    String[] vars;

    public void setVars(String[] vars) {
        this.vars = vars;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "vars=" + Arrays.toString(vars) +
                '}';
    }
}
