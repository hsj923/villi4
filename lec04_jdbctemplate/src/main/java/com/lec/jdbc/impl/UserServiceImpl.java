package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.PWDAO;
import com.lec.jdbc.dao.UserDAO;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserVO getUser(String email) {
		return userDAO.getUser(email);
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
	public int updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> getUserList(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRowCount(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return 0;
	}
// --------------------------------------------------------------------------
	
	@Autowired
	private PWDAO pwDAO;

	public UserVO getUser1(UserVO vo) {
		return pwDAO.getUser1(vo);
	}



	
}
