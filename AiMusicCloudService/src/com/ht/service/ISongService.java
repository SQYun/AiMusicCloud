package com.ht.service;
import java.util.List;

import com.ht.entity.Song;

	public interface ISongService {
		
		/**
	     * 查询所有歌曲
	     * @return
	     */
	    public List<Song> getAllSong();
	    
	    /**
	     * 根据id获取指定歌曲
	     * @param id
	     * @return
	     */
	    public Song getSong(String id);
	    
	    /**
	     * 新增歌曲
	     * @param song
	     */
	    public void songAdd(Song song);
	    
	    /**
	     * 更新歌曲信息
	     * @param song
	     * @return
	     */
	    public boolean updateSong(Song song);
	    
	    /**
	     * 根据id删除指定歌曲
	     * @param id
	     * @return
	     */
	    public boolean delSong(String id);

	}

