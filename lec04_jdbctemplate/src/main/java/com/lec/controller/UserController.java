package com.lec.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

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
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.UserVO;

@Controller("userController")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;
	
	private String uploadFolder = "";
	
   @PostConstruct
   public void getUploadPathProperties() {
	   uploadFolder = environment.getProperty("uploadFolder");
   }
		
	@RequestMapping("getUserList.do")
	public String getUserList(Model model, SearchVO searchVO,
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="10") int rowSizePerPage,
			@RequestParam(defaultValue="") String searchCategory,
			@RequestParam(defaultValue="") String searchType,
			@RequestParam(defaultValue="") String searchWord) {
		
		searchVO.setTotalRowCount(userService.getTotalRowCount(searchVO));
		searchVO.setCurPage(curPage);
		searchVO.setRowSizePerPage(rowSizePerPage);
		searchVO.setSearchCategory(searchCategory);
		searchVO.setSearchType(searchType);
		searchVO.setSearchWord(searchWord);
		searchVO.pageSetting();
	
		List<UserVO> userList = userService.getUserList(searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("userList", userList);
		return "user/mypage.jsp";
	}
	
	@RequestMapping("*/insertUser.do")
	public String insertUser(UserVO user) {		
		userService.insertUser(user);
		return "redirect:/getUserList.do";
	}	

//	@RequestMapping("*/insertUser.do")
//	public String insertUser(UserVO user) throws IOException {
//		MultipartFile uploadFile = user.getUploadFile();
//		if(!uploadFile.isEmpty()) {
//			String fileName = uploadFile.getOriginalFilename();
//			uploadFile.transferTo(new File(uploadFolder + fileName));
//			user.setFileName(fileName);
//		}
//		
//		userService.insertUser(user);
//		return "redirect:/getUserList.do";
//	}
	
	@RequestMapping(value="/updateUser.do", method=RequestMethod.GET)
	public String updateUser(Model model, UserVO user, SearchVO searchVO) {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("user", userService.getUser(user));
		return "user/updateUser.jsp";
	}
	
	@RequestMapping(value="/updateUser.do", method=RequestMethod.POST)
	public String updateUser(UserVO user) throws IOException {
		MultipartFile uploadFile = user.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadFolder + fileName));
			user.setFileName(fileName);
		}
		userService.updateUser(user);
		return "getUserList.do";
	}	

	
	//**
	
	
	@RequestMapping(value="/getUser.do", method=RequestMethod.GET)
	public String getUser(Model model, UserVO user, SearchVO searchVO) {
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("user", userService.getUserByNick(user));
		return "user/getUser.jsp";
	}
	
	@RequestMapping(value="/getUser.do", method=RequestMethod.POST)
	public String getUser(UserVO user) throws IOException {
		MultipartFile uploadFile = user.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadFolder + fileName));
			user.setFileName(fileName);
		}
		userService.getUserByNick(user);
		return "getUserList.do";
	}
	
	
	
	
	
	
	@RequestMapping(value="/deleteUser.do", method=RequestMethod.GET)
	public String deleteUser(Model model, UserVO user, SearchVO searchVO, @RequestParam String email) {
		user.setEmail(email);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("user", userService.getUser(user));
		return "user/deleteUser.jsp";
	}
	
	
	
	@RequestMapping(value="/deleteUser.do", method=RequestMethod.POST)
	public String deleteUser(UserVO user) {
		userService.deleteUser(user);
		return "getUserList.do";
	}	
}