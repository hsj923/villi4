package com.lec.jdbc.vo;

import java.util.Date;

public class NoticeVO {

	private int noti_seq;
	private String noti_title;
	private String noti_content;
	private Date noti_regDate;
	
	
	public int getNoti_seq() {
		return noti_seq;
	}
	public void setNoti_seq(int noti_seq) {
		this.noti_seq = noti_seq;
	}
	public String getNoti_title() {
		return noti_title;
	}
	public void setNoti_title(String noti_title) {
		this.noti_title = noti_title;
	}
	public String getNoti_content() {
		return noti_content;
	}
	public void setNoti_content(String noti_content) {
		this.noti_content = noti_content;
	}
	public Date getNoti_regDate() {
		return noti_regDate;
	}
	public void setNoti_regDate(Date noti_regDate) {
		this.noti_regDate = noti_regDate;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [noti_seq=" + noti_seq + ", noti_title=" + noti_title + ", noti_content=" + noti_content
				+ ", noti_regDate=" + noti_regDate + "]";
	}
	
	
	

}
