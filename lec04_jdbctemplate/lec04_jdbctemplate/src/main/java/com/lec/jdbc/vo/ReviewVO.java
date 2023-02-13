package com.lec.jdbc.vo;



public class ReviewVO {

	private int seq;
	private String nickname;
	private String rv_con;
	private String rv_time;
	
	
	@Override
	public String toString() {
		return "ReviewVO [seq=" + seq + ", nickname=" + nickname + ", rv_con=" + rv_con + ", rv_time=" + rv_time + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRv_con() {
		return rv_con;
	}
	public void setRv_con(String rv_con) {
		this.rv_con = rv_con;
	}
	public String getRv_time() {
		return rv_time;
	}
	public void setRv_time(String rv_time) {
		this.rv_time = rv_time;
	}
	
	

	
}