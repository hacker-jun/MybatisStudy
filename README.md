# MyBatis学习代码

此代码是在学习尚硅谷的java讲师杨博超的MyBatis教材手敲的代码。

以下是一些注释笔记：

```java
/**
 * myBatis面向接口编程的两个一致
 * 1.映射文件的namespace要和mapper接口的全类名保持一致
 * 2.映射文件中SQL语句的id要和mapper接口中的方法名一致
 * @return
 *
 * 表--实体类--mapper接口--映射文件
 */
```

```java
/*
MyBatis获取参数值的两种方式：${}和#{}
${}本质字符串拼接
#{}本质占位符赋值
MyBatis获取参数值的各种情况
1.mapper接口方法的参数为单个的字面量类型
可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
2.mapper接口方法的参数为多个时
此时MyBatis会讲这些参数放在一个map集合中，以两种方式进行存储
a>以arg0，arg1,、、、为键，以参数为值
b>以param1，param2....为键，以参数为值
因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
只需要通过#{}和${}以键（自己设置的键）的方式访问值即可，但是需要注意${}的单引号问题
4.mapper接口方法的参数是实体类类型的参数
只需要通过#{}和${}以属性的方式访问属性值即可，但是需要注意的是${}的单引号问题
5.使用@Param注解命名参数
此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
a>以@Param注解的值为键，以参数为值
b>以Param1,param2...为键，以参数为值
因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
 */
```

```java
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
```

```java
/**
 *动态SQL：
 * 1.if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
 * 2.where：
 * 当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
 * 当where标签中没有内容时，此时where标签没有任何效果
 * 注意：where标签不能将其中内容后面多余的and或or去掉
 *
 * 3.trim
 * 若标签中有内容时：
 * prefix|suffix:将rim标签中内容前面或后面的指定内容
 * suffixOverrides|prefixOverrides:将trim标签中内容前面或后面去掉指定内容
 * 若标签中没有内容时,trim标签也没有任何效果
 *
 * 4.choose，when，otherWise，相当于if...else
 * when至少要有一个，otherwise最多只能有一个
 *
 * 5.foreach
 *collection：设置需要循环的数组或集合
 * item：表示数组或集合中的每一个数据
 * separator：循环体之间的分割符
 * open：foreach标签所循环的所有内容的开始符
 * close：foreach标签所循环的所有内容的结束符
 *
 *
 */
```

```java
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
```