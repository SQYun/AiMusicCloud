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

@Entity
@Table(name="video")
public class Video{
	
	 @Id
	 @GeneratedValue(generator="system-uuid")
	 @GenericGenerator(name = "system-uuid",strategy="uuid")
	 
	 @Column(length=32)
	 private String video_id;
	 
	 @Column(length=50)
	 private String video_title;
	 
	 @Column(length=50)
	 private String video_owner;
	 
	 private int video_timelen;
	 
	 private BigDecimal video_size;
	 
	 @Column(length=50)
	 private String video_type;
	 
	 @Column(length=200)
	 private String video_info;
	 
	 private int video_scan;
	 
	 @Column(length=200)
	 private String video_url;

	 @Column(length=50)
	 private String video_adduser;
	 
	 @Column(length=50)
	 private Date video_addtime;

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_title() {
		return video_title;
	}

	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}

	public String getVideo_owner() {
		return video_owner;
	}

	public void setVideo_owner(String video_owner) {
		this.video_owner = video_owner;
	}

	public int getVideo_timelen() {
		return video_timelen;
	}

	public void setVideo_timelen(int video_timelen) {
		this.video_timelen = video_timelen;
	}

	public BigDecimal getVideo_size() {
		return video_size;
	}

	public void setVideo_size(BigDecimal video_size) {
		this.video_size = video_size;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	public String getVideo_info() {
		return video_info;
	}

	public void setVideo_info(String video_info) {
		this.video_info = video_info;
	}

	public int getVideo_scan() {
		return video_scan;
	}

	public void setVideo_scan(int video_scan) {
		this.video_scan = video_scan;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getVideo_adduser() {
		return video_adduser;
	}

	public void setVideo_adduser(String video_adduser) {
		this.video_adduser = video_adduser;
	}

	public Date getVideo_addtime() {
		return video_addtime;
	}

	public void setVideo_addtime(Date video_addtime) {
		this.video_addtime = video_addtime;
	}

	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", video_title=" + video_title + ", video_owner=" + video_owner
				+ ", video_timelen=" + video_timelen + ", video_size=" + video_size + ", video_type=" + video_type
				+ ", video_info=" + video_info + ", video_scan=" + video_scan + ", video_url=" + video_url
				+ ", video_adduser=" + video_adduser + ", video_addtime=" + video_addtime + "]";
	}
	 
	/*//这里配置关系，并且确定关系维护端和被维护端。mappBy表示关系被维护端，只有关系端有权去更新外键。这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载   
	@OneToMany(cascade = { CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE },mappedBy ="video")
	private Set<Song> items = new HashSet<Song>();*/



	

}
