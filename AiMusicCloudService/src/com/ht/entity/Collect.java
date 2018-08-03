package com.ht.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="collect")
public class Collect {
	
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name = "system-uuid",strategy="uuid")
	 @Column(length=32)
	 private String socl_id;
	 
	 @Column(length=3)
	 private char socl_type;
	 
	 @Column(length=32)
	 private String cd_id;
	 
	 @Column(length=32)
	 private String song_id;
	 
	 @Column(length=50)
	 private String socl_adduser;
	 
	 private Date socl_addtime;

	public String getSocl_id() {
		return socl_id;
	}

	public void setSocl_id(String socl_id) {
		this.socl_id = socl_id;
	}

	public char getSocl_type() {
		return socl_type;
	}

	public void setSocl_type(char socl_type) {
		this.socl_type = socl_type;
	}

	public String getCd_id() {
		return cd_id;
	}

	public void setCd_id(String cd_id) {
		this.cd_id = cd_id;
	}

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public String getSocl_adduser() {
		return socl_adduser;
	}

	public void setSocl_adduser(String socl_adduser) {
		this.socl_adduser = socl_adduser;
	}

	public Date getSocl_addtime() {
		return socl_addtime;
	}

	public void setSocl_addtime(Date socl_addtime) {
		this.socl_addtime = socl_addtime;
	}

	@Override
	public String toString() {
		return "Collect [socl_id=" + socl_id + ", socl_type=" + socl_type + ", cd_id=" + cd_id + ", song_id=" + song_id
				+ ", socl_adduser=" + socl_adduser + ", socl_addtime=" + socl_addtime + "]";
	}
	 
	 
	 
	 
	

}
