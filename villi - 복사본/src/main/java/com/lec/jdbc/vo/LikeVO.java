package com.lec.jdbc.vo;

public class LikeVO {

	private long h_number;
	// 게시글 번호
	private long e_number;
	// 회원 번호
	private long m_number;
	// 좋아요
	private int heart;
	@Override
	public String toString() {
		return "LikeVO [h_number=" + h_number + ", e_number=" + e_number + ", m_number=" + m_number + ", heart=" + heart
				+ "]";
	}
	public long getH_number() {
		return h_number;
	}
	public void setH_number(long h_number) {
		this.h_number = h_number;
	}
	public long getE_number() {
		return e_number;
	}
	public void setE_number(long e_number) {
		this.e_number = e_number;
	}
	public long getM_number() {
		return m_number;
	}
	public void setM_number(long m_number) {
		this.m_number = m_number;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	
}
