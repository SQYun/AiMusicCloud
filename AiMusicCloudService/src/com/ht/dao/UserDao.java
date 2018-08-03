package com.ht.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.entity.User;

@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

    @Override
    public User getUser(String id) {
        return get(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        return findAll(User.class);
    }

    @Override
    public void addUser(User user) {
        save(user);
    }

    @Override
    public boolean delUser(String id) {
        return delete(User.class, id);
    }

    @Override
    public boolean updateUser(User user) {
        update(user);
        return true;
        
//        String hql = "update User u set u.userName = ?0,u.age=?1 where u.id = ?2";
        
//        Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setParameter(0, user.getUserName());
//        query.setParameter(1, user.getAge());
//        query.setParameter(2, user.getId());
//        
//        return (query.executeUpdate() > 0);
    }

}
