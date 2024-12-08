package com.asuka.test.mybatis.mapper;

import com.asuka.practice.mybatis.mappers.UserMapper;
import com.asuka.practice.mybatis.pojo.Page1;
import com.asuka.practice.mybatis.pojo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestPage {
    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session1 = sqlSessionFactory.openSession(true);
        UserMapper mapper = session1.getMapper(UserMapper.class);
        //开启分页
        Page<Object> page = PageHelper.startPage(1, 4);

        List<Page1> page1s = mapper.selectAll();
        page1s.forEach(System.out::println);

        System.out.println(page);

        PageInfo<Page1> page1PageInfo = new PageInfo<>(page1s, 5);
        System.out.println(page1PageInfo);

    }
}
