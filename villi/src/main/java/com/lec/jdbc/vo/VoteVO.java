package com.lec.jdbc.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class VoteVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String itemlist1;
	private String itemlist2;
	private String itemlist3;
	private String itemlist4;
	private String itemcnt1;
	private String itemcnt2;
	private String itemcnt3;
	private String itemcnt4;
	private String fileName1; 
	private String fileName2; 
	private String fileName3; 
	private String fileName4; 
	private MultipartFile uploadFile1;
	private MultipartFile uploadFile2;
	private MultipartFile uploadFile3;
	private MultipartFile uploadFile4;
	
	@Override
	public String toString() {
		return "VoteVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + ", itemlist1=" + itemlist1 + ", itemlist2=" + itemlist2 + ", itemlist3="
				+ itemlist3 + ", itemlist4=" + itemlist4 + ", itemcnt1=" + itemcnt1 + ", itemcnt2=" + itemcnt2
				+ ", itemcnt3=" + itemcnt3 + ", itemcnt4=" + itemcnt4 + ", fileName1=" + fileName1 + ", fileName2="
				+ fileName2 + ", fileName3=" + fileName3 + ", fileName4=" + fileName4 + ", uploadFile1=" + uploadFile1
				+ ", uploadFile2=" + uploadFile2 + ", uploadFile3=" + uploadFile3 + ", uploadFile4=" + uploadFile4
				+ "]";
	}
	
	public String getItemcnt1() {
		return itemcnt1;
	}

	public void setItemcnt1(String itemcnt1) {
		this.itemcnt1 = itemcnt1;
	}

	public String getItemcnt2() {
		return itemcnt2;
	}

	public void setItemcnt2(String itemcnt2) {
		this.itemcnt2 = itemcnt2;
	}

	public String getItemcnt3() {
		return itemcnt3;
	}

	public void setItemcnt3(String itemcnt3) {
		this.itemcnt3 = itemcnt3;
	}

	public String getItemcnt4() {
		return itemcnt4;
	}

	public void setItemcnt4(String itemcnt4) {
		this.itemcnt4 = itemcnt4;
	}

	public String getItemlist1() {
		return itemlist1;
	}
	public void setItemlist1(String itemlist1) {
		this.itemlist1 = itemlist1;
	}
	public String getItemlist2() {
		return itemlist2;
	}
	public void setItemlist2(String itemlist2) {
		this.itemlist2 = itemlist2;
	}
	public String getItemlist3() {
		return itemlist3;
	}
	public void setItemlist3(String itemlist3) {
		this.itemlist3 = itemlist3;
	}
	public String getItemlist4() {
		return itemlist4;
	}
	public void setItemlist4(String itemlist4) {
		this.itemlist4 = itemlist4;
	}

	public String getFileName4() {
		return fileName4;
	}
	public void setFileName4(String fileName4) {
		this.fileName4 = fileName4;
	}
	public MultipartFile getUploadFile4() {
		return uploadFile4;
	}
	public void setUploadFile4(MultipartFile uploadFile4) {
		this.uploadFile4 = uploadFile4;
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

	
}
