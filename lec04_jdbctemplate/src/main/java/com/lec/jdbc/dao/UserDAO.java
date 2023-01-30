package com.lec.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.UserRowMapper;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

@Repository("userDAO")
public class UserDAO {

	@Autowired                    
	private JdbcTemplate jdbcTemplate;
	
	private String sql = "";
	private String get_pageinfo = "select count(*) from users";
	private String get_user = "select * from users where email = ? ";
	private String get_user_list = "select * from users order by nickname limit ?, ?"; 	
	private String insert_user = "insert into users(email, password, nickname, name, address) values(?,?,?,?,?)";
	private String delete_user = "delete from users where email = ?";
	private String update_user = "update users set nickname=?, password=?, name=? where email=?";
	      
	
	
	
	public UserVO getUser(String email) { 
		Object[] args = { email };
		return (UserVO) jdbcTemplate.queryForObject(get_user, args, new UserRowMapper());	
	}

	public PageInfo getPageInfo(String tableName, int currentPage, int perPage) {
		
		PageInfo pageInfo = new PageInfo();
		int totalCount = 0;
		int totalPages = 0;
		int startPage = 0;
		int endPage = 0;

		totalCount = jdbcTemplate.queryForInt(get_pageinfo);
		
		if(totalCount>0) {
			totalPages = (int)(totalCount / perPage) + ((totalCount % perPage == 0) ? 0 : 1);
			startPage = (int)(currentPage / perPage) * perPage + 1 + ((currentPage % perPage == 0) ? -perPage : 0);
			endPage = startPage + perPage - 1;
			endPage = (endPage >= totalPages) ? totalPages : endPage;
		}				
		pageInfo.setTotalPages(totalPages);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		return pageInfo;
	}
	
	public List<UserVO> getUserList(int currentPage, int perPage) {		
		Object[] args = {(currentPage-1)*perPage,  perPage };
		return jdbcTemplate.query(get_user_list, args, new UserRowMapper());		
	}
	
	public UserVO insertUser(UserVO user) {
		
		jdbcTemplate.update(insert_user, user.getEmail(), user.getPassword(), user.getNickname(), user.getName(), user.getAddress());
		//getPageInfo("users", currentPage, perPage, "f=", "q=");
		return user;
	}





}