package com.ht.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.Song;

@Repository
public class SongDao extends BaseDao<Song> implements ISongDao {
	@Override
	public List<Song> getAllSong() {
		return findAll(Song.class);
	}

	@Override
	public Song getSong(String id) {
		return get(Song.class, id);
	}

	@Override
	public void songAdd(Song song) {
		save(song);
	}

	@Override
	public boolean updateSong(Song song) {
		update(song);
        return true;
	}

	@Override
	public boolean delSong(String id) {
		return delete(Song.class, id);
	}

}
