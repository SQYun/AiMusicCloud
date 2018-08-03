package com.ht.service;

import java.util.List;

import com.ht.entity.User;

public interface IUserService {

    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public User getUser(String id);
    
    /**
     * 查询所有用户
     * @return
     */
    public List<User> getAllUser();
    
    /**
     * 新增用户
     * @param user
     */
    public void addUser(User user);
    
    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    public boolean delUser(String id);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);
}
