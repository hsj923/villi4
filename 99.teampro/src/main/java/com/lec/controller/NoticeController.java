package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.NoticeService;
import com.lec.jdbc.vo.NoticeVO;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
		
	@Value("#noticesql['selectById']") private String selectById;	
	@Value("#noticesql['selectNoticeList']") private String selectNoticeList;	
	
	@RequestMapping("getNoticeList.do") 
	public String getNoticeList(NoticeVO noticeVO, Model model,
			@RequestParam(defaultValue="1") int p,
			@RequestParam(defaultValue="10") int perPage) {
		PageInfo pageInfo = noticeService.getPageInfo(p, perPage);				
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("noticeList", noticeService.getNoticeList(p, perPage));	
		return "notice/notice_list.jsp";
	}
	
//	@RequestMapping("*/insertNotice.do")
//	public String insertNotice(NoticeVO notice) throws IOException {
//		MultipartFile uploadFile = board.getUploadFile();
//		if (!uploadFile.isEmpty()) {
//			String fileName = uploadFile.getOriginalFilename();
//			uploadFile.transferTo(new File("d:/lec03/99.temp/upload/" + fileName));
//			board.setFileName(fileName);
//		}	
//		noticeService.insertNotice(notice);
//		return "redirect:/getBoardList.do";
//	}
	
	
	@RequestMapping("/getNotice.do")
	public String getNotice(NoticeVO notice, Model model) {	
		model.addAttribute("notice", noticeService.getNotice(notice)); // Model
		return "notice/notice_detail.jsp"; // View 
	}	
	
	@RequestMapping("*/insertNotice.do")
	public String insertNotice(NoticeVO notice) {
		noticeService.insertNotice(notice);
		return "redirect:/getNoticeList.do";
	}
	
	
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(NoticeVO notice) {
		noticeService.deleteNotice(notice);
		return "redirect:/getNoticeList.do";	
	}
	
//	@RequestMapping("/updateBoard.do")
//	public String updateBoard(BoardVO board) { 
//		boardService.updateBoard(board);
//		return "getBoardList.do";
//	}
	
//	@RequestMapping("/download.do")
//	public String download(HttpServletRequest req, HttpServletResponse res) throws Exception { 	
//		req.setCharacterEncoding("utf-8");
//		String fileName = req.getParameter("fn");
//		
//		String fromPath = "d:/lec03/99.temp/upload/" + fileName;
//		String toPath = "d:/lec03/99.temp/download/" + fileName;
//	
//		byte[] b = new byte[4096];
//		File f = new File(toPath);
//		FileInputStream fis = new FileInputStream(fromPath);
//		
//		String sMimeType = req.getSession().getServletContext().getMimeType(fromPath); // mimetype = file type : pdf, exe, txt.... 
//		if(sMimeType == null) sMimeType = "application/octet-stream";
//		
//		String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1");
//		String sEncoding1 = URLEncoder.encode(fileName, "utf-8");
//		
//		res.setContentType(sMimeType);
//		res.setHeader("Content-Transfer-Encoding", "binary");
//		res.setHeader("Content-Disposition", "attachment; filename = " + sEncoding1);
//			
//		int numRead;
//		ServletOutputStream os = res.getOutputStream();
//	
//		while((numRead=fis.read(b, 0, b.length)) != -1 ) {
//			os.write(b, 0, numRead);
//		}
//		
//		os.flush();
//		os.close();
//		fis.close();
//		
//		return "getBoardList.do";
//	}			
}

