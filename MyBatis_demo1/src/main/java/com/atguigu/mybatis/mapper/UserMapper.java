package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * myBatis面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名保持一致
     * 2.映射文件中SQL语句的id要和mapper接口中的方法名一致
     * @return
     *
     * 表--实体类--mapper接口--映射文件
     */
    //添加功能
    int insertUser();

    //修改功能
    void updateUser();

    //删除功能
    void deleteUser();

    //查询功能（根据id查询）
    User getUserById();

    //查询所有的用户信息
    List<User> getAllUser();
}
