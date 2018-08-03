package com.ht.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="manager")
public class Manager {
	
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name = "system-uuid",strategy="uuid")
	 @Column(length=32)
	 private String manager_id;
	 
	 @Column(length=20)
	 private String manager_name;
	 
	 @Column(length=32)
	 private String manager_pwd;
	 
	 @Column(length=20)
	 private String manager_real_name;
	 
	 @Column(length=20)
	 private String manager_tele;
	 
	 @Column(length=20)
	 private String manager_permission;

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_pwd() {
		return manager_pwd;
	}

	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd;
	}

	public String getManager_real_name() {
		return manager_real_name;
	}

	public void setManager_real_name(String manager_real_name) {
		this.manager_real_name = manager_real_name;
	}

	public String getManager_tele() {
		return manager_tele;
	}

	public void setManager_tele(String manager_tele) {
		this.manager_tele = manager_tele;
	}

	public String getManager_permission() {
		return manager_permission;
	}

	public void setManager_permission(String manager_permission) {
		this.manager_permission = manager_permission;
	}

	@Override
	public String toString() {
		return "Manager [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_pwd=" + manager_pwd
				+ ", manager_real_name=" + manager_real_name + ", manager_tele=" + manager_tele
				+ ", manager_permission=" + manager_permission + "]";
	}
	 
	 
	 
	

}
