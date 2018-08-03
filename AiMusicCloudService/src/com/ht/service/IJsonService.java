package com.ht.service;

import java.util.List;

import com.ht.entity.SongNews;
import com.ht.entity.CdList;

public interface IJsonService {
	
	public List<SongNews> getSongNews();
	
	public List<CdList> getCdList();
	
	public List<SongNews> getSongShow(String cdId);

}
