<<<<<<< HEAD
package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.UserVO;

public interface UserService {

	UserVO getUser(UserVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<UserVO> getUserList(SearchVO searchVO);
	UserVO insertUser(UserVO user);
	int deleteUser(UserVO user);
	int updateUser(UserVO user);
}
=======
package com.lec.jdbc.service;

import java.util.List;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.vo.UserVO;

public interface UserService {

	UserVO getUser(UserVO vo);
	int getTotalRowCount(SearchVO searchVO);
	List<UserVO> getUserList(SearchVO searchVO);
	UserVO insertUser(UserVO user);
	int deleteUser(UserVO user);
	int updateUser(UserVO user);
}
>>>>>>> d64295aecd8792d0b76d453b25173965f5a1ce4d
