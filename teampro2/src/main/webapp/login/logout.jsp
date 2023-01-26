<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Spring Framework</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
		integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
		crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</head>
<style>
	*{margin: 0; padding: 0;}
	hr { margin : 0; }
	.admin_my{ display : inline-block; width : 100%; padding-top : 20px; }
	#admin_img{ background-color : gray; margin-left : 300px; margin-top : 5px; position: absolute ;}
	#mem_info { margin-left : 420px; width : 500px; position: relative;}
	#bg_admin{ margin-left : 15px; }
	.list-group-item { padding-bottom : 20px; padding-top : 20px;}
</style>
<body>
<header>
	<div class="container">
		<div class="row align-items-start mt-3 p-3">
		  <div class="col mt-2"><a href="#"><i class="fas fa-calendar fa-3x"></i></a></div>
		  <div class="col" align="center"><a href="index.jsp"><img src="resources/images/logo.png" alt="logo" width=90px height=90px ></a></div>
		  <div class="col mt-2 text-end"><a href="#"><i class="fas fa-heart fa-3x"></i></a>
		  <span class="mx-4"><a href="login.do"><i class="fas fa-user fa-3x"></i></a></span>
		  <span><a href="#"><i class="fas fa-search fa-3x"></i></a></span>
		  </div>
	<hr />	
		</div>
	</div>
</header>
		<div class="admin_my">
		<div class="admin_img">
		<img src="resources/images/logo.png" class="rounded-circle" id="admin_img" alt="" width="100px" height="100px">
		</div>
		<div class="container mt-3" id="mem_info">
		  <h3>${ sessionScope.user.getName() }님</h3>
		  <c:if test="${ sessionScope.isAdmin }">
		  <span class="badge rounded-pill bg-warning" id="bg_admin">관리자</span>
		  </c:if>
		  </div>
		<br />
		</div>
		<br />
		<br />
		<div class="container mt-3" align="left">
		  <ul class="list-group list-group-flush">
		    <a href="#" class="list-group-item">게시물 신고</a>
		    <a href="getCsitemList.do" class="list-group-item">고객 문의사항</a>
		    <a href="#" class="list-group-item">배너 관리</a>
		    <a href="getNoticeList.do" class="list-group-item">공지사항</a>
		 </ul>
		 <hr />
		 </div>
		 <div class="container mt-3" align="left">
		 <ul class="list-group list-group-flush">
		    <a href="getBoardList.do" li class="list-group-item">게시판관리</a>
		    <c:if test="${ sessionScope.isAdmin }">
		    <a href="getUserList.do" li class="list-group-item">사용자관리</a>
		   </c:if>
		 </ul>
		 </div>
</body>
<footer>
	<div class="container" align="right">
	<br />
	<br />
	<br />
		<a href="logout.do" class="badge rounded-pill bg-secondary">로그아웃</a>
	</div>
</footer>
</html>			