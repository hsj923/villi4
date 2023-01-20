package com.lec.jdbc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.mapper.BoardRowMapper;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.BoardVO;

@Repository
@PropertySource("classpath:config/boardsql.properties")
public class BoardDAO {
	
	@Autowired                    
	private JdbcTemplate jdbcTemplate;

	@Autowired
	Environment environment;
	
	private String sql = "";
	private String get_pageinfo     = ""; //"select count(*) from board";
	private String insert_board     = ""; //"insert into board(title, writer, content, filename, regdate, listimg) values(?, ?, ?, ?, now(),?)";
	private String update_board     = ""; //"update board set title=?, content=? where seq=?";
	private String delete_board     = ""; //"delete from board where seq=?";
	private String get_board        = ""; //"select * from board where seq=?";
	private String get_board_list   = ""; //"select * from board order by seq desc";
	private String get_board_list_t = ""; //"select * from board where title like '%'||?||'%' order by seq desc";
	private String get_board_list_c = ""; //"select * from board where content like '%'||?||'%' order by seq desc";

	@PostConstruct
	public void getSqlPropeties() {
		get_pageinfo     = environment.getProperty("get_pageinfo");
		insert_board     = environment.getProperty("insert_board");
		update_board 	 = environment.getProperty("update_board");
		delete_board 	 = environment.getProperty("delete_board");
		get_board 		 = environment.getProperty("get_board");
		get_board_list   = environment.getProperty("get_board_list");
		get_board_list_t = environment.getProperty("get_board_list_t");
		get_board_list_c = environment.getProperty("get_board_list");
	}
	
	public List<BoardVO> getBoardList(int currentPage, int perPage) {		
		Object[] args = {(currentPage-1)*perPage,  perPage };
		return jdbcTemplate.query(get_board_list, args, new BoardRowMapper());		
	}
		
	public BoardVO getBoard(BoardVO board) {
		Object[] args = { board.getSeq() };
		return jdbcTemplate.queryForObject(get_board, args, new BoardRowMapper());	
	}

	public int insertBoard(BoardVO board) {
		return jdbcTemplate.update(insert_board, board.getTitle(), board.getWriter(), board.getContent(), board.getFileName());
	}

	public int deleteBoard(BoardVO board) {
		return jdbcTemplate.update(delete_board, board.getSeq());
	}

	public int updateBoard(BoardVO board) {
		return jdbcTemplate.update(update_board, board.getTitle(), board.getContent(), board.getSeq());
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
		
/* --------------------------------------------------------------------------------------------------- */
	
	public List<BoardVO> getBoardList(SearchVO searchVO) {
		sql = "select * from board where 1 = 1 "
		    + " and "      + searchVO.getSearchCategory() 
		    + " like '%"   + searchVO.getSearchWord() + "'%"
		    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
		    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		sql = "select count(*) from board where 1 = 1 "
			    + " and "      + searchVO.getSearchCategory() 
			    + " like '%"   + searchVO.getSearchWord() + "'%"
			    + " limit    " + searchVO.getCurPage() + ", " + searchVO.getRowSizePerPage()
			    + " order by " + searchVO.getSearchCategory() + "desc";
		return jdbcTemplate.queryForInt(sql);
	}
}
