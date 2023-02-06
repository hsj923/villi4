package com.lec.jdbc.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class GroupBuyingVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private String status;
	private String price;
	private String buying_date;
	private Date regDate;
	private int cnt;
	private int per;
	private String fileName1;  
	private MultipartFile uploadFile1;


	@Override
	public String toString() {
		return "GroupBuyingVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", status=" + status + ", price=" + price + ", buying_date=" + buying_date + ", regDate=" + regDate
				+ ", cnt=" + cnt + ", per=" + per + ", fileName1=" + fileName1 + ", uploadFile1=" + uploadFile1 + "]";
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getFileName1() {
		return fileName1;
	}
	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public MultipartFile getUploadFile1() {
		return uploadFile1;
	}
	public void setUploadFile1(MultipartFile uploadFile1) {
		this.uploadFile1 = uploadFile1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getBuying_date() {
		return buying_date;
	}
	public void setBuying_date(String buying_date) {
		this.buying_date = buying_date;
	}
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}


	
}
