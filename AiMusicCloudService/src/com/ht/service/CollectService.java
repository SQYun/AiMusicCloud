package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.ICollectDao;
import com.ht.entity.Collect;

@Service
public class CollectService implements ICollectService {
	
	@Autowired
	private ICollectDao collectDao;

	@Override
	public List<Collect> getAllCollect() {
		return collectDao.getAllCollect();
	}

	@Override
	public Collect getCollect(String id) {
		return collectDao.getCollect(id);
	}

	@Override
	@Transactional
	public void collectAdd(Collect collect) {
		collectDao.collectAdd(collect);		
	}

	@Override
	@Transactional
	public boolean updateCollect(Collect collect) {
		return collectDao.updateCollect(collect);
	}

	@Override
	@Transactional
	public boolean delCollect(String id) {
		return collectDao.delCollect(id);
	}

}
