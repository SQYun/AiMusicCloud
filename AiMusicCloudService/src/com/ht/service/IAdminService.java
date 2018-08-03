package com.ht.service;

import java.util.List;

import com.ht.entity.Admin;


public interface IAdminService {
	
	/**
     * ��ѯ�����û�
     * @return
     */
    public List<Admin> getAllAdmin();
    
    /**
     * ����id��ȡָ���û�
     * @param id
     * @return
     */
    public Admin getAdmin(String id);
    
    /**
     * �����û�
     * @param user
     */
    public void userAdd(Admin admin);
    
    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public boolean updateAdmin(Admin admin);
    
    /**
     * ����idɾ��ָ���û�
     * @param id
     * @return
     */
    public boolean delAdmin(String id);

}
