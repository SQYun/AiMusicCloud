package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.ICdDao;
import com.ht.entity.Cd;

@Service
public class CdService implements ICdService {
	
	@Autowired
	private ICdDao cdDao;

	@Override
	public List<Cd> getAllCd() {
		return cdDao.getAllCd();
	}

	@Override
	public Cd getCd(String id) {
		return cdDao.getCd(id);
	}

	@Override
	@Transactional
	public void cdAdd(Cd cd) {
		cdDao.cdAdd(cd);
	}

	@Override
	@Transactional
	public boolean updateCd(Cd cd) {
		return cdDao.updateCd(cd);
	}

	@Override
	@Transactional
	public boolean delCd(String id) {
		return cdDao.delCd(id);
	}


}
