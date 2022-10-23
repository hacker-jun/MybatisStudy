package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /*
    根据ID查询用户信息
     */
    List<User> getUserById(@Param("id")Integer id);

    /*
    查询所有用户的信息
     */
    List<User> getAllUser();

    /*
    查询用户总数
     */
    Integer getCount();

    /*
    根据ID查询用户信息为一个map集合
     */
    Map<String,Object> getUserByIdMap(@Param("id" )Integer id);

    /*
    查询所有用户信息为map集合
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    /*
    添加用户信息
     */
    void insertUser(User user);
}
