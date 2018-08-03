package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.IManagerDao;
import com.ht.entity.Manager;

@Service
public class ManagerService implements IManagerService {

	@Autowired
	private IManagerDao managerDao;
	
	
	@Override
	public List<Manager> getAllManager() {
		return managerDao.getAllManager();
	}

	@Override
	public Manager getManager(String id) {
		return managerDao.getManager(id);
	}
	
	@Override
	@Transactional
	public void managerAdd(Manager manager) {
		managerDao.managerAdd(manager);
	}

	@Override
	@Transactional
	public boolean updateManager(Manager manager) {
		return managerDao.updateManager(manager);
	}

	@Override
	@Transactional
	public boolean delManager(String id) {
		return managerDao.delManager(id);
	}

	@Override
	public String getPwdByName(String name) {
		return managerDao.getPwdByName(name);
	}

	
	

}
