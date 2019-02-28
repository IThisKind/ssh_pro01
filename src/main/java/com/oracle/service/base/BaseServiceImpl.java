package com.oracle.service.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import com.oracle.dao.base.BaseDao;
import com.oracle.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: BaseServiceImpl
 * <p>
 * Description:基本业务的实现类
 * <p>
 * Copyright: dingdang (c) 2018
 * <p>
 * Company: www.oracle.com
 *
 * @param <T>
 * @author 牛向前
 * @version 1.0
 * @date 2019年1月6日 下午10:44:55
 */
@SuppressWarnings("all")
@Transactional
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

    /**
     * 泛型clazz的使用请参看
     *
     * @see com.oracle.dao.Impl.BaseDaoImpl#findAll()
     * @see com.oracle.dao.Impl.BaseDaoImpl#count()
     */
    private Class<T> clazz;

    // 自动按照类型注入
    @Autowired
    private BaseDao<T, PK> baseDao;

    public BaseServiceImpl() {
        // this表示当前被实例化的对象
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public boolean addEntity(T entity) {
        boolean flag = false;
        try {
            baseDao.save(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }

    @Override
    public boolean deleteEntityById(Serializable id) {
        boolean flag = false;
        try {
            baseDao.delete(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public T getEntityById(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public boolean updateEntity(T entity) {
        boolean flag = false;
        try {
            baseDao.update(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }


    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public Long count() {
        return baseDao.count();
    }

    @Override
    public Page<T> findOnePage(Integer page, Integer rows) {

        try {
            page = page < 1 ? 1 : page;
            rows = rows < 1 ? 6 : rows;
        } catch (Exception e) {
            page = 1;
            rows = 6;
            e.printStackTrace();
        }
        Page p = new Page();
        Long count = baseDao.count();
        p.setPageSize(rows);
        p.setTotalCount(count.intValue());

        if (page > p.getTotalPageCount()) {
            page = p.getTotalPageCount();
        }
        p.setCurrPageNo(page);

        List<T> list = baseDao.findList(page, rows);

        p.setData(list);

        return p;
    }

}
