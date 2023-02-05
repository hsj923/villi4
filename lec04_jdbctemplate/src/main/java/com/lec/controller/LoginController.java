package com.lec.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lec.jdbc.dao.LoginDAO;
import com.lec.jdbc.impl.UserServiceImpl;
import com.lec.jdbc.vo.UserVO;


@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)  
	public String login() {
		return "login/login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, LoginDAO loginDAO, HttpSession session) {
		
		UserVO user = loginDAO.getUser(vo.getEmail());
		
		
		if(user == null) {
			session.setAttribute("isLoginSuccess", false);
			return "login/login.jsp";
		}
		
		
		if(!user.getPassword().equals(vo.getPassword())) {
			session.setAttribute("matchedPassword", false);
			return "login/login.jsp";
			
		} else {
			session.setAttribute("matchedPassword", true);
			return "mainpage.jsp";
		}
	}
		
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value = "/emailCheck.do" , method = RequestMethod.POST)
	   @ResponseBody
	   public String emailCheck(@RequestParam("email") String email){
	      int cnt = userService.emailCheck(email);
	      if (cnt != 0) {
	         return "fail";
	      } else {
	         return "success";
	      }
	   }
	

	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(UserVO userVO, HttpSession sess) {
		sess.invalidate();
		return "index.jsp";
	}	
}