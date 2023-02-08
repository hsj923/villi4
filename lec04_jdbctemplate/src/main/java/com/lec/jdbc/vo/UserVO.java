package com.lec.jdbc.vo;


import org.springframework.web.multipart.MultipartFile;

public class UserVO {

	private String email;
	private String password;
	private String name;
	private String nickname;
	private String address;
	private String role;
	private String fileName1;
	private MultipartFile uploadFile1;

	
	

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




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
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




	@Override
	public String toString() {
		return "UserVO [email=" + email + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", address=" + address + ", role=" + role + ", fileName1=" + fileName1 + ", uploadFile1="
				+ uploadFile1 + "]";
	}
	
	
	
	

}