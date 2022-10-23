package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

/*
 * @author jun
 * @date 2022/10/7 20:04
 * 概要：
 *
 */
public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况；
     * a>为字段起别名，保持和属性名的一致
     * b>设置全局配置，将_自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c>通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *     <id property="eid" column="eid"></id>
     *     <result property="empName" column="emp_name"></result>
     *     <result property="age" column="age"></result>
     *     <result property="sex" column="sex"></result>
     *     <result property="email" column="email"></result>
     * </resultMap>
     *
     * 处理多对一的映射关系
     * a>级联属性赋值
     * b>association
     * c>分步查询
     *
     *
     * 处理一对多的映射关系
     * a>collection
     * b>分步查询
     */
    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp1.getAge());
        System.out.println("+++++++++++++++++++++++");
        System.out.println("开启延迟加载设置下获取部门信息，执行不同的SQL语句");
        System.out.println(emp1.getDept());


    }

    /*
    * testGetEmpAndDept运行错误，但是虽然简单呢，以后用的并不多，理解就行
    * */
    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = mapper.getEmpAndDept(3);
        System.out.println(emp1);
    }
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }



    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
        System.out.println("+++++++++++++");
        System.out.println("如果有延迟加载，就只会执行查询部门的SQL");
        System.out.println(dept.getDeptName());
    }

    @Test
    public void s(){

    }
}
