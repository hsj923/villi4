package com.lec.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.ChatService;
import com.lec.jdbc.vo.ChatVO;

@Controller
@PropertySource("classpath:config/uploadpath.properties")
public class ChatController {

	@Autowired
	ChatService chatService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
	@PostConstruct
	public void getUploadPathPropeties() {
		uploadFolder = environment.getProperty("uploadFolder");
	}
	
	@RequestMapping("getChatList.do")
	public String getChatList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="20") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(chatService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<ChatVO> chatList = chatService.getChatList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("chatList", chatList);		
		return "chat/getChatList.jsp";
	}
	
	@RequestMapping("*/insertChat.do")
	public String insertChat(ChatVO chat) throws IOException {
		MultipartFile uploadFile = chat.getUploadFile1();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadFolder + fileName));
			chat.setFileName1(fileName);
		}	
		chatService.insertChat(chat);
		return "redirect:/getChatList.do";
	}	
	
	@RequestMapping(value="/updateChat.do", method=RequestMethod.GET)
	public String updateChat(Model model, ChatVO chat, SearchVO searchVO) {
		chatService.updateCount(chat);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("chat", chatService.getChat(chat));
		return "chat/updateChat.jsp";
	}
	
	@RequestMapping(value="/updateChat.do", method=RequestMethod.POST)
	public String updateChat(ChatVO chat) {
		chatService.updateChat(chat);
		return "getChatList.do";
	}	

	@RequestMapping(value="/deleteChat.do", method=RequestMethod.GET)
	public String deleteChat(Model model, ChatVO chat, SearchVO searchVO, @RequestParam int seq) {
		chat.setSeq(seq);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("chat", chatService.getChat(chat));
		return "chat/deleteChat.jsp";
	}
	
	@RequestMapping(value="/deleteChat.do", method=RequestMethod.POST)
	public String deleteChat(ChatVO chat) {
		chatService.deleteChat(chat);
		return "getChatList.do";
	}	
	
	
	@RequestMapping(value = "/chat.action", method = { RequestMethod.GET })
	public String chat (HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
	return "chat.do";
	}
		

	
	
	/* @RequestMapping("/download.do") */
	public String download(HttpServletRequest req, HttpServletResponse res) throws Exception { 	
		req.setCharacterEncoding("utf-8");
		String fileName = req.getParameter("fn");
		
		String fromPath = uploadFolder + fileName;
		String toPath = uploadFolder + fileName;
	
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
		

		
		
		return "getChatList.do";
	}	
}