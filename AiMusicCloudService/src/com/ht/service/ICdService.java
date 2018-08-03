package com.ht.service;

import java.util.List;

import com.ht.entity.Cd;

public interface ICdService {
	
	/**
     * 查询所有用户
     * @return
     */
    public List<Cd> getAllCd();
    
    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public Cd getCd(String id);
    
    /**
     * 新增用户
     * @param user
     */
    public void cdAdd(Cd cd);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateCd(Cd cd);
    
    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    public boolean delCd(String id);

}
