package com.ht.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.Admin;

@Repository
public class AdminDao extends BaseDao<Admin> implements IAdminDao {

	@Override
	public List<Admin> getAllAdmin() {
		return findAll(Admin.class);
	}

	@Override
	public Admin getAdmin(String id) {
		return get(Admin.class, id);
	}

	@Override
	public void userAdd(Admin admin) {
		save(admin);
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		update(admin);
        return true;
	}

	@Override
	public boolean delAdmin(String id) {
		return delete(Admin.class, id);
	}


}
