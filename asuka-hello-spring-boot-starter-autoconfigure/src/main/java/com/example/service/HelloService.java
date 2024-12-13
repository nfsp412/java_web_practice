package com.example.service;

import com.example.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {
    @Autowired
    private HelloProperties helloProperties;

    public String say(String username) {
        return helloProperties.getPrefix() + username + helloProperties.getSuffix();
    }
}
