package com.bigdata.mapper;

import com.bigdata.pojo.Dept;
import com.bigdata.pojo.Emp;
import com.bigdata.pojo.User1;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name UserMapper
 * @create 2024/7/19 9:01
 */

public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();
    int deleteUser();
    int updateUser();
    User1 getUserById();
//    List<User> getUserList();

    User1 getUserById(int id);
    int insertUser(int id, String username, String password, int age, String gender, String email);
    int insertUser(HashMap map);
//    int insertUser(User user);

    int deleteUser(@Param("id") int id);

//    List<Map<String, Object>> getUserList();

    @MapKey("id")
    Map<String, Object> getUserList();

    /**
     * 测试模糊查询
     * @param mohu
     * @return
     */
    List<User1> testMohu(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 动态设置表名，查询所有的用户信息
     * @param tableName
     * @return
     */
    List<User1> getAllUser(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     * @return
     * useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参
    数user对象的某个属性中
     */
    int insertUser(User1 user);

    Emp getEmpAndDeptByEid(@Param("eid") int eid);

    /**
     * 通过分步查询查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpByStep(@Param("eid") int eid);

    /**
     * 分步查询的第二步： 根据员工所对应的did查询部门信息
     * @param did
     * @return
     */
    Dept getEmpDeptByStep(@Param("did") int did);

    /**
     * 根据部门id查新部门以及部门中的员工信息
     * @param did
     * @return
     */
    Dept getDeptEmpByDid(@Param("did") int did);

    List<Emp> getEmpListByCondition(Emp emp);

    List<Emp> getEmpListByChoose(Emp emp);

    int insertMoreEmp(@Param("emps") List<Emp> emps);
}
