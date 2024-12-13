package com.bigdata.special;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name People
 * @create 2024/7/18 20:02
 */

public class People {
    String var1;
    String var2;
    String var3;

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    @Override
    public String toString() {
        return "People{" +
                "var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                '}';
    }
}
