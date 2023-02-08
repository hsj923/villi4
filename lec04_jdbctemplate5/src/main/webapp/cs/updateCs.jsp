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
		function deleteCs() {
			if(confirm("공지를 삭제하겠습니까?")) {
		    	self.location.href = "deleteCs.do?bno=${ cs.bno }";
		    }
		}
	</script>
	

	<div class="container-sm mt-5" align="center">
		<form action="updateCs.do" method="post">
		
			  <div class="card">
			  		<ul	class="list-group list-group-flush">
			  			<li class="list-group-item text-start">
			  			
			  				<span class="fs-5 fw-bold">${ cs.title }</span>
			  				
			  				<hr>
			  				
			  				<pre class="fs-6">${ cs.content }</pre>
			  				 
			  				<hr>
			  				
			  				<p class="mt-4 text-end">문의 등록일 : ${cs.regDate }</p></li>
			  			
			  			
			  			</li>
			  		</ul>
			  </div>
			  </form>
			  </div>
			  
<!-- 댓글 작성 -->
		<div class="container-sm mt-5" align="center">
		    <form method="post" action="insertCsReply.do">
		
		            <input type="hidden" name="writer" value="${ sessionScope.user.getNickname() }">

		        <p>
		            <textarea rows="5" cols="50" name="content" style="width:100%; height:70px;"></textarea>
		        </p>
		       
		        <p>
		        	<input type="hidden" name="bno" value="${cs.bno}">
		         
		          <c:if test="${ sessionScope.isAdmin }"> 
		        	
		            <button class="btn btn-dark " type="submit">댓글 작성</button>
		           
		          </c:if>
		          
		        </p>
		    </form> 
		</div>
	
		<!-- 댓글 시작 -->
	<div class="container-sm mt-5" align="center">
         <c:forEach items="${csreplyList}" var="csreplyList">
            <div class="card" style="border: 0;">
               <ul class="list-group list-group-flush">
                     <li class="list-group-item text-start">
                        <span class="fs-6 fw-bold" style="color: #4881f7;">${csreplyList.writer}</span> &nbsp; <span class="mt-4 text-end" style="font-size:12px">댓글 등록일 : ${csreplyList.regDate}</span>
                          <pre class="fs-6">${csreplyList.content}</pre>  
                     </li>   
                  </ul>
            </div>
            <hr />
         </c:forEach>
		<br />
				
		<!-- 댓글 끝 -->
			     
		   
		   <div class="mt-4">
			
			<a href="getCsList.do" class="btn btn-dark mx-3"  onclick="deleteCs()">글삭제</a>
			 
			<a href="getCsList.do" class="btn btn-dark mx-1">고객 문의 목록</a>
			
			<a href="cs/insertCs.jsp" class="btn btn-dark mx-3">글등록</a>
			</div>
			  
			  
			  
			  
			  
     </div>
			<%-- <div class="input-group mb-3">
  	
  				<input type="text" class="form-control" name="title" value="${ cs.noti_title }" readonly>
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text"><i class="fas fa-clipboard"></i></span>
			  <textarea class="form-control"  name="noti_content" rows="20" readonly>${ cs.noti_content }</textarea>
			</div>	
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-calendar"></i></span>
  				<input type="text" class="form-control" name="date" value="${cs.noti_regDate }" readonly>
			</div>
			
			
		    <!-- input type="submit" class="btn btn-primary" value="글수정" -->
			<a href="deleteBoard.do?bno=${board.bno }" class="btn btn-primary">글삭제</a>
		    
		    
		   <!-- 관리자일 때만 글등록, 글삭제 보이도 -->
		    <c:if test="${ sessionScope.isAdmin }"> 
		    
			<a href="cs/insertNotice.jsp" class="btn btn-primary">공지사항 글등록</a>
			
			<a href="getNoticeList.do" class="btn btn-danger"  onclick="deleteNotice()">글삭제</a>
			
			</c:if> 
			
			<a href="getNoticeList.do" class="btn btn-primary">공지사항 목록</a>
			
		</form>			
	</div>
 --%>
</body>
</html>