package com.atguigu.mybatis.mapper;/*
 * @author jun
 * @date 2022/9/12 16:00
 * 概要：
 *
 */

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /*
    验证登录（使用@Param）
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);

    /*
    添加用户信息
     */
    int insertUser(User user);


    /*
    验证登入（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);

    /*
    查询所有员工的信息
     */
    List<User> getAllUser();

    /*
    根据用户名查询用户信息
    */
    User getUserByUsername(String username);

    /*
    验证登录
     */
    User checkLogin(String username,String password);
}
