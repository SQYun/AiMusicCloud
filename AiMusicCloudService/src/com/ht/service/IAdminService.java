package com.ht.service;

import java.util.List;

import com.ht.entity.Admin;


public interface IAdminService {
	
	/**
     * 查询所有用户
     * @return
     */
    public List<Admin> getAllAdmin();
    
    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public Admin getAdmin(String id);
    
    /**
     * 新增用户
     * @param user
     */
    public void userAdd(Admin admin);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateAdmin(Admin admin);
    
    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    public boolean delAdmin(String id);

}
