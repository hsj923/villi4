<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Villi : 관리자 페이지</title>
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
	.list-group-item { padding-bottom : 20px; padding-top : 20px;}
	 @font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
   }

body {
	font-family: 'Pretendard-Regular';
}
 /* Header */

header {
	background-color: #FFF;
}

.r_menu a{
text-decoration: none;
color:black;
}
   
   @font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
}

body {
	font-family: 'Pretendard-Regular';
}

.logout_btn a:hover{
color:white;

}
  
a:hover{
color:#23dbc9
}

	.admin_my{ display : inline-block; width : 100%; padding-top : 20px; }
	#admin_img{ background-color : gray; margin-left : 300px; margin-top : 5px; position: absolute ;}
	#mem_info { margin-left : 420px; width : 500px; position: relative;}
	#bg_admin{ margin-left : 15px; }
</style>
<body>
<!-- ===========header================ -->
<header class="border-bottom border-white">
		<div class="container">
			<div class="row align-items-start p-3">
				<div class="col mt-3">
					<a href="#"><i class="fas fa-calendar fa-2x text-dark"></i></a>
				</div>
				<div class="col" align="center">
					<a href="../getBoardList.do"><img src="../resources/images/test.png"
						alt="logo" width=70px height=70px></a>
				</div>
			<div class="col mt-3 text-end r_menu">
					<span class= mx-2><a href="#">좋아요</a> </span>
					<!-- 관리자로 로그인 할 경우 -->
	                  <c:if test="${ sessionScope.isAdmin }">
	                  <span class=mx-1><a href="user/adminpage.jsp" style="text-decoration:none" class="text-dark">관리자페이지</a></span> 
					  </c:if>
					  
					  <!-- 관리자로 로그인 하지 않았을 경우 -->
					  <c:if test="${ sessionScope.isAdmin != null && !sessionScope.isAdmin }">
	                  <span class=mx-1><a href="user/mypage.jsp" style="text-decoration:none" class="text-dark">마이페이지</a></span> 
	                  </c:if>
					<span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				</div>
			</div>
		</div>
</header>

		<!------------- 프로필 이미지, oo님 ---------------->
		
		 
  		<div class="container-sm mt-5" align="left" >
     	
     	<div class="row mt-2"> 
     	
     	<div class="col-2">  	
     	
    	  <c:if test="${ !empty  sessionScope.user.fileName}">
			<img src="../resources/images/${ sessionScope.user.fileName }" class="rounded-circle border border-dark" width="80" height="80" alt="img">
		  </c:if>
		  <c:if test="${ empty  sessionScope.user.fileName}">
			<img src="../resources/images/noimg.png" class="rounded-circle border border-dark" width="80" height="80" alt="img">
		  </c:if>
		  </div>   
		  
	   <div class="col mt-4">
     	 <h4>${sessionScope.user.getNickname()}님</h4>
		  <c:if test="${ sessionScope.isAdmin }">
		  <span class="badge rounded-pill bg-warning" id="bg_admin">관리자</span>
		  </c:if>
       </div>
    </div>
  	</div>
					
				
      <br />
      <br />
      <br />
		
		<%-- <div class="admin_my">
		<div class="admin_img">
		<img src="resources/images/logo.png" class="rounded-circle" id="admin_img" alt="" width="100px" height="100px">
		</div>
		<div class="container mt-3" id="mem_info">
		  <h3>${ sessionScope.user.getNickname() }님</h3>
		  </div>
		<br />
		</div>
		<br />
		<br /> --%>
		
		
		<div class="container mt-3" align="left">
		  <ul class="list-group list-group-flush">
		    <a href="#" class="list-group-item">게시물 신고</a>
		    <a href="../getCsBoardList.do" class="list-group-item">고객 문의사항</a>
		    <a href="#" class="list-group-item">배너 관리</a>
		    <a href="../getNoticeList.do" class="list-group-item">공지사항</a>
		 </ul>
		 <hr />
		 </div>
		 <div class="container mt-3" align="left">
		 <ul class="list-group list-group-flush">
		    <a href="../getBoardList.do" li class="list-group-item">게시판관리</a>
		    <c:if test="${ sessionScope.isAdmin }">
		    <a href="../getUserList.do" li class="list-group-item">사용자관리</a>
		   </c:if>
		 </ul>
		 </div>
</body>
<footer>
	<div class="container" align="right">
	<br />
	<br />
	<br />
		<a href="../logout.do" class="badge rounded-pill bg-secondary">로그아웃</a>
	</div>
</footer>
</html>			