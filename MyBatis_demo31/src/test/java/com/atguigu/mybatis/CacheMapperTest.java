package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/*
 * @author jun
 * @date 2022/10/19 17:16
 * 概要：
 *
 */
public class CacheMapperTest {
    @Test
    public void testCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEid(1);
        Emp emp = emp1;
        System.out.println(emp);
        System.out.println(emp1);
    }

    @Test
    public void testCache2(){
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
//        Emp emp = mapper.getEmpByEid(1);
//        System.out.println(emp);

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
