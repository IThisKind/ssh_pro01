package com.oracle.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Title: BaseDao
 * <p>
 * Description: Dao层基本的功能 <br>
 * <strong>专注service</strong> <br>
 * 任何Dao的接口都可以实现本接口拥有Dao的所有基本功能<br>
 * 提供了一个基本的Dao实现类 @see com.oracle.dao.impl.BaseDaoImpl <br>
 * Dao层的实现类都通过提供的基本Dao实现类拥有基本的功能 <br>
 * 如果方法不能满足业务需求 可以重写覆盖方法
 * </p>
 *
 * @author 牛向前
 * @version 1.0
 * @date 2019年1月6日 下午8:48:07
 * @see BaseDao
 */
public interface BaseDao<T, PK> // @param PK 主键数据类型
{
    /**
     * 新增
     *
     * @param entity
     */
    void save(T entity);

    /**
     * 更新
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 合并
     *
     * @param entity
     */
    void merge(T entity);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delete(Serializable id);

    /**
     * 通过id查找
     *
     * @param id
     * @return 实体
     */
    T get(Serializable id);

    /**
     * 通过指定条件查找单个实体
     *
     * @param hql
     * @param <V> queryCondition指定条件类
     * @return 实体
     */
    <V> T findByCondition(String hql, V queryCondition);

    /**
     * 查找所有
     *
     * @return List集合
     */
    List<T> findAll();

    /**
     * 根据指定条件查找所有
     *
     * @param <V>
     * @return List集合
     */
    <V> List<T> findListByCondition(String hql, V queryCondition);


    /**
     * 查询集合(带分页)
     *
     * @param page 当前页数
     * @param rows 每页大小
     * @return
     */
    List<T> findList(Integer page, Integer rows);

    /**
     * 查询集合(带分页)
     *
     * @param hql  查询语句
     * @param <V>  queryCondition 查询条件类
     * @param page 当前页码
     * @param rows 查询的条数
     * @return
     */
    <V> List<T> find(String hql, V queryCondition, Integer page, Integer rows);

    /**
     * 查询所有行数 默认查询当前类泛型T的pojo实体
     * <p>
     * select count(*) from 类
     *
     * @return
     */
    Long count();

    /**
     * 查询所有行数
     * <p>
     * select count(*) from 类
     *
     * @param hql
     * @return
     */
    Long count(String hql);

    /**
     * 查询所有行数,根据条件
     * <p>
     * select count(*) from 类
     *
     * @param <V>
     * @param hql
     * @param <V> queryCondition 查询条件类
     * @return
     */
    <V> Long count(String hql, V queryCondition);

    /**
     * 执行HQL语句
     * 传入参数
     *
     * @param hql
     * @param objects 占位符的值
     * @return 返回影响的行数
     */
    Integer executeHql(String hql, Object... objects);

    /**
     * 执行HQL语句
     *
     * @param hql
     * @param <V> condition 指定条件
     * @return 返回影响的行数
     */
    <V> Integer executeHql(String hql, V condition);

    /**
     * 执行SQL语句
     *
     * @param sql
     * @param objects 占位符的值
     * @return 返回影响的行数
     */
    Integer executeSql(String sql, Object... objects);

    /**
     * 执行SQL语句
     *
     * @param sql
     * @param <V> condition 指定条件
     * @return 返回影响的行数
     */
    <V> Integer executeSql(String sql, V condition);

}