package com.lec.jdbc.vo;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class ReportVO {

	private int seq;
	private String status; 
	private Date r_etime; 
	private Date r_time; 
	private String r_rs1; 
	private String r_con; 
	private String name;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getR_etime() {
		return r_etime;
	}
	public void setR_etime(Date r_etime) {
		this.r_etime = r_etime;
	}
	public Date getR_time() {
		return r_time;
	}
	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}
	public String getR_rs1() {
		return r_rs1;
	}
	public void setR_rs1(String r_rs1) {
		this.r_rs1 = r_rs1;
	}
	public String getR_con() {
		return r_con;
	}
	public void setR_con(String r_con) {
		this.r_con = r_con;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ReportVO [seq=" + seq + ", status=" + status + ", r_etime=" + r_etime + ", r_time=" + r_time
				+ ", r_rs1=" + r_rs1 + ", r_con=" + r_con + ", name=" + name + "]";
	} 



}
