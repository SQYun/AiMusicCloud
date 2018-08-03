package com.ht.dao;

import java.util.List;

import com.ht.entity.Collect;

public interface ICollectDao {

	public List<Collect> getAllCollect();
	
	public Collect getCollect(String id);
	
	public void collectAdd(Collect collect);
	
	public boolean updateCollect(Collect collect);
	
	public boolean delCollect(String id);
}
