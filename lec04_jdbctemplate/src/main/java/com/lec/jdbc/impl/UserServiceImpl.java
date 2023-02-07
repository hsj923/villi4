package com.lec.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.dao.EmailDAO;
import com.lec.jdbc.dao.PWDAO;
import com.lec.jdbc.dao.UserDAO;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
//	public UserServiceImpl() {
//		System.out.println("Service 객체 생성!!!!");
//	}
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		return userDAO.getTotalRowCount(searchVO);
	}
	
	@Override
	public List<UserVO> getUserList(SearchVO searchVO) {
		return userDAO.getUserList(searchVO);
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
	
	
	// ------------------------ 비밀번호 찾기 --------------------------
	
	@Autowired
	private PWDAO pwDAO;

	public UserVO getUser1(UserVO vo) {
		return pwDAO.getUser1(vo);
	}

	
	// 다른 유저 보기 
	@Override
	public UserVO getUserByNick(UserVO user) {
		return userDAO.getUserByNick(user)
				;
	}

	
	// ---------------- 이메일 중복 체크 ------------------
<<<<<<< HEAD
=======
	
	@Autowired
	private EmailDAO emailDAO;
	
	
	public int emailCheck(String email) {
	      return emailDAO.emailCheck(email);
	   }
	
	
>>>>>>> refs/remotes/origin/master
	
	@Autowired
	private EmailDAO emailDAO;
	
	
	public int emailCheck(String email) {
	      return emailDAO.emailCheck(email);
	   }
	
	
	
}