package com.lec.controller;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lec.jdbc.service.KakaoService;


@Controller
public class  KaKaoController {
	
	
	@Autowired 
	KakaoService kakaoService;
	
    @RequestMapping("/kakao")
    public String getUserInfo(@RequestParam String code, Model model, HttpSession sess) throws IOException {
        System.out.println("code = " + code);
        String access_token = kakaoService.getToken(code);    
        Map<String, Object> userInfo = kakaoService.getUserInfo(access_token);
        model.addAttribute("code", code);
        model.addAttribute("access_token", access_token);
        model.addAttribute("userInfo", userInfo);
        sess.setAttribute("access_token", access_token);
        return "kakaojoin.jsp";
      
    }
	/*
	 * @RequestMapping(value="/logout") public String access(HttpSession session)
	 * throws IOException {
	 * 
	 * String access_token = (String)session.getAttribute("access_token");
	 * HashMap<String, Object> userInfo = new HashMap<>(); String reqURL =
	 * "https://kapi.kakao.com/v1/user/logout";
	 * 
	 * URL url = new URL(reqURL); HttpURLConnection conn = (HttpURLConnection)
	 * url.openConnection(); conn.setRequestMethod("GET");
	 * conn.setRequestProperty("Authorization", "Bearer " + access_token); int
	 * responseCode = conn.getResponseCode();
	 * 
	 * 
	 * 
	 * return "redirect:/"; }
	 */
    
 
}
