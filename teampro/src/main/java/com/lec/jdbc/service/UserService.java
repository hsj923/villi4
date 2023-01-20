package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

public interface UserService {

	UserVO getUser(String id);
	List<UserVO> getUserList(int currentPage, int perPage);
	PageInfo getPageInfo(int currentPage, int perPage);
	UserVO insertUser(UserVO user);
	int deleteUser(UserVO user);
	int updateUser(UserVO user);
	
	List<UserVO> getUserList(SearchVO searchVO);
	int getTotalRowCount(SearchVO searchVO);
}
