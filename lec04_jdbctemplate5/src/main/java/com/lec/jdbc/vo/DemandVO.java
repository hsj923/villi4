package com.lec.jdbc.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class DemandVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private String price;
	private String status;
	private Date regDate;
	private int cnt;
	private String fileName1; 
	private MultipartFile uploadFile1;

	




	@Override
	public String toString() {
		return "DemandVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", price="
				+ price + ", status=" + status + ", regDate=" + regDate + ", cnt=" + cnt + ", fileName1=" + fileName1
				+ ", uploadFile1=" + uploadFile1 + "]";
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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

	
}