package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.dao.UserDAO;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserVO getUser(String id) {
		return userDAO.getUser(id);
	}

	@Override
	public PageInfo getPageInfo(int currentPage, int perPage) {
		return userDAO.getPageInfo("users", currentPage, perPage);
	}

	@Override
	public List<UserVO> getUserList(int currentPage, int perPage) {
		return userDAO.getUserList(currentPage, perPage);
	}

	@Override
	public UserVO insertUser(UserVO user) {
		return userDAO.insertUser(user);
	}

	@Override
	public int deleteUser(UserVO user) {
		return userDAO.deleteUser(user);
	}
	
	@Override
	public int updateUser(UserVO user) {
		return userDAO.updateUser(user);
	}

/* ------------------------------------------------------------------------------*/	
	@Override
	public List<UserVO> getUserList(SearchVO searchVO) {
		return userDAO.getUserList(searchVO);
	}	
	
	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		return userDAO.getTotalRowCount(searchVO);
	}

}
