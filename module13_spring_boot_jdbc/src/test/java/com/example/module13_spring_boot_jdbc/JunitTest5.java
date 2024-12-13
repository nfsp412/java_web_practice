package com.example.module13_spring_boot_jdbc;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitTest5 {
    @Test
    @DisplayName("ceshi1")
    public void test1(){

    }

    @Test
    void test2( ){
        assertEquals(1,1);
    }
}
