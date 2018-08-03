package com.ht.service;

import java.util.List;

import com.ht.entity.Cd;

public interface ICdService {
	
	/**
     * ��ѯ�����û�
     * @return
     */
    public List<Cd> getAllCd();
    
    /**
     * ����id��ȡָ���û�
     * @param id
     * @return
     */
    public Cd getCd(String id);
    
    /**
     * �����û�
     * @param user
     */
    public void cdAdd(Cd cd);
    
    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public boolean updateCd(Cd cd);
    
    /**
     * ����idɾ��ָ���û�
     * @param id
     * @return
     */
    public boolean delCd(String id);

}
