package com.ht.dao;

import java.util.List;

import com.ht.entity.Manager;

public interface IManagerDao {
	
	public List<Manager> getAllManager();
	
	public Manager getManager(String id);
	
	public void managerAdd(Manager manager);
	
	public boolean updateManager(Manager manager);
	
	public boolean delManager(String id);
	
	public String getPwdByName(String name);

}
