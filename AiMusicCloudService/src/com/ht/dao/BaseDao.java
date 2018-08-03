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
     * ����HQL����ѯʵ��
     * @param hql           ����ѯ��HQL���
     * @return
     */
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql) {
        return sessionFactory.getCurrentSession()
                             .createQuery(hql)
                             .list();
    }
    
    /**
     * ���ݴ�ռλ������HQL����ѯʵ��
     * @param hql           ����ѯ��HQL���
     * @param params        ����
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
     * ʹ��hql �����з�ҳ��ѯ����
     * @param hql       ��Ҫ��ѯ��hql���
     * @param pageNo    ��ѯ��pageNoҳ�ļ�¼
     * @param pageSize  ÿҳ��Ҫ��ʾ�ļ�¼��
     * @return          ��ǰҳ�����м�¼
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize) {
        Query<T> query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.setFirstResult((pageNo-1) * pageSize)
                    .setMaxResults(pageSize)
                    .list();
    }
    
    /**
     * ʹ��hql �����з�ҳ��ѯ����
     * @param hql       ��Ҫ��ѯ��hql���
     * @param pageNo    ��ѯ��pageNoҳ�ļ�¼
     * @param pageSize  ÿҳ��Ҫ��ʾ�ļ�¼��
     * @param params    ���hql��ռλ��������params���ڴ���ռλ������
     * @return          ��ǰҳ�����м�¼
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
