package com.ht.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name = "system-uuid",strategy="uuid")
    @Column(length=32)
    private String song_id;

  //这里配置关系，并且确定关系维护端和被维护端。mappBy表示关系被维护端，只有关系端有权去更新外键。这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载   
  	 @OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE },mappedBy ="song")
  	 @JsonIgnore
  	 private Set<Image> items = new HashSet<Image>();
  	 
  /*	//这里设置JoinColum设置了外键的名字，并且orderItem是关系维护端  
  	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH }, optional = true)   
  	@JoinColumn(name="video_id")
  	private Video video;*/
    
    @Column(length=50)
    private String song_name;
    
    @Column(length=50)
    private String song_singer;
    
    @Column(length=100)
    private String song_type;
    
  	@Column(length=500)
  	private String song_lyric;
  	
    @Column(length=100)
    private String song_release_time;
    
   	private int song_timelen;
   	
    @Column(length=32)
    private BigDecimal song_size;
    
    @Column(length=200)
    private String song_info;
    
    private int song_listen;
    
    @Column(length=200)
    private String song_url;
    
    @Column(length=50)
    private String song_adduser;
    
    @Column(length=100)
    private Date song_addtime;

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public Set<Image> getItems() {
		return items;
	}

	public void setItems(Set<Image> items) {
		this.items = items;
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

	public String getSong_type() {
		return song_type;
	}

	public void setSong_type(String song_type) {
		this.song_type = song_type;
	}

	public String getSong_lyric() {
		return song_lyric;
	}

	public void setSong_lyric(String song_lyric) {
		this.song_lyric = song_lyric;
	}

	public String getSong_release_time() {
		return song_release_time;
	}

	public void setSong_release_time(String song_release_time) {
		this.song_release_time = song_release_time;
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

	public String getSong_info() {
		return song_info;
	}

	public void setSong_info(String song_info) {
		this.song_info = song_info;
	}

	public int getSong_listen() {
		return song_listen;
	}

	public void setSong_listen(int song_listen) {
		this.song_listen = song_listen;
	}

	public String getSong_url() {
		return song_url;
	}

	public void setSong_url(String song_url) {
		this.song_url = song_url;
	}

	public String getSong_adduser() {
		return song_adduser;
	}

	public void setSong_adduser(String song_adduser) {
		this.song_adduser = song_adduser;
	}

	public Date getSong_addtime() {
		return song_addtime;
	}

	public void setSong_addtime(Date song_addtime) {
		this.song_addtime = song_addtime;
	}

	@Override
	public String toString() {
		return "Song [song_id=" + song_id + ", items=" + items + ", song_name=" + song_name + ", song_singer="
				+ song_singer + ", song_type=" + song_type + ", song_lyric=" + song_lyric + ", song_release_time="
				+ song_release_time + ", song_timelen=" + song_timelen + ", song_size=" + song_size + ", song_info="
				+ song_info + ", song_listen=" + song_listen + ", song_url=" + song_url + ", song_adduser="
				+ song_adduser + ", song_addtime=" + song_addtime + "]";
	}



    
	
	 }
