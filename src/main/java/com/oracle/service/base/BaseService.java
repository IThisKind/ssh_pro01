package com.oracle.service.base;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.oracle.service.Page;

/**
 * <p>
 * Title: BaseService
 * <p>
 * Description: service业务层基本的功能 <br>
 * 任何service的接口都可以实现本接口拥有本接口的所有基本功能<br>
 * 提供了一个基本的业务实现类 @see com.oracle.dao.impl.BaseServiceImpl <br>
 * service层的实现类都通过提供的基本service实现类拥有基本的功能 <br>
 * 如果方法不能满足业务需求 可以重写覆盖方法
 * </p>
 * <p>
 * Copyright: dingdang (c) 2018
 * <p>
 * Company: www.oracle.com
 *
 * @author 牛向前
 * @version 1.0
 * @date 2019年1月6日 下午10:39:08
 */
public interface BaseService<E, PK> // @param PK 主键数据类型
{

    /**
     * 添加一个实体
     *
     * @param entity
     */
    boolean addEntity(E entity);

    /**
     * 根据id删除一个实体
     *
     * @param id
     */
    boolean deleteEntityById(Serializable id);


    /**
     * 根据id得到一个实体
     *
     * @param id
     * @return
     */
    E getEntityById(Serializable id);

    /**
     * 更新一个实体
     *
     * @param entity
     */
    boolean updateEntity(E entity);

    /**
     * 查询所有
     *
     * @return
     */
    List<E> findAll();

    /**
     * 统计行数 默认统计当前泛型类E 的实体表
     *
     * @return
     */
    Long count();

    /**
     * 查询一页数据
     *
     * @param page 当前页数
     * @param rows 每页大小
     * @return
     */
    Page<E> findOnePage(Integer page, Integer rows);

}
