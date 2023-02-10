package com.lec.jdbc.vo;

import java.util.Date;

public class CsReplyVO {
	
	private int rno;
	private int bno;
	private String writer;
	private String content;
	private Date regDate;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	
	@Override
	public String toString() {
		return "CsReplyVO [rno=" + rno + ", bno=" + bno + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + "]";
	}

	
}