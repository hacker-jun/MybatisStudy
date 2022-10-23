package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/*
 * @author jun
 * @date 2022/9/25 11:54
 * 概要：
 *
 */
public class SelectMapperTest {
    /*
    MyBatis的各种查询功能
    1.若查询出的数据只有一条，可以通过实体类对象或者集合接收
        <1>可以通过实体类对象接收
        <2>可以通过list集合接收
    2.若查询出的数据有多条
        <1>可以通过list集合接收，一定不能通过实体类对象接收，此时会抛出异常TooManyResultException
        <2>可以通过map类型的list集合接收
        <3>可以通过mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值放在同一个map集合中
     MyBatis中设置了默认的类型别名
     java.lang.Integer-->int,integer
     int --> _int,_integer
     Map --> map
     String --> string
     */
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdMap(4));
    }

    @Test
    public void testgetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());

    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(4));

    }
}








