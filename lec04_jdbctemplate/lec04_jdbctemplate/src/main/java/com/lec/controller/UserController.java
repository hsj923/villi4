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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lec.jdbc.common.SearchVO;
import com.lec.jdbc.service.BoardService;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.BoardVO;
import com.lec.jdbc.vo.UserVO;

@Controller("userController")
@PropertySource("classpath:config/uploadpath.properties")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	BoardService boardService;
	
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
	public String insertUser(UserVO user)  throws IOException{		
		MultipartFile uploadFile = user.getUploadFile();
		
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(uploadFolder + fileName));
			user.setFileName(fileName);
		}
		userService.insertUser(user);
		return "redirect:/login.do";
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
		return "redirect:/getUserList.do";
	}	

	
	//**
	
	
	
	@RequestMapping(value="/getUser.do", method=RequestMethod.POST)
	public String getUser(UserVO user) {
             userService.updateUser(user);
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
	
	
	// 동네 설정	
		@RequestMapping(value="/updateAddr.do", method=RequestMethod.GET)
		public String updateAddr(Model model, UserVO user, SearchVO searchVO, @RequestParam String email) {
			user.setEmail(email);
			model.addAttribute("searchVO", searchVO);
			model.addAttribute("user", userService.getUser(user));
			return "user/location.jsp";
		}
		
		@RequestMapping(value="/updateAddr.do", method=RequestMethod.POST)
		public String updateAddr(UserVO user) throws IOException {
			//System.out.println(user.toString());
			userService.updateAddr(user);
			return "getBoardList.do";
		}	
		
		
		@RequestMapping(value="/getUser.do", method=RequestMethod.GET)
		public String getUser(Model model, UserVO user, SearchVO searchVO, String nickname) {
			
//			내가 쓴글 목록
			List<BoardVO> MyboardList = boardService.getMyBoardList(nickname);
			model.addAttribute("MyboardList", MyboardList);
			
			model.addAttribute("searchVO", searchVO);
			model.addAttribute("user", userService.getUserByNick(user));
			return "user/getUser.jsp";
		}
		
		
	//거래후기	
		
		@RequestMapping(value="/good.do", method=RequestMethod.POST)
		@ResponseBody
		public String ajaxUser(UserVO user) {
			UserVO vo = userService.getUser(user);
			
			System.out.println("1........." + vo.getName());
			
			return vo.toString(); //vo.getName();
		}		
	
}