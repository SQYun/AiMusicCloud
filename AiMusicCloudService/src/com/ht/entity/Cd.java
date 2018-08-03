package com.ht.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cd")
public class Cd {
	
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name = "system-uuid",strategy="uuid")
	 @Column(length=32)
	 private String cd_id;
	 
	 //这里设置JoinColum设置了外键的名字，并且orderItem是关系维护端  
	 @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)   
	 @JoinColumn(name="user_id")
	 private Admin admin;
	 
	 @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE },mappedBy ="cd")
	 private Set<Image> items1 = new HashSet<Image>();   
	 
	 @Column(length=50)
	 private String cd_name;
	 
	 private char cd_type;
	 
	 @Column(length=50)
	 private String cd_label;
	 
	 @Column(length=50)
	 private String cd_issued_time;
	 
	 private int cd_listen;
	 
	 @Column(length=50)
	 private String cd_adduser;
	 
	 private Date cd_addtime;

	public String getCd_id() {
		return cd_id;
	}

	public void setCd_id(String cd_id) {
		this.cd_id = cd_id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getCd_name() {
		return cd_name;
	}

	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}

	public char getCd_type() {
		return cd_type;
	}

	public void setCd_type(char cd_type) {
		this.cd_type = cd_type;
	}

	public String getCd_label() {
		return cd_label;
	}

	public void setCd_label(String cd_label) {
		this.cd_label = cd_label;
	}

	public String getCd_issued_time() {
		return cd_issued_time;
	}

	public void setCd_issued_time(String cd_issued_time) {
		this.cd_issued_time = cd_issued_time;
	}

	public int getCd_listen() {
		return cd_listen;
	}

	public void setCd_listen(int cd_listen) {
		this.cd_listen = cd_listen;
	}

	public String getCd_adduser() {
		return cd_adduser;
	}

	public void setCd_adduser(String cd_adduser) {
		this.cd_adduser = cd_adduser;
	}

	public Date getCd_addtime() {
		return cd_addtime;
	}

	public void setCd_addtime(Date cd_addtime) {
		this.cd_addtime = cd_addtime;
	}

	@Override
	public String toString() {
		return "Cd [cd_id=" + cd_id + ", admin=" + admin + ", cd_name=" + cd_name + ", cd_type=" + cd_type
				+ ", cd_label=" + cd_label + ", cd_issued_time=" + cd_issued_time + ", cd_listen=" + cd_listen
				+ ", cd_adduser=" + cd_adduser + ", cd_addtime=" + cd_addtime + "]";
	}


	

}

