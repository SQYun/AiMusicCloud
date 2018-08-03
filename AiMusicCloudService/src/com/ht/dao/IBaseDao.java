package com.ht.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
    
    /**
     * ����ID����ʵ��
     * @param entityClazz
     * @param id
     * @return
     */
    T get(Class<T> entityClazz , Serializable id);
    
    /**
     * ����ʵ��
     * @param entity
     * @return
     */
    Serializable save(T entity);
    
    /**
     * ����ʵ��
     * @param entity
     */
    void update(T entity);
    
    /**
     * ɾ��ʵ��
     * @param entity
     */
    void delete(T entity);
    
    /**
     * ����IDɾ��ʵ��
     * @param entityClazz
     * @param id
     */
    boolean delete(Class<T> entityClazz , Serializable id);
    
    /**
     * ��ȡ����ʵ��
     * @param entityClazz
     * @return
     */
    List<T> findAll(Class<T> entityClazz);
    
    /**
     * ��ȡʵ������
     * @param entityClazz
     * @return
     */
    long findCount(Class<T> entityClazz);
    
}
