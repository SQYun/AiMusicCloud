package com.ht.dao;

import java.util.List;

import com.ht.entity.Cd;

public interface ICdDao {
	
public List<Cd> getAllCd();
	
	public Cd getCd(String id);
	
	public void cdAdd(Cd cd);
	
	public boolean updateCd(Cd cd);
	
	public boolean delCd(String id);
	
}
