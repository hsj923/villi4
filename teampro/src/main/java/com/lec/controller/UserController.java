package com.lec.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.jdbc.commom.SearchVO;
import com.lec.jdbc.service.UserService;
import com.lec.jdbc.vo.PageInfo;
import com.lec.jdbc.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// @Value("${selectById}") private String selectById;	
	// @Value("$usersql['selectUserList']") private String selectUserList;	
	
	@RequestMapping("getUserList.do") 
	public String getUserList(UserVO userVO, Model model,
			@RequestParam(defaultValue="1") int p,
			@RequestParam(defaultValue="10") int perPage) {
		
		PageInfo pageInfo = userService.getPageInfo(p, perPage);				
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userList", userService.getUserList(p, perPage));	
		return "user/user_list.jsp";
	}
	
	//@RequestMapping("getUserList.do") 
	public String getUserList(UserVO userVO, SearchVO searchVO, Model model) {	
		
		int totalRowCount= userService.getTotalRowCount(searchVO);
		searchVO.setTotalRowCount(totalRowCount);
		searchVO.pageSetting();
		
		model.addAttribute("pageInfo", searchVO);
		model.addAttribute("userList", userService.getUserList(searchVO));			
		return "user/user_list.jsp";
	}
	
	@RequestMapping("*/insertUser.do")
	public String insertUser(UserVO user) {
		userService.insertUser(user);
		return "redirect:/getUserList.do";
	}
	
	@RequestMapping(value="/deleteUser.do", method=RequestMethod.GET)
	public String deleteUserView(Model model, @RequestParam String id) {
		model.addAttribute("user", userService.getUser(id));
		return "user/user_delete.jsp?id=" + id;
	}
	
	@RequestMapping(value="/deleteUser.do", method=RequestMethod.POST)
	public String deleteUser(UserVO user) {
		userService.deleteUser(user);
		return "getUserList.do";	
	}
	
	@RequestMapping(value="/updateUser.do", method=RequestMethod.GET)
	public String updateUser(Model model, @RequestParam String id) {
		model.addAttribute("user", userService.getUser(id));
		return "user/user_update.jsp";
	}
	
	@RequestMapping(value="/updateUser.do", method=RequestMethod.POST)
	public String updateUser(UserVO user) { 
		userService.updateUser(user);
		return "getUserList.do";
	}
}






















