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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="u_user")
public class Admin {
	
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name = "system-uuid",strategy="uuid")
	 @Column(length=32)
	 private String user_id;
	 
	 @Column(length=50)
	 private String user_name;
	 
	 @Column(length=32)
	 private String user_pwd;
	 
	 @Column(length=50)
	 private String user_real_name;
	 
	 @Column(length=2)
	 private char user_sex;
	 
	 @Column(length=10)
	 private String user_birthday;
	 
	 @Column(length=11)
	 private String user_mobile;
	 
	 @Column(length=3)
	 private char user_level;
	 
	 @Column(length=200)
	 private String user_info;

	 private Date user_addtime;

	 //这里配置关系，并且确定关系维护端和被维护端。mappBy表示关系被维护端，只有关系端有权去更新外键。这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载   
	 @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE },mappedBy ="admin")
	 private Set<Cd> items = new HashSet<Cd>();   
	 
	 @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE },mappedBy ="admin")
	 private Set<Image> items1 = new HashSet<Image>();   
	 

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_real_name() {
		return user_real_name;
	}

	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}

	public char getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(char user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public char getUser_level() {
		return user_level;
	}

	public void setUser_level(char user_level) {
		this.user_level = user_level;
	}

	public String getUser_info() {
		return user_info;
	}

	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}

	public Set<Cd> getItems() {
		return items;
	}

	public void setItems(Set<Cd> items) {
		this.items = items;
	}

	public Set<Image> getItems1() {
		return items1;
	}

	public void setItems1(Set<Image> items1) {
		this.items1 = items1;
	}

	public Date getUser_addtime() {
		return user_addtime;
	}

	public void setUser_addtime(Date user_addtime) {
		this.user_addtime = user_addtime;
	}

	@Override
	public String toString() {
		return "Admin [user_id=" + user_id + ", user_name=" + user_name + ", user_pwd=" + user_pwd + ", user_real_name="
				+ user_real_name + ", user_sex=" + user_sex + ", user_birthday=" + user_birthday + ", user_mobile="
				+ user_mobile + ", user_level=" + user_level + ", user_info=" + user_info + ", items=" + items
				+ ", items1=" + items1 + ", user_addtime=" + user_addtime + "]";
	}

	

}
