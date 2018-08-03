package com.ht.service;

import java.util.List;

import com.ht.entity.Collect;

public interface ICollectService {
	
	/**
     * ��ѯ�����û�
     * @return
     */
    public List<Collect> getAllCollect();
    
    /**
     * ����id��ȡָ���û�
     * @param id
     * @return
     */
    public Collect getCollect(String id);
    
    /**
     * �����û�
     * @param user
     */
    public void collectAdd(Collect collect);
    
    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public boolean updateCollect(Collect collect);
    
    /**
     * ����idɾ��ָ���û�
     * @param id
     * @return
     */
    public boolean delCollect(String id);

}
