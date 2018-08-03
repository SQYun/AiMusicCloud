package com.ht.service;

import java.util.List;

import com.ht.entity.Video;

public interface IVideoService {
	
	/**
     * 查询所有用户
     * @return
     */
    public List<Video> getAllVideo();
    
    /**
     * 根据id获取指定用户
     * @param id
     * @return
     */
    public Video getVideo(String id);
    
    /**
     * 新增用户
     * @param user
     */
    public void videoAdd(Video video);
    
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public boolean updateVideo(Video video);
    
    /**
     * 根据id删除指定用户
     * @param id
     * @return
     */
    public boolean delVideo(String id);

}
