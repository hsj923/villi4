<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>글 목록</title>
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

<style type="text/css">

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

.btn_radius{
border-radius:1.5em;

}

.bg-dark a{
text-decoration: none;
color:white;
}

.bg-dark:hover{
text-decoration: none;
color:white;
}

.container btn_box mt-5{
width:100%;
border : 1px solid black; 

}

.row align-items-start{
border : 1px solid black; 
}

.btn btn-dark mx-4 btn_radius{
margin-right : 20px;
border : 1px solid black; 
}



</style>
</head>
<body>
 <!-- ===========header================ -->
   <header class="border-bottom border-white">
      <div class="container">
         <div class="row align-items-start p-3">
            <div class="col mt-3">
               <a href="#"><i class="fas fa-calendar fa-2x text-dark"></i></a>
            </div>
            <div class="col" align="center">
               <a href="getBoardList.do"><img src="resources/images/test.png"
                  alt="logo" width=70px height=70px></a>
            </div>

            <div class="col mt-3 text-end r_menu">
               <span class= mx-2><a href="#">좋아요</a> </span>
               <span class= mx-1><a href="user/mypage.jsp">마이페이지</a></span>
               <span class="mx-2">${ sessionScope.user.getName() }님</span>
            </div>
         </div>
      </div>
</header>
	 <div class="container col-5 mt-4" align="center">
   	 <h2>고객 문의</h2>
	</div>
	<hr/>	
		<%-- <div class="row mt-3">
	    	<!-- a href="logout.do" class="col-1 btn btn-primary me-2">로그아웃</a> -->
	    	<c:if test="${ sessionScope.isAdmin }">
			<a href="notice/notice_insert.jsp" class="col-1 btn btn-primary">공지사항 등록</a>
			</c:if>
		</div> --%>
				
		<div class=" container mt-3">
			<table class="table table-bordered table-striped table-hover">
				<thead class="table-dark text-center">
					<th scope="col" class="col-1 text-center">글 번호</th>
					<th scope="col" class="col-5">제목</th>
					<th scope="col" class="col-1 text-center">작성자</th>
					<th scope="col" class="col-1 text-center">등록일</th>
					<th scope="col" class="col-1 text-center">조회수</th>		
				</thead>
				
				<tbody>
				<c:forEach var="cs_board" items="${ csboardList }">
					<tr>
						<td scope="row">${cs_board.getBno() }</td>
						<td align="left"><a href="updateCsBoard.do?bno=${ cs_board.getBno()}">${cs_board.getTitle() }</a></td>
						<td>${ cs_board.getWriter() }</td>
						<td><fmt:formatDate value="${cs_board.getRegDate() }" pattern="yyyy-MM-dd"/></td>
						<td>${ cs_board.getViewCnt() }</td>
					</tr>
				</c:forEach>			
				</tbody>
			</table>
					
            
		</div>
		<br />
		<br />
		<br />
	<footer>
	<!-- 여기서부터는 페이징 처리 -->
	<div class="container mt-3">
		<div class="row align-items-start">
			<ul class="col pagination justify-content-center">								
				<c:set var="cp" value="${ pageInfo.getCurrentPage() }"/>
				<c:if test="${ pageInfo.getStartPage() != 1 }">
					<li class="page-item"><a href="getCsBoardList.do?p=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a href="getCsBoardList.do?p=${ pageInfo.getStartPage() - 10 }" class="page-link"><i class="fas fa-backward"></i></a></li>				
				</c:if>
			
				<c:forEach var="page" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
					<li class="page-item ${ (cp==page) ? 'active' : ''}"><a href="getCsBoardList.do?p=${page}" class="page-link">${page}</a></li>
				</c:forEach>
				
				<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPages() }">
					<li class="page-item"><a href="getCsBoardList.do?p=${ pageInfo.getEndPage() + 1 }" class="page-link"><i class="fas fa-forward"></i></a></li>				
					<li class="page-item"><a href="getCsBoardList.do?p=${ pageInfo.getTotalPages() }" class="page-link"><i class="fas fa-fast-forward"></i></a></li>				
				</c:if>
			</ul>		    	
		</div>
	</div>
	
	</footer>		
</body>
</html>