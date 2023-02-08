package com.lec.jdbc.vo;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class MeetingVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt; 
	private int per; 
	private String meet_date; 
	private String place; 
	private String status; 



	@Override
	public String toString() {
		return "MeetingVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + ", per=" + per + ", meet_date=" + meet_date + ", place="
				+ place + ", status=" + status + "]";
	}
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}


	public String getMeet_date() {
		return meet_date;
	}
	public void setMeet_date(String meet_date) {
		this.meet_date = meet_date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}