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
     * ��ѯ�����û�
     * @return
     */
    public List<Manager> getAllManager();
    
    /**
     * ����id��ȡָ���û�
     * @param id
     * @return
     */
    public Manager getManager(String id);
    
    /**
     * �����û�
     * @param user
     */
    public void managerAdd(Manager manager);
    
    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public boolean updateManager(Manager manager);
    
    /**
     * ����idɾ��ָ���û�
     * @param id
     * @return
     */
    public boolean delManager(String id);
    
    
    public String getPwdByName(String name);

}
