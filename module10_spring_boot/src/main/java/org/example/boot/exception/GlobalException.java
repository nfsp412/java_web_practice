package org.example.boot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public String handler(Exception e) {
        System.out.println(e);
        return "hello.html";
    }
}
