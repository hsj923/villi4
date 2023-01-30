package com.lec.jdbc.vo;

import java.beans.Transient;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {

	private String email;
	private String password;
	private String nickname;
	private String name;
	private String address;
	private String role;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	@Override
	public String toString() {
		return "UserVO [email=" + email + ", password=" + password + ", nickname=" + nickname + ", name=" + name + ", address=" + address +", role=" + role + "]";
	}
	
	
	
	
	
	
}
