package com.ht.service;
import java.util.List;

import com.ht.entity.Song;

	public interface ISongService {
		
		/**
	     * ��ѯ���и���
	     * @return
	     */
	    public List<Song> getAllSong();
	    
	    /**
	     * ����id��ȡָ������
	     * @param id
	     * @return
	     */
	    public Song getSong(String id);
	    
	    /**
	     * ��������
	     * @param song
	     */
	    public void songAdd(Song song);
	    
	    /**
	     * ���¸�����Ϣ
	     * @param song
	     * @return
	     */
	    public boolean updateSong(Song song);
	    
	    /**
	     * ����idɾ��ָ������
	     * @param id
	     * @return
	     */
	    public boolean delSong(String id);

	}

