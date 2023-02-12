package com.lec.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.mapper.BoardRowMapper;
import com.lec.jdbc.mapper.CsReplyRowMapper;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.CsReplyVO;

@Repository("boardDAO")
@PropertySource("classpath:config/boardsql.properties")
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	Environment environment;
	
	private String sql = "";
	private String selectByBoardSeq = "";
	private String boardTotalRowCount = "";
	private String insertBoard = "";
	private String insertServiceBoard = "";
	private String deleteBoard = "";
	private String updateBoard = "";
	private String updateBoardCount = "";
	private String updateLikeCount = "";
	private String updateUnLikeCount = "";
	private String selectBoardList = "";
	
//	내가쓴글목록
	private String selectMyBoardList ="";
	
	
//	제목,작성자,카테고리로 검색하기
	private String selectBoardListByTitle = ""; 
	private String selectBoardListByNickname = ""; 
	private String selectBoardListByCate2 = "";

	
	@PostConstruct
	public void getSqlPropeties() {
		selectByBoardSeq              = environment.getProperty("selectByBoardSeq");
		boardTotalRowCount       = environment.getProperty("boardTotalRowCount");
		insertBoard              = environment.getProperty("insertBoard");
		insertServiceBoard       = environment.getProperty("insertServiceBoard");
		deleteBoard              = environment.getProperty("deleteBoard");
		updateBoard              = environment.getProperty("updateBoard");
		updateBoardCount              = environment.getProperty("updateBoardCount");
		updateLikeCount              = environment.getProperty("updateLikeCount");
		updateUnLikeCount              = environment.getProperty("updateUnLikeCount");
		selectBoardList          = environment.getProperty("selectBoardList");
		
		
		selectMyBoardList   = environment.getProperty("selectMyBoardList");
		selectBoardListByTitle   = environment.getProperty("selectBoardListByTitle");
		selectBoardListByNickname  = environment.getProperty("selectBoardListByNickname");
		selectBoardListByCate2= environment.getProperty("selectBoardListByCate2");
	}

	public BoardVO getBoard(BoardVO board) {
		Object[] args = { board.getSeq() };		
		return (BoardVO) jdbcTemplate.queryForObject(selectByBoardSeq, args, new BoardRowMapper());
	}
	
	public int getTotalRowCount(SearchVO searchVO) {
		
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = boardTotalRowCount;
			searchVO.setSearchType("title");
		} else {			
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = boardTotalRowCount + " and title like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = boardTotalRowCount + " and nickname like '%" + searchVO.getSearchWord() + "%'";
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = boardTotalRowCount + " and cate2 like '%" + searchVO.getSearchWord() + "%'";
			}	
		}
		return jdbcTemplate.queryForInt(sql);
	}

	public List<BoardVO> getBoardList(SearchVO searchVO) {
				
		if(searchVO.getSearchType()==null || searchVO.getSearchType().isEmpty() ||
				searchVO.getSearchWord()==null || searchVO.getSearchWord().isEmpty()) {
			sql = selectBoardListByTitle;
			searchVO.setSearchType("title");
		} else {
			if(searchVO.getSearchType().equalsIgnoreCase("title")) {
				sql = selectBoardListByTitle;
			} else if(searchVO.getSearchType().equalsIgnoreCase("nickname")) {
				sql = selectBoardListByNickname;
			} else if(searchVO.getSearchType().equalsIgnoreCase("Cate2")) {
				sql = selectBoardListByCate2;
			} 					
		}
		
		String searchWord = "%" + searchVO.getSearchWord() + "%";					
		Object[] args = {searchWord, searchVO.getFirstRow(), searchVO.getRowSizePerPage()};
		return jdbcTemplate.query(sql, args, new BoardRowMapper());
	}
	
	public BoardVO insertBoard(BoardVO board) {
		jdbcTemplate.update(insertBoard, board.getTitle(), board.getNickname(), board.getContent(), board.getCate2(), board.getPrice(), board.getUsedate(), board.getDuedate(), board.getFileName1(), board.getFileName2(), board.getFileName3());
		return board;
	}	
	
	public BoardVO insertServiceBoard(BoardVO board) {
		jdbcTemplate.update(insertServiceBoard, board.getTitle(), board.getNickname(), board.getContent(), board.getCate2(), board.getPrice(), board.getUsedate(), board.getDuedate(), board.getFileName1(), board.getFileName2(), board.getFileName3());
		return board;
	}	
	
	public int deleteBoard(BoardVO board) {
		
		System.out.println(board.toString());
		
		return jdbcTemplate.update(deleteBoard, board.getSeq());
	}

	public int updateBoard(BoardVO board) {
		return jdbcTemplate.update(updateBoard, board.getTitle(), board.getContent(), board.getSeq());
	}

//	조회수DAO
	public void updateBoardCount(BoardVO board) {
		jdbcTemplate.update(updateBoardCount,  board.getSeq());
		
	}
	
//	좋아요, 좋아요 기능 아직 구현 못함 
//	public void updateLikeCount(BoardVO board) {
//		jdbcTemplate.update(updateLikeCount,  board.getSeq());
//	}
//	public void updateUnLikeCount(BoardVO board) {
//		jdbcTemplate.update(updateUnLikeCount,  board.getSeq());
//	}
	
	
	
	//내가 쓴글 목록
	public List<BoardVO> getMyBoardList(String nickname) {
		Object[] args = {nickname};
		return jdbcTemplate.query(selectMyBoardList, args, new BoardRowMapper());
	}
	
	public List<BoardVO> MyBoardList(String nickname) {
		Object[] args = {nickname};
		return jdbcTemplate.query(selectMyBoardList, args, new BoardRowMapper());
	}
	
}