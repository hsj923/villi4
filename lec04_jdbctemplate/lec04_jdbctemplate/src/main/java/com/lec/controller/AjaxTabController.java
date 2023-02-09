package com.lec.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller

@RequestMapping("/test/jquery/tab")

public class AjaxTabController

{

	@RequestMapping("ajaxTab")

	public String moveAjaxTabPage()

	{

		return "jqueryTest/ajaxTabTest";

	}

	

	@RequestMapping("tabContent1")

	public String getAjaxTabContent1()

	{

		return "tabContent/ajaxTabContent1";  // AJAX 탭에 로딩되는 뷰페이지.

	}

}