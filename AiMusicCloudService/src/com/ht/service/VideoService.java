package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.IVideoDao;
import com.ht.entity.Video;

@Service
public class VideoService implements IVideoService {
	
	@Autowired
	private IVideoDao videoDao;

	@Override
	public List<Video> getAllVideo() {
		return videoDao.getAllVideo();
	}

	@Override
	public Video getVideo(String id) {
		return videoDao.getVideo(id);
	}

	@Override
	@Transactional
	public void videoAdd(Video video) {
		videoDao.videoAdd(video);
	}

	@Override
	@Transactional
	public boolean updateVideo(Video video) {
		return videoDao.updateVideo(video);
	}

	@Override
	@Transactional
	public boolean delVideo(String id) {
		return videoDao.delVideo(id);
	}


}
