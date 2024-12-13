package com.bigdata;

import com.bigdata.mapper.UserMapper;
import com.bigdata.pojo.Emp;
import com.bigdata.pojo.User1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Test1
 * @create 2024/7/19 9:04
 */

public class Test1 {
    private UserMapper mapper = null;

    @Before
    public void beforeMethod() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void test2() {
//        System.out.println(mapper.insertUser());
//        System.out.println(mapper.deleteUser());
//        System.out.println(mapper.updateUser());
//        System.out.println(mapper.getUserById());
        System.out.println(mapper.getUserList());
    }

    @Test
    public void test3() {
//        System.out.println(mapper.getUserById(2));
//        System.out.println(mapper.insertUser(103,"admin","123456",23,"男","12345@qq.com"));
//        HashMap map = new HashMap();
//        map.put("id", 105);
//        map.put("name", "admin");
//        map.put("password", "123456");
//        map.put("age", 23);
//        map.put("gender", "男");
//        map.put("email", "12345@qq.com");
//        System.out.println(mapper.insertUser(map));
//        User user = new User(107, "admin", "123456", 23, "男", "12345@qq.com");
//        System.out.println(mapper.insertUser(user));
        System.out.println(mapper.deleteUser(4));
    }

    @Test
    public void test4() {
        System.out.println(mapper.getUserList());
    }

    @Test
    public void test5() {
//        System.out.println(mapper.testMohu("yb"));
//        System.out.println(mapper.deleteMore("100,101,102"));
//        System.out.println(mapper.getAllUser("t_user"));
        User1 user = new User1(null, "admin", "123456", 23, "男", "12345@qq.com");
        System.out.println(mapper.insertUser(user));
        //获取自增主键
        System.out.println(user.id);
    }

    @Test
    public void test6() {
        System.out.println(mapper.testMohu("s"));
    }

    @Test
    public void test7() {
        System.out.println(mapper.getEmpAndDeptByEid(1));
    }
    
    @Test
    public void test8() {
        System.out.println(mapper.getEmpByStep(1));
        System.out.println(mapper.getEmpDeptByStep(1));
    }

    @Test
    public void test9() {
        System.out.println(mapper.getDeptEmpByDid(1));
    }
    
    @Test
    public void test10() {
        Emp emp = mapper.getEmpByStep(2);
        System.out.println(emp.getDept());
    }

    @Test
    public void test1() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //sqlSession.commit();
        System.out.println("结果："+result);
    }
    
    @Test
    public void test11() {
        Emp emp = new Emp(null, "zs", null, null, null);
        System.out.println(mapper.getEmpListByCondition(emp));
    }

    @Test
    public void test12() {
        Emp emp = new Emp(null, "zs", null, null, null);
        System.out.println(mapper.getEmpListByChoose(emp));
    }

    @Test
    public void test13() {
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp(null,"zs",11,"男",null));
        emps.add(new Emp(null,"zs",11,"男",null));
        emps.add(new Emp(null,"zs",11,"男",null));
        System.out.println(mapper.insertMoreEmp(emps));
    }
}
