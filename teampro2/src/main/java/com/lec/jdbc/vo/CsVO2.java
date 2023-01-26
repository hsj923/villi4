package com.lec.jdbc.vo;

import java.util.Date;

public class CsVO2 {

	private int cs_num; 		
	private String cs_name; 		
	private String cs_pass;		
	private String cs_subject;		
	private String cs_content;		
	private String cs_file; 		
	private int cs_re_ref; 		
	private int cs_re_lev; 		
	private int cs_re_seq; 		
	private int cs_readcount;		
	private Date cs_date;
	
	public int getCs_num() {
		return cs_num;
	}
	public void setCs_num(int cs_num) {
		this.cs_num = cs_num;
	}
	public String getCs_name() {
		return cs_name;
	}
	public void setCs_name(String cs_name) {
		this.cs_name = cs_name;
	}
	public String getCs_pass() {
		return cs_pass;
	}
	public void setCs_pass(String cs_pass) {
		this.cs_pass = cs_pass;
	}
	public String getCs_subject() {
		return cs_subject;
	}
	public void setCs_subject(String cs_subject) {
		this.cs_subject = cs_subject;
	}
	public String getCs_content() {
		return cs_content;
	}
	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}
	public String getCs_file() {
		return cs_file;
	}
	public void setCs_file(String cs_file) {
		this.cs_file = cs_file;
	}
	public int getCs_re_ref() {
		return cs_re_ref;
	}
	public void setCs_re_ref(int cs_re_ref) {
		this.cs_re_ref = cs_re_ref;
	}
	public int getCs_re_lev() {
		return cs_re_lev;
	}
	public void setCs_re_lev(int cs_re_lev) {
		this.cs_re_lev = cs_re_lev;
	}
	public int getCs_re_seq() {
		return cs_re_seq;
	}
	public void setCs_re_seq(int cs_re_seq) {
		this.cs_re_seq = cs_re_seq;
	}
	public int getCs_readcount() {
		return cs_readcount;
	}
	public void setCs_readcount(int cs_readcount) {
		this.cs_readcount = cs_readcount;
	}
	public Date getCs_date() {
		return cs_date;
	}
	public void setCs_date(Date cs_date) {
		this.cs_date = cs_date;
	}
	
	@Override
	public String toString() {
		return "CsVO2 [cs_num=" + cs_num + ", cs_name=" + cs_name + ", cs_pass=" + cs_pass + ", cs_subject="
				+ cs_subject + ", cs_content=" + cs_content + ", cs_file=" + cs_file + ", cs_re_ref=" + cs_re_ref
				+ ", cs_re_lev=" + cs_re_lev + ", cs_re_seq=" + cs_re_seq + ", cs_readcount=" + cs_readcount
				+ ", cs_date=" + cs_date + "]";
	}

}
