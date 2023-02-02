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
</head>
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
	<script>
		function deleteNotice() {
			if(confirm("공지를 삭제하겠습니까?")) {
		    	self.location.href = "deleteNotice.do?noti_seq=${ notice.noti_seq }";
		    }
		}
	</script>
</header>
	<div class="container"  align="center">
		<div class="mt-4 p-5 bg-primary text-white rounded">
			<h3>공지사항 목록</h3>
			<h5>${ sessionScope.user.getName() }님! 게시판에 오신걸 환영합니다...</h5>
		
		</div>
		
		<div class="row mt-3">
	    	<!-- a href="logout.do" class="col-1 btn btn-primary me-2">로그아웃</a> -->
	    	
	    	<c:if test="${ sessionScope.isAdmin }">
			<a href="notice/notice_insert.jsp" class="col-1 btn btn-primary">공지사항 등록</a>
			</c:if>
		</div>
				
		<div class="row mt-4">
			<table class="table table-bordered table-striped table-hover">
				<thead class="table-dark text-center">
					<th scope="col" class="col-1 text-center">글 번호</th>
					<th scope="col" class="col-5">제목</th>
					<th scope="col" class="col-1 text-center">등록일</th>
					<c:if test="${ sessionScope.isAdmin }">
					<th scope="col" class="col-1 text-center">삭제</th>
					</c:if>			
				</thead>
				<tbody>
				
				<c:forEach var="notice" items="${ noticeList }">
					<tr>
						<td scope="row">${notice.noti_seq }</td>
						<td align="left"><a href="getNotice.do?noti_seq=${ notice.noti_seq}">${notice.noti_title }</a></td>
						<td><fmt:formatDate value="${notice.noti_regDate }" pattern="yyyy-MM-dd"/></td>
						
						<c:if test="${ sessionScope.isAdmin }"><td align="center">
							<a href="deleteNotice.do?noti_seq=${ notice.noti_seq }" class="btn btn-danger" onclick="deleteNotice()"><i class="fas fa-trash"></i></a>
						</td>
						</c:if>
					</tr>
				</c:forEach>			
				</tbody>
			</table>		
		</div>

	<!-- 여기서부터는 페이징 처리 -->
	<div class="container mt-3">
		<div class="row align-items-start">
						
			<ul class="col pagination justify-content-center">								
				<c:set var="cp" value="${ pageInfo.getCurrentPage() }"/>

				<c:if test="${ pageInfo.getStartPage() != 1 }">
					<li class="page-item"><a href="getNoticeList.do?p=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a href="getNoticeList.do?p=${ pageInfo.getStartPage() - 10 }" class="page-link"><i class="fas fa-backward"></i></a></li>				
				</c:if>
			
				<c:forEach var="page" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
					<li class="page-item ${ (cp==page) ? 'active' : ''}"><a href="getNoticeList.do?p=${page}" class="page-link">${page}</a></li>
				</c:forEach>
				
				<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPages() }">
					<li class="page-item"><a href="getNoticeList.do?p=${ pageInfo.getEndPage() + 1 }" class="page-link"><i class="fas fa-forward"></i></a></li>				
					<li class="page-item"><a href="getNoticeList.do?p=${ pageInfo.getTotalPages() }" class="page-link"><i class="fas fa-fast-forward"></i></a></li>				
				</c:if>
			</ul>	    	
		</div>
	</div> 		
</body>
</html>