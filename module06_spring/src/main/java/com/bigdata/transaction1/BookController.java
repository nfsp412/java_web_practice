package com.bigdata.transaction1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name BookController
 * @create 2024/7/19 7:55
 */

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }
}


