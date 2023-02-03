package com.lec.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.jdbc.dao.BoardDAO;

public class HeartController {

//	
//	// heart.jsp(상세조회)를 가기전에 회원이 해당 게시글에 좋아요를 한게 있는지 체크하는 부분.
//	
//	@RequestMapping(value="heart",method=RequestMethod.GET)
//	public String detail(@RequestParam("seq") int seq, Model model, @RequestParam(value="page", required=false, defaultValue="1")int page, @RequestParam("nickname") String nickname) {
//		// 기존 detail부분
//		BoardDAO board = es.detail(e_number);
//		model.addAttribute("exhibition",exhibition);
//		model.addAttribute("page", page);
//
//		// 아래부터 좋아요 기능 시 추가되는 부분
//
//		HeartDTO heart = new HeartDTO();
//		// 좋아요가 되있는지 찾기위해 게시글번호와 회원번호를 보냄.
//		heart = es.findHeart(e_number, m_number);
//		// 찾은 정보를 heart로 담아서 보냄
//		model.addAttribute("heart",heart);
//		return "exhibition/detail";
//	}
//	
}
