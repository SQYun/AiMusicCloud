package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.IImageDao;
import com.ht.entity.Image;

@Service
public class ImageService implements IImageService {

	@Autowired
	private IImageDao imageDao;
	
	
	@Override
	public List<Image> getAllImage() {
		return imageDao.getAllImage();
	}

	@Override
	public Image getImage(String id) {
		return imageDao.getImage(id);
	}
	
	@Override
	@Transactional
	public void imageAdd(Image image) {
		imageDao.imageAdd(image);
	}

	@Override
	@Transactional
	public boolean updateImage(Image image) {
		return imageDao.updateImage(image);
	}

	@Override
	@Transactional
	public boolean delImage(String id) {
		return imageDao.delImage(id);
	}

	
	

}
