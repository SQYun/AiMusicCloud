package com.ht.dao;

import java.util.List;

import com.ht.entity.Admin;

public interface IAdminDao {
	
	public List<Admin> getAllAdmin();
	
	public Admin getAdmin(String id);
	
	public void userAdd(Admin admin);
	
	public boolean updateAdmin(Admin admin);
	
	public boolean delAdmin(String id);

}
