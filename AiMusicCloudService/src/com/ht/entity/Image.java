package com.ht.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="image")
public class Image {
	
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name = "system-uuid",strategy="uuid")
	 @Column(length=32)
	 private String img_id;

	 @Column(length=32)
	 private String img_object_id;

	 @Column(length=2)
	 private char img_type;
	 
	 @Column(length=50)
	 private String img_use;
	 
	 @Column(length=200)
	 private String img_value;
	 
	 @Column(length=50)
	 private String img_adduser;
	 
	 private Date img_addtime;
	 
	//这里设置JoinColum设置了外键的名字，并且orderItem是关系维护端  
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)   
	@JoinColumn(name="user_id")
	private Admin admin;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)   
	@JoinColumn(name="song_id")
	private Song song;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)   
	@JoinColumn(name="cd_id")
	private Cd cd;

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public String getImg_object_id() {
		return img_object_id;
	}

	public void setImg_object_id(String img_object_id) {
		this.img_object_id = img_object_id;
	}

	public char getImg_type() {
		return img_type;
	}

	public void setImg_type(char img_type) {
		this.img_type = img_type;
	}

	public String getImg_use() {
		return img_use;
	}

	public void setImg_use(String img_use) {
		this.img_use = img_use;
	}

	public String getImg_value() {
		return img_value;
	}

	public void setImg_value(String img_value) {
		this.img_value = img_value;
	}

	public String getImg_adduser() {
		return img_adduser;
	}

	public void setImg_adduser(String img_adduser) {
		this.img_adduser = img_adduser;
	}

	public Date getImg_addtime() {
		return img_addtime;
	}

	public void setImg_addtime(Date img_addtime) {
		this.img_addtime = img_addtime;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Cd getCd() {
		return cd;
	}

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@Override
	public String toString() {
		return "Image [img_id=" + img_id + ", img_object_id=" + img_object_id + ", img_type=" + img_type + ", img_use="
				+ img_use + ", img_value=" + img_value + ", img_adduser=" + img_adduser + ", img_addtime=" + img_addtime
				+ ", admin=" + admin + ", song=" + song + ", cd=" + cd + "]";
	}






}
