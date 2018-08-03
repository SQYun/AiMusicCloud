package com.ht.dao;

import java.util.List;

import com.ht.entity.CdList;
import com.ht.entity.SongNews;

public interface IJsonDao {

	public List<SongNews> getSongNews();
	
	public List<CdList> getCdList();
	
	public List<SongNews> getSongShow(String cdId);
	
}
