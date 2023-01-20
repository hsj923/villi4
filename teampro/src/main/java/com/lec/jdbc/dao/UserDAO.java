package com.lec.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.commom.SearchVO;
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
	private String get_user = "select * from users where id = ? ";
	private String get_user_list = "select * from users order by name limit ?, ?"; 	
	private String insert_user = "insert into users(id, password, name, role) values(?,?,?,?)";
	private String delete_user = "delete from users where id = ?";
	private String update_user = "update users set name=?, password=?, role=? where id=?";
	      
	public UserVO getUser(String id) { 
		Object[] args = { id };
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
		user.setRole((user.getRole() != null) ? "ADMIN" : "USER");	
		jdbcTemplate.update(insert_user, user.getId(), user.getPassword(), user.getName(), user.getRole());
		//getPageInfo("users", currentPage, perPage, "f=", "q=");
		return user;
	}

	public int deleteUser(UserVO user) {
		return jdbcTemplate.update(delete_user, user.getId());
	}

	public int updateUser(UserVO user) {
		user.setRole((user.getRole() != null) ? "ADMIN" : "USER");
		return jdbcTemplate.update(update_user, user.getName(), user.getPassword(), user.getRole(), user.getId());
	}
	
	public List<UserVO> getUserList(SearchVO searchVO) {
		sql = "select * from users where 1 = 1 "
		    + " and "      + searchVO.getSearchCategory() 
		    + " like '%"   + searchVO.getSearchWord() + "'%"
		    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
		    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		sql = "select count(*) from users where 1 = 1 "
			    + " and "      + searchVO.getSearchCategory() 
			    + " like '%"   + searchVO.getSearchWord() + "'%"
			    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
			    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.queryForInt(sql);
	}

}