package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.entity.CdList;
import com.ht.dao.IJsonDao;
import com.ht.entity.SongNews;

@Service
public class JsonService implements IJsonService {

	@Autowired
	private IJsonDao jsonDao;
	
	@Override
	public List<SongNews> getSongNews() {
		return jsonDao.getSongNews();
	}

	@Override
	public List<CdList> getCdList() {
		return jsonDao.getCdList();
	}

	@Override
	public List<SongNews> getSongShow(String cdId) {
		return jsonDao.getSongShow(cdId);
	}

	
}
