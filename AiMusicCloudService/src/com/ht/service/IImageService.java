package com.ht.service;

import java.util.List;

import com.ht.entity.Image;


public interface IImageService {
	
	/**
     * ��ѯ������Ƭ
     * @return
     */
    public List<Image> getAllImage();
    
    /**
     * ����id��ȡָ����Ƭ
     * @param id
     * @return
     */
    public Image getImage(String id);
    
    /**
     * ������Ƭ
     * @param user
     */
    public void imageAdd(Image image);
    
    /**
     * ������Ƭ��Ϣ
     * @param user
     * @return
     */
    public boolean updateImage(Image image);
    
    /**
     * ����idɾ��ָ����Ƭ
     * @param id
     * @return
     */
    public boolean delImage(String id);

}
