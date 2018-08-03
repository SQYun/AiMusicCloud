package com.ht.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.Image;

@Repository
public class ImageDao extends BaseDao<Image> implements IImageDao {
	@Override
	public List<Image> getAllImage() {
		return findAll(Image.class);
	}

	@Override
	public Image getImage(String id) {
		return get(Image.class, id);
	}

	@Override
	public void imageAdd(Image image) {
		save(image);
	}

	@Override
	public boolean updateImage(Image image) {
		update(image);
        return true;
	}

	@Override
	public boolean delImage(String id) {
		return delete(Image.class, id);
	}

}
