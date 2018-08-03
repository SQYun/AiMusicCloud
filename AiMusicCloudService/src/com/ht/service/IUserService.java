package com.ht.service;

import java.util.List;

import com.ht.entity.User;

public interface IUserService {

    /**
     * ����id��ȡָ���û�
     * @param id
     * @return
     */
    public User getUser(String id);
    
    /**
     * ��ѯ�����û�
     * @return
     */
    public List<User> getAllUser();
    
    /**
     * �����û�
     * @param user
     */
    public void addUser(User user);
    
    /**
     * ����idɾ��ָ���û�
     * @param id
     * @return
     */
    public boolean delUser(String id);
    
    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public boolean updateUser(User user);
}
