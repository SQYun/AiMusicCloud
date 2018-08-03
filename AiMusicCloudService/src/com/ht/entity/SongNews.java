package com.ht.entity;

import java.math.BigDecimal;


public class SongNews {
	
	private String song_id;
	
	private String song_url;
	
	private String song_name;
	
	private String song_singer;
	
	private int song_timelen;
	
	private BigDecimal song_size;
	
	private String song_listen;
	
	private String img_value;
	
	private String song_lyric;

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public String getSong_url() {
		return song_url;
	}

	public void setSong_url(String song_url) {
		this.song_url = song_url;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public String getSong_singer() {
		return song_singer;
	}

	public void setSong_singer(String song_singer) {
		this.song_singer = song_singer;
	}

	public int getSong_timelen() {
		return song_timelen;
	}

	public void setSong_timelen(int song_timelen) {
		this.song_timelen = song_timelen;
	}

	public BigDecimal getSong_size() {
		return song_size;
	}

	public void setSong_size(BigDecimal song_size) {
		this.song_size = song_size;
	}

	public String getSong_listen() {
		return song_listen;
	}

	public void setSong_listen(String song_listen) {
		this.song_listen = song_listen;
	}

	public String getImg_value() {
		return img_value;
	}

	public void setImg_value(String img_value) {
		this.img_value = img_value;
	}

	public String getSong_lyric() {
		return song_lyric;
	}

	public void setSong_lyric(String song_lyric) {
		this.song_lyric = song_lyric;
	}

	@Override
	public String toString() {
		return "SongNews [song_id=" + song_id + ", song_url=" + song_url + ", song_name=" + song_name + ", song_singer="
				+ song_singer + ", song_timelen=" + song_timelen + ", song_size=" + song_size + ", song_listen="
				+ song_listen + ", img_value=" + img_value + ", song_lyric=" + song_lyric + "]";
	}


}
