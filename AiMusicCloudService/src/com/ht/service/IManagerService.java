package com.ht.service;

import java.util.List;

import com.ht.entity.Manager;


/**
 * @author HT
 *
 */
/**
 * @author HT
 *
 */
public interface IManagerService {
	
	/**
     * 查询所有用户
     * @return
     */
    public List<Manager> getAllManager();
    
    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public Manager getManager(String id);
    
    /**
     * 新增用户
     * @param user
     */
    public void managerAdd(Manager manager);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateManager(Manager manager);
    
    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    public boolean delManager(String id);
    
    
    public String getPwdByName(String name);

}
