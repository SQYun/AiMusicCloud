package com.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.dao.IAdminDao;
import com.ht.entity.Admin;

@Service
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adminDao;
	
	
	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	@Override
	public Admin getAdmin(String id) {
		return adminDao.getAdmin(id);
	}
	
	@Override
	@Transactional
	public void userAdd(Admin admin) {
		adminDao.userAdd(admin);
	}

	@Override
	@Transactional
	public boolean updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	@Override
	@Transactional
	public boolean delAdmin(String id) {
		return adminDao.delAdmin(id);
	}

	
	

}
