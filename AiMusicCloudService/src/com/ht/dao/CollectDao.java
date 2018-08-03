package com.ht.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.Collect;

@Repository
public class CollectDao extends BaseDao<Collect> implements ICollectDao {

	@Override
	public List<Collect> getAllCollect() {
		return findAll(Collect.class);
	}

	@Override
	public Collect getCollect(String id) {
		return get(Collect.class, id);
	}

	@Override
	public void collectAdd(Collect collect) {
		save(collect);
	}

	@Override
	public boolean updateCollect(Collect collect) {
		update(collect);
        return true;
	}

	@Override
	public boolean delCollect(String id) {
		return delete(Collect.class, id);
	}

}
