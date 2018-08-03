package com.ht.dao;

import java.util.List;

import com.ht.entity.Image;
public interface IImageDao {
	
	public List<Image> getAllImage();
	
	public Image getImage(String id);
	
	public void imageAdd(Image image);
	
	public boolean updateImage(Image image);
	
	public boolean delImage(String id);

}

