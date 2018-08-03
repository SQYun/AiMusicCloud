package com.ht.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.Cd;

@Repository
public class CdDao extends BaseDao<Cd> implements ICdDao {

	@Override
	public List<Cd> getAllCd() {
		return findAll(Cd.class);
	}

	@Override
	public Cd getCd(String id) {
		return get(Cd.class, id);
	}

	@Override
	public void cdAdd(Cd cd) {
		save(cd);
	}

	@Override
	public boolean updateCd(Cd cd) {
		update(cd);
        return true;
	}

	@Override
	public boolean delCd(String id) {
		return delete(Cd.class, id);
	}
 
}
