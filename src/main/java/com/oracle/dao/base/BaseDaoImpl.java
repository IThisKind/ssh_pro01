package com.oracle.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;


/**
 * <p>
 * Title: BaseDaoImpl
 * <p>
 * Description: 本实现类实现了Dao层的常用方法
 *
 * @author 牛向前
 * @version 1.0
 * @date 2019年1月6日 下午8:49:22
 * @see com.oracle.dao.IBaseDao
 */
@SuppressWarnings("all")
@Component("baseDao")
@Scope("prototype")
public abstract class BaseDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<T, PK> {

    /**
     * 请查看 findAll,count方法
     *
     * @see #findAll()
     * @see #count()
     */
    private Class<T> clazz;

    // 按照类型自动注入sessionFactory
    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public BaseDaoImpl() {
        // this表示当前被实例化的对象；如UserDaoImpl
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    /**
     * 获取session
     *
     * @return session
     */
    public Session getCurrentSession() {
        Session session = null;
        try {
            session = getSessionFactory().getCurrentSession();
        } catch (HibernateException e) {
            logger.error("获取当前线程session异常 " + this.getClass());
            session = getSessionFactory().openSession();
        }
        return session;
    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void merge(T entity) {
        getHibernateTemplate().merge(entity);
    }

    @Override
    public void delete(Serializable id) {
        getHibernateTemplate().delete(get(id));
    }

    @Override
    public T get(Serializable id) {
        return getHibernateTemplate().get(clazz, id);
    }

    @Override
    public <V> T findByCondition(String hql, V queryCondition) {
        List<T> reslut = (List<T>) getHibernateTemplate().findByValueBean(hql, queryCondition);
        return reslut.isEmpty() ? null : reslut.get(0);
    }

    @Override
    public <V> List<T> findListByCondition(String hql, V queryCondition) {
        return (List<T>) getHibernateTemplate().findByValueBean(hql, queryCondition);
    }

    @Override
    public List<T> findAll() {
        // 根据实现类泛型的类型返回相应的查询对象结果
        return getCurrentSession().createQuery("FROM " + clazz.getName()).list();

    }

    @Override
    public List<T> findList(Integer page, Integer rows) {

        List<T> list = getCurrentSession().createQuery("FROM " + clazz.getName())
                .setFirstResult((page - 1) * rows).setMaxResults(rows).list();
        System.out.println("分页查询*************");
        for (T t : list) {
            System.out.println(t);
        }

        return list;
    }

    @Override
    public <V> List<T> find(String hql, V queryCondition, Integer page, Integer rows) {

        return getCurrentSession().createQuery(hql).setProperties(queryCondition).setFirstResult((page - 1) * rows)
                .setMaxResults(rows).list();

    }

    @Override
    public Long count() {
        // 根据实现类泛型的类型返回相应的查询对象结果
        return (Long) getCurrentSession().createQuery("select count(*) FROM " + clazz.getName()).uniqueResult();
    }

    @Override
    public Long count(String hql) {
        return (Long) getCurrentSession().createQuery(hql).uniqueResult();
    }

    @Override
    public <V> Long count(String hql, V queryCondition) {
        return (Long) getCurrentSession().createQuery(hql).setProperties(queryCondition).uniqueResult();
    }

    @Override
    public Integer executeHql(String hql, Object... objects) {

        Query query = getCurrentSession().createQuery(hql);

        // 给参数赋值
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        return query.executeUpdate();

    }

    @Override
    public <V> Integer executeHql(String hql, V condition) {
        return getCurrentSession().createQuery(hql).setProperties(condition).executeUpdate();

    }

    @Override
    public Integer executeSql(String sql, Object... objects) {
        Query query = getCurrentSession().createSQLQuery(sql);

        // 给参数赋值
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i + 1, objects[i]);
        }
        return query.executeUpdate();
    }

    @Override
    public <V> Integer executeSql(String sql, V condition) {
        return getCurrentSession().createSQLQuery(sql).setProperties(condition).executeUpdate();
    }

}
