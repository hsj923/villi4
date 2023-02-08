<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Villi : 공지사항</title>
<link rel="icon" href="../resources/images/favicon.png">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
		integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
		crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</head>
<style>

.input-group mb-3 { background-color : white; }

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

nav {
	background-color: #FFF;
	}


/* Header */

header {
    background-color: #FFF;
	}

.r_menu a{
	text-decoration: none;
	color:black;
	}
	
.r_menu a:hover{
	color:#23dbc9;
	}
	
pre { white-space: pre-wrap; 
	  font-family: 'Pretendard-Regular';}

</style>
	
	
<body>

	<!-- ===========header================ -->
	<header class="border-bottom border-white">
		<div class="container">
			<div class="row align-items-start p-3">
		
				
				<div class="col mb-3">
					<a href="getBoardList.do"><img src="resources/images/test.png"
						alt="logo" width=70px height=70px></a>
				</div>

				<div class="col mt-3 text-end r_menu">
					<span class=mx-2><a href="#" style="text-decoration:none" class="text-dark">좋아요</a> </span> 
						<span class=mx-1><a href="user/mypage.jsp" style="text-decoration:none" class="text-dark">마이페이지</a></span>
						<span class=mx-1><a href="location/infoVilli.jsp" style="text-decoration:none" class="text-dark">동네정보</a></span>  
						<span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				</div>
			</div>
		</div>
	</header>


	<script>
		function deleteNotice() {
			if(confirm("공지를 삭제하겠습니까?")) {
		    	self.location.href = "deleteNotice.do?noti_seq=${ notice.noti_seq }";
		    }
		}
	</script>
	

	<div class="container-sm mt-5" align="center">
		<form action="updateNotice.do" method="post">
		
			  <div class="card">
			  		<ul	class="list-group list-group-flush">
			  			<li class="list-group-item text-start">
			  			
			  				<span class="fs-5 fw-bold">${ notice.noti_title }</span>
			  				
			  				<hr>
			  				
			  				<pre class="fs-6">${ notice.noti_content }</pre>
			  				 
			  				<hr>
			  				
			  				<p class="mt-4 text-end">글 등록일 : ${notice.noti_regDate }</p></li>
			  			
			  			
			  			</li>
			  			
			  		
			  		
			  		</ul>
				  	
			  	
			  	
			  </div>
			  
			     
		   <!-- 관리자일 때만 글등록, 글삭제 보이게 -->
	<%-- 	    <c:if test="${ sessionScope.isAdmin }"> 
			</c:if>  --%>
		   
		   <div class="mt-4">
			
			<a href="getNoticeList.do" class="btn btn-dark mx-3"  onclick="deleteNotice()">글삭제</a>
			 
			<a href="getNoticeList.do" class="btn btn-dark mx-1">공지사항 목록</a>
			
			<a href="notice/insertNotice.jsp" class="btn btn-dark mx-3">공지사항 글등록</a>
			</div>
			  
			  
			  
			  
			  
     </div>
			<%-- <div class="input-group mb-3">
  	
  				<input type="text" class="form-control" name="title" value="${ notice.noti_title }" readonly>
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text"><i class="fas fa-clipboard"></i></span>
			  <textarea class="form-control"  name="noti_content" rows="20" readonly>${ notice.noti_content }</textarea>
			</div>	
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-calendar"></i></span>
  				<input type="text" class="form-control" name="date" value="${notice.noti_regDate }" readonly>
			</div>
			
			
		    <!-- input type="submit" class="btn btn-primary" value="글수정" -->
			<a href="deleteBoard.do?seq=${board.seq }" class="btn btn-primary">글삭제</a>
		    
		    
		   <!-- 관리자일 때만 글등록, 글삭제 보이도 -->
		    <c:if test="${ sessionScope.isAdmin }"> 
		    
			<a href="notice/insertNotice.jsp" class="btn btn-primary">공지사항 글등록</a>
			
			<a href="getNoticeList.do" class="btn btn-danger"  onclick="deleteNotice()">글삭제</a>
			
			</c:if> 
			
			<a href="getNoticeList.do" class="btn btn-primary">공지사항 목록</a>
			
		</form>			
	</div>
 --%>
</body>
</html>