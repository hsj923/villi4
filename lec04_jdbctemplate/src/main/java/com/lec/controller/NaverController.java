package com.lec.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class  NaverController {

@RequestMapping("naver_login.do")
public String NaverController() {
    StringBuffer loginUrl = new StringBuffer();
    loginUrl.append("https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=");
    loginUrl.append("XaSCUbvxr98QJBzUIqzF"); 
    loginUrl.append("&redirect_uri=");
    loginUrl.append("http://localhost:8088/jdbc/mainpage.jsp"); 
    loginUrl.append("&response_type=code");
    
    return "redirect:"+loginUrl.toString();
    
    
    
    
    
}


}



























