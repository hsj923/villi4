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
	private int itemcnt1;
	private int itemcnt2;
	private int itemcnt3;
	private int itemcnt4;
	
	

	@Override
	public String toString() {
		return "VoteVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + ", itemlist1=" + itemlist1 + ", itemlist2=" + itemlist2 + ", itemlist3="
				+ itemlist3 + ", itemlist4=" + itemlist4 + ", itemcnt1=" + itemcnt1 + ", itemcnt2=" + itemcnt2
				+ ", itemcnt3=" + itemcnt3 + ", itemcnt4=" + itemcnt4 + "]";
	}
	public int getItemcnt1() {
		return itemcnt1;
	}
	public void setItemcnt1(int itemcnt1) {
		this.itemcnt1 = itemcnt1;
	}
	public int getItemcnt2() {
		return itemcnt2;
	}
	public void setItemcnt2(int itemcnt2) {
		this.itemcnt2 = itemcnt2;
	}
	public int getItemcnt3() {
		return itemcnt3;
	}
	public void setItemcnt3(int itemcnt3) {
		this.itemcnt3 = itemcnt3;
	}
	public int getItemcnt4() {
		return itemcnt4;
	}
	public void setItemcnt4(int itemcnt4) {
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