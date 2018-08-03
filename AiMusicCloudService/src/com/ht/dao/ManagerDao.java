package com.ht.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ht.entity.Manager;

@Repository
public class ManagerDao extends BaseDao<Manager> implements IManagerDao {

	@Override
	public List<Manager> getAllManager() {
		return findAll(Manager.class);
	}

	@Override
	public Manager getManager(String id) {
		return get(Manager.class, id);
	}

	@Override
	public void managerAdd(Manager manager) {
		save(manager);
	}

	@Override
	public boolean updateManager(Manager manager) {
		update(manager);
        return true;
	}

	@Override
	public boolean delManager(String id) {
		return delete(Manager.class, id);
	}

	@Override
	public String getPwdByName(String name) {
		String hql = "select m.manager_pwd from Manager m where m.manager_name = '"+name+"'";
		/*return sessionFactory.getCurrentSession()
                .createQuery(hql).toString();*/
		

		Query q = sessionFactory.getCurrentSession()
                .createQuery(hql);
		String managerName = (String)q.uniqueResult();  
		return managerName;

	}


}
