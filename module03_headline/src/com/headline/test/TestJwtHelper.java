package com.headline.test;

import com.headline.utils.JwtHelper;
import org.junit.Test;

public class TestJwtHelper {
    @Test
    public void test1() {
        String token = JwtHelper.createToken(1L);
        Long userId = JwtHelper.getUserId(token);
        assert userId == 1L;
    }

    @Test
    public void test2() throws InterruptedException {
        String token = JwtHelper.createToken(1L);
        Thread.sleep(6000);
        assert JwtHelper.isExpiration(token);
    }
}
