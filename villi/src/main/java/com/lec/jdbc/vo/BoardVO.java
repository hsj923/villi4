package com.lec.jdbc.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private String status;
	private Date regDate;
	private int cnt;
	private String fileName1; 
	private String fileName2; 
	private String fileName3; 
	private String fileName4; 
	private String fileName5; 
	private MultipartFile uploadFile1;
	private MultipartFile uploadFile2;
	private MultipartFile uploadFile3;
	private MultipartFile uploadFile4;
	private MultipartFile uploadFile5;
	private String cate;
	private String cate2;
	private String price;
	

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", status="
				+ status + ", regDate=" + regDate + ", cnt=" + cnt + ", fileName1=" + fileName1 + ", fileName2="
				+ fileName2 + ", fileName3=" + fileName3 + ", fileName4=" + fileName4 + ", fileName5=" + fileName5
				+ ", uploadFile1=" + uploadFile1 + ", uploadFile2=" + uploadFile2 + ", uploadFile3=" + uploadFile3
				+ ", uploadFile4=" + uploadFile4 + ", uploadFile5=" + uploadFile5 + ", cate=" + cate + ", cate2="
				+ cate2 + ", price=" + price + "]";
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
	public String getCate2() {
		return cate2;
	}
	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
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
	public String getFileName2() {
		return fileName2;
	}
	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}
	public String getFileName3() {
		return fileName3;
	}
	public void setFileName3(String fileName3) {
		this.fileName3 = fileName3;
	}
	public String getFileName4() {
		return fileName4;
	}
	public void setFileName4(String fileName4) {
		this.fileName4 = fileName4;
	}
	public String getFileName5() {
		return fileName5;
	}
	public void setFileName5(String fileName5) {
		this.fileName5 = fileName5;
	}
	public MultipartFile getUploadFile1() {
		return uploadFile1;
	}
	public void setUploadFile1(MultipartFile uploadFile1) {
		this.uploadFile1 = uploadFile1;
	}
	public MultipartFile getUploadFile2() {
		return uploadFile2;
	}
	public void setUploadFile2(MultipartFile uploadFile2) {
		this.uploadFile2 = uploadFile2;
	}
	public MultipartFile getUploadFile3() {
		return uploadFile3;
	}
	public void setUploadFile3(MultipartFile uploadFile3) {
		this.uploadFile3 = uploadFile3;
	}
	public MultipartFile getUploadFile4() {
		return uploadFile4;
	}
	public void setUploadFile4(MultipartFile uploadFile4) {
		this.uploadFile4 = uploadFile4;
	}
	public MultipartFile getUploadFile5() {
		return uploadFile5;
	}
	public void setUploadFile5(MultipartFile uploadFile5) {
		this.uploadFile5 = uploadFile5;
	}

	
}
