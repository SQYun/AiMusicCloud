package com.ht.service;

import java.util.List;

import com.ht.entity.Video;

public interface IVideoService {
	
	/**
     * ��ѯ�����û�
     * @return
     */
    public List<Video> getAllVideo();
    
    /**
     * ����id��ȡָ���û�
     * @param id
     * @return
     */
    public Video getVideo(String id);
    
    /**
     * �����û�
     * @param user
     */
    public void videoAdd(Video video);
    
    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public boolean updateVideo(Video video);
    
    /**
     * ����idɾ��ָ���û�
     * @param id
     * @return
     */
    public boolean delVideo(String id);

}
