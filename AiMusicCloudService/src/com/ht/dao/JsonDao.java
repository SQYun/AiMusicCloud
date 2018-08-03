package com.ht.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ht.entity.CdList;
import com.ht.entity.SongNews;

@Repository
public class JsonDao implements IJsonDao {
	
	  @Autowired
	  protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<SongNews> getSongNews() {
		String hql = "SELECT s.song_id, s.song_url, s.song_name, s.song_singer, s.song_timelen, s.song_size, s.song_listen FROM Song s ";
		
		List<SongNews> list = sessionFactory.getCurrentSession()
                .createQuery(hql)
                .list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CdList> getCdList() {
		String hql = "SELECT c.cd_id,c.cd_name,c.cd_listen,i.img_value FROM Cd c,Image i ";
		
		List<CdList> list = sessionFactory.getCurrentSession()
                .createQuery(hql)
                .list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SongNews> getSongShow(String cdId) {
		String hql = "SELECT s.song_id, s.song_url, s.song_name, s.song_singer, s.song_timelen, s.song_size, s.song_listen FROM Song s,Collect c WHERE s.song_id = c.song_id AND cd_id =  '"+cdId+"'";
		
		List<SongNews> list = sessionFactory.getCurrentSession()
                .createQuery(hql)
                .list();
		return list;
	}

}
