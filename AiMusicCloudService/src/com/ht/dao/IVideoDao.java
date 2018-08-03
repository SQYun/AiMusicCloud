package com.ht.dao;

import java.util.List;

import com.ht.entity.Video;

public interface IVideoDao {
	

	public List<Video> getAllVideo();
	
	public Video getVideo(String id);
	
	public void videoAdd(Video video);
	
	public boolean updateVideo(Video video);
	
	public boolean delVideo(String id);
	

}
