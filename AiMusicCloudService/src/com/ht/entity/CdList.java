package com.ht.entity;

public class CdList {
	
	private String cd_id;
	
	private String cd_name;
	
	private int cd_listen;
	
	private String img_value;

	public String getCd_id() {
		return cd_id;
	}

	public void setCd_id(String cd_id) {
		this.cd_id = cd_id;
	}

	public String getCd_name() {
		return cd_name;
	}

	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}

	public int getCd_listen() {
		return cd_listen;
	}

	public void setCd_listen(int cd_listen) {
		this.cd_listen = cd_listen;
	}

	public String getImg_value() {
		return img_value;
	}

	public void setImg_value(String img_value) {
		this.img_value = img_value;
	}

	@Override
	public String toString() {
		return "CdList [cd_id=" + cd_id + ", cd_name=" + cd_name + ", cd_listen=" + cd_listen + ", img_value="
				+ img_value + "]";
	}
	
	

}
