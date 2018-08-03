package com.ht.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.ISongDao;
import com.ht.entity.Song;

@Service
public class SongService implements ISongService{
	    @Autowired
	    private ISongDao songDao;
	    
	    @Override
	    public Song getSong(String id) {
	        return songDao.getSong(id);
	    }

	    @Override
	    public List<Song> getAllSong() {
	        return songDao.getAllSong();
	    }

	    @Override
	    @Transactional
	    public void songAdd(Song song) {
	        songDao.songAdd(song);
	    }

	    @Override
	    @Transactional
	    public boolean delSong(String id) {
	        return songDao.delSong(id);
	    }

	    @Override
	    @Transactional
	    public boolean updateSong(Song song) {
	        return songDao.updateSong(song);
	    }


}
