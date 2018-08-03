package com.ht.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.Video;

@Repository
public class VideoDao extends BaseDao<Video> implements IVideoDao {

	@Override
	public List<Video> getAllVideo() {
		return findAll(Video.class);
	}

	@Override
	public Video getVideo(String id) {
		return get(Video.class, id);
	}

	@Override
	public void videoAdd(Video video) {
		save(video);
		
	}

	@Override
	public boolean updateVideo(Video video) {
		update(video);
        return true;
	}

	@Override
	public boolean delVideo(String id) {
		return delete(Video.class, id);
	}

}
