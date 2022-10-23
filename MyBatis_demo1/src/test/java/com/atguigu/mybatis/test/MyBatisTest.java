package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    /*
    SqlSession 默认不自动提交事务，若需要自动提交事务
    可以使用SqlSessionFactory.openSession(true);
     */
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        int result = mapper.insertUser();
        //提交事务
        sqlSession.commit();

        System.out.printf("result:"+result);

    }
    @Test
    public void testUpdate() throws IOException {
        //第一步获取或者说是加载配置文件，然后获取字节输入流“is",这里把异常声明出去就好了
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //第二步创建一个SqlSessionFactoryBuilder对象，通过其中的build方法读取核心配置文件即“mybatis-config.xml”所获取的is来获取咱们的工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //然后再根据工厂对象获取我们的SqlSession对象，这里加true表示自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();

    }

    @Test
    public void testDelete() throws IOException {
        //第一步获取或者说是加载配置文件，然后获取字节输入流“is",这里把异常声明出去就好了
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //第二步创建一个SqlSessionFactoryBuilder对象，通过其中的build方法读取核心配置文件即“mybatis-config.xml”所获取的is来获取咱们的工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //然后再根据工厂对象获取我们的SqlSession对象，这里加true表示自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();

    }

    @Test
    public void testSelect() throws IOException {
        //第一步获取或者说是加载配置文件，然后获取字节输入流“is",这里把异常声明出去就好了
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //第二步创建一个SqlSessionFactoryBuilder对象，通过其中的build方法读取核心配置文件即“mybatis-config.xml”所获取的is来获取咱们的工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //然后再根据工厂对象获取我们的SqlSession对象，这里加true表示自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testSelectAllUser() throws IOException {
        //第一步获取或者说是加载配置文件，然后获取字节输入流“is",这里把异常声明出去就好了
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //第二步创建一个SqlSessionFactoryBuilder对象，通过其中的build方法读取核心配置文件即“mybatis-config.xml”所获取的is来获取咱们的工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //然后再根据工厂对象获取我们的SqlSession对象，这里加true表示自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}
