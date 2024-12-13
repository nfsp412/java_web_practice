package com.bigdata.transaction1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name BookServiceImpl
 * @create 2024/7/19 7:56
 */

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional(
            readOnly = true//设置成只读，就能够明确告诉数据库，这个操作不涉及写操作
            ,timeout = 3//超时回滚，释放资源
            ,noRollbackFor = ArithmeticException.class//回滚策略,当出现xxx类时不回滚
            ,isolation = Isolation.DEFAULT//默认事务隔离级别
//            ,propagation = Propagation.REQUIRED//默认情况，表示如果当前线程上有已经开启的事务可用，那么就在这个事务中运行
            ,propagation = Propagation.REQUIRES_NEW//表示不管当前线程上是否有已经开启的事务，都要开启新事务
    )
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
