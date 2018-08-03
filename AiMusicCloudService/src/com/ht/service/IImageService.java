package com.ht.service;

import java.util.List;

import com.ht.entity.Image;


public interface IImageService {
	
	/**
     * 查询所有照片
     * @return
     */
    public List<Image> getAllImage();
    
    /**
     * 根据id获取指定照片
     * @param id
     * @return
     */
    public Image getImage(String id);
    
    /**
     * 新增照片
     * @param user
     */
    public void imageAdd(Image image);
    
    /**
     * 更新照片信息
     * @param user
     * @return
     */
    public boolean updateImage(Image image);
    
    /**
     * 根据id删除指定照片
     * @param id
     * @return
     */
    public boolean delImage(String id);

}
