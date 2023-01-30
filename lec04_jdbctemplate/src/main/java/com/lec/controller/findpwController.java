package com.lec.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.lec.jdbc.impl.UserServiceImpl;
import com.lec.jdbc.vo.UserVO;

@Controller
public class findpwController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value="/findpw.do", method=RequestMethod.GET) 
	public String findpw(UserVO user, HttpSession sess) {
		return "login/findpw.jsp";
	}
	
	
	@RequestMapping(value = "/findpw.do", method = RequestMethod.POST)
	public ModelAndView findpw(UserVO vo, ModelAndView mav, HttpSession sess) {
		UserVO user = userService.getUser1(vo);
		mav.setViewName("login/findpwok.jsp");
		sess.setAttribute("user", user);
		return mav.addObject("user", user);
	}	
	
	
}
	
	
	
	
	

