package com.atguigu.mybatis.utils;/*
 * @author jun
 * @date 2022/9/12 16:12
 * 概要：
 *
 */

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
 * @author jun
 * @date 2022/9/12 16:12
 * 概要：
 *
 */
public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        //异常try/catch快捷键Ctrl+Alt+T
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
