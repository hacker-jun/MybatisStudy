package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper{
    /**
     * 多条件查询
     */
//    List<Emp> getEmpByCondition(Emp emp);
    List<Emp> getEmpByCondition(Emp emp);
    /**
     * 测试choose，when，otherwise
     *
     */
    List<Emp> getEmpBychoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     * @Param("emps")
     * 可以让操作者使用自己命名的常数emps参数访问
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
