package com.bigdata.transaction1;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name BookDao
 * @create 2024/7/19 7:56
 */

public interface BookDao {
    Integer getPriceByBookId(Integer bookId);
    void updateStock(Integer bookId);
    void updateBalance(Integer userId, Integer price);
}
