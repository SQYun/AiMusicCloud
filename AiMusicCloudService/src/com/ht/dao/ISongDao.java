package com.ht.dao;

import java.util.List;

import com.ht.entity.Song;
public interface ISongDao {
	
	public List<Song> getAllSong();
	
	public Song getSong(String id);
	
	public void songAdd(Song song);
	
	public boolean updateSong(Song song);
	
	public boolean delSong(String id);

}
