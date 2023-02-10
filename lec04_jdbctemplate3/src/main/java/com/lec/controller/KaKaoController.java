package com.lec.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class  KaKaoController {

@RequestMapping("kakao_login.do")
public String KakaoController() {
    StringBuffer loginUrl = new StringBuffer();
    loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
    loginUrl.append("cb587a84d2bedec5be47af68f42ecdcd"); 
    loginUrl.append("&redirect_uri=");
    loginUrl.append("http://localhost:8088/jdbc/mainpage.jsp"); 
    loginUrl.append("&response_type=code");
    
    return "redirect:"+loginUrl.toString();
    
    
    
    
    
}


}


























