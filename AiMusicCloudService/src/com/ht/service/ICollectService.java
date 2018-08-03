package com.ht.service;

import java.util.List;

import com.ht.entity.Collect;

public interface ICollectService {
	
	/**
     * 查询所有用户
     * @return
     */
    public List<Collect> getAllCollect();
    
    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public Collect getCollect(String id);
    
    /**
     * 新增用户
     * @param user
     */
    public void collectAdd(Collect collect);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateCollect(Collect collect);
    
    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    public boolean delCollect(String id);

}
