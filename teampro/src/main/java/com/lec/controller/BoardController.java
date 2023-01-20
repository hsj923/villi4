package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.PageInfo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
		
	@Value("#boardsql['selectById']") private String selectById;	
	@Value("#boardsql['selectBoardList']") private String selectBoardList;	
	
	@RequestMapping("getBoardList.do") 
	public String getBoardList(BoardVO boardVO, Model model,
			@RequestParam(defaultValue="1") int p,
			@RequestParam(defaultValue="10") int perPage) {
		PageInfo pageInfo = boardService.getPageInfo(p, perPage);				
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("boardList", boardService.getBoardList(p, perPage));	
		return "board/board_list.jsp";
	}
	
	@RequestMapping("*/insertBoard.do")
	public String insertBoard(BoardVO board) throws IOException {
		MultipartFile uploadFile = board.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("d:/lec03/99.temp/upload/" + fileName));
			board.setFileName(fileName);
		}	
		boardService.insertBoard(board);
		return "redirect:/getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO board, Model model) {	
		model.addAttribute("board", boardService.getBoard(board)); // Model 정보 저장
		return "board/board_detail.jsp"; // View 이름 리턴
	}	
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO board) {
		boardService.deleteBoard(board);
		return "getBoardList.do";	
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO board) { 
		boardService.updateBoard(board);
		return "getBoardList.do";
	}
	
	@RequestMapping("/download.do")
	public String download(HttpServletRequest req, HttpServletResponse res) throws Exception { 	
		req.setCharacterEncoding("utf-8");
		String fileName = req.getParameter("fn");
		
		String fromPath = "d:/lec03/99.temp/upload/" + fileName;
		String toPath = "d:/lec03/99.temp/download/" + fileName;
	
		byte[] b = new byte[4096];
		File f = new File(toPath);
		FileInputStream fis = new FileInputStream(fromPath);
		
		String sMimeType = req.getSession().getServletContext().getMimeType(fromPath); // mimetype = file type : pdf, exe, txt.... 
		if(sMimeType == null) sMimeType = "application/octet-stream";
		
		String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1");
		String sEncoding1 = URLEncoder.encode(fileName, "utf-8");
		
		res.setContentType(sMimeType);
		res.setHeader("Content-Transfer-Encoding", "binary");
		res.setHeader("Content-Disposition", "attachment; filename = " + sEncoding1);
			
		int numRead;
		ServletOutputStream os = res.getOutputStream();
	
		while((numRead=fis.read(b, 0, b.length)) != -1 ) {
			os.write(b, 0, numRead);
		}
		
		os.flush();
		os.close();
		fis.close();
		
		return "getBoardList.do";
	}			
}

