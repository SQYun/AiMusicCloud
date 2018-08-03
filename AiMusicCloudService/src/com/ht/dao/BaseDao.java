package com.ht.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> implements IBaseDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    
    @Override
    public T get(Class<T> entityClazz, Serializable id) {
        return sessionFactory.getCurrentSession().get(entityClazz, id);
    }

    @Override
    public Serializable save(T entity) {
    	
    	System.out.println("---------save------------");
        return sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
    	
    	System.out.println("--------update----------");
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean delete(Class<T> entityClazz, Serializable id) {
        String hql = "delete " + entityClazz.getSimpleName() + " en where en.id = ?0";
        Query<T> query = sessionFactory.getCurrentSession()
                                 .createQuery(hql)
                                 .setParameter("0", id);
        return (query.executeUpdate() > 0);
    }

    @Override
    public List<T> findAll(Class<T> entityClazz) {
        String hql = "select en from " + entityClazz.getSimpleName() + " en";
        return find(hql);
    }

    @Override
    public long findCount(Class<T> entityClazz) {
        String  hql  = "select count(*) from " + entityClazz.getSimpleName();
        List<T> list = find(hql);
        if (list != null && list.size() == 1) {
            return (Long) list.get(0);
        }
        return 0;
    }

    /**
     * 根据HQL语句查询实体
     * @param hql           待查询的HQL语句
     * @return
     */
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql) {
        return sessionFactory.getCurrentSession()
                             .createQuery(hql)
                             .list();
    }
    
    /**
     * 根据带占位符参数HQL语句查询实体
     * @param hql           待查询的HQL语句
     * @param params        参数
     * @return
     */
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql, Object... params) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery(hql);
        
        for (int i=0, len=params.length; i<len; i++) {
            query.setParameter(i + "", params[i]);
        }
        return query.list();
    }
    
    /**
     * 使用hql 语句进行分页查询操作
     * @param hql       需要查询的hql语句
     * @param pageNo    查询第pageNo页的记录
     * @param pageSize  每页需要显示的记录数
     * @return          当前页的所有记录
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.setFirstResult((pageNo-1) * pageSize)
                    .setMaxResults(pageSize)
                    .list();
    }
    
    /**
     * 使用hql 语句进行分页查询操作
     * @param hql       需要查询的hql语句
     * @param pageNo    查询第pageNo页的记录
     * @param pageSize  每页需要显示的记录数
     * @param params    如果hql带占位符参数，params用于传入占位符参数
     * @return          当前页的所有记录
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql , int pageNo, int pageSize, Object... params) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery(hql);
        for (int i=0, len=params.length; i<len; i++) {
            query.setParameter(i + "", params[i]);
        }
        return query.setFirstResult((pageNo - 1) + pageSize)
                    .setMaxResults(pageSize)
                    .list();
    }
}
