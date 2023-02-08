</html>   <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


	<title>내가작성한글목록</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
		integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
		crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
<style>

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



</style>

</head>


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
 	<!-- ===========header================ -->
 	
 	
 	
 	
<form action="" method="post">	
<div class="container col-5 mt-4">
		<h3 class="fw-bold">내가 작성한 글목록</h3>
			<hr/>
			<br/>
			
		<div class="container mt-3">
		<div class="row mt-4">
			<table class="table table-hover table-bordered">
				<thead class="table-dark">
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">작성일</th>
				</thead>
				<tbody>
					<c:forEach var="question" items="${ myBoardList }">
						<tr>
						   	<td><a href="updateQuestion.do?seq=${board.getSeq()}"
								style="text-decoration: none">${ board.seq }</a></td>
							<td>${ board.title }</td>
							<td>${ board.content }</td>
							<td>${ board.regDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
			
			
			
			
			
			
			
			
			
			
			
			
      
   </div>  
   </form>    
</body>
</html>   















