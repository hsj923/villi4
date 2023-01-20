package com.lec.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.jdbc.dao.LoginDAO;
import com.lec.jdbc.vo.UserVO;


@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET) 
	public String login(UserVO user, HttpSession sess) {
		
		user.setId("admin@gmail.com");
		user.setPassword("12345");
		sess.setAttribute("isLoginSuccess", true);
		return "login/login.jsp";
	}

	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, LoginDAO loginDAO, HttpSession session) {
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		
		UserVO user = loginDAO.getUser(vo);
		
		if(!user.getPassword().equals(vo.getPassword())) {
			session.setAttribute("matchedPassword", false);
			return "login/login.jsp";
		} else {
			session.setAttribute("matchedPassword", true);
		}
		
		if (user != null) {
			if(user.getRole().equalsIgnoreCase("ADMIN")) {
				session.setAttribute("isAdmin", true);
			} else {
				session.setAttribute("isAdmin", false);
			}			
			session.setAttribute("user", user);
			session.setAttribute("perPage", 10);
			return "login/logout.jsp";
		} else
			return "login/login.jsp";
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(UserVO userVO, HttpSession sess) {
		sess.invalidate();
		return "index.jsp";
	}	
}