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
	<div class="container"  align="center">
		<div class="mt-4 p-5 bg-primary text-white rounded">
			<h3>게시글 목록</h3>
			<h5>${ sessionScope.user.getName() }님! 게시판에 오신걸 환영합니다...</h5>
		
		</div>
		
		<div class="row mt-3">
	    	<a href="logout.do" class="col-1 btn btn-primary me-2">로그아웃</a>
			<a href="board/board_insert.jsp" class="col-1 btn btn-primary">글등록</a>
		</div>
				
		<div class="row mt-4">
			<table class="table table-bordered table-striped table-hover">
				<thead class="table-dark text-center">
					<th scope="col" class="col-1 text-center">글번호</th>
					<th scope="col" class="col-6">제목</th>
					<th scope="col" class="col-1 text-center">작성자</th>
					<th scope="col" class="col-1 text-center">등록일</th>
					<th scope="col" class="col-1 text-center">조회수</th>			
					<th scope="col" class="col text-center">파일</th>			
				</thead>
				<tbody>
				
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td scope="row">${board.seq }</td>
						<td align="left"><a href="getBoard.do?seq=${ board.seq}">${board.title }</a></td>
						<td>${ board.writer }</td>
						<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
						<td>${ board.cnt }</td>
						
						<!-- 이미지 처리 구간 -->
						<td align="center">
						<c:if test="${!empty board.listimg}">
						<i class="btn btn-primary btn-sm"></i>
						<img alt="" src ="D:/lec03/99.temp/upload/awww.jpg"/>${board.filename}
						</c:if>
						</td>
					</tr>
				</c:forEach>			
				</tbody>
			</table>		
		</div>
	
	<div class="container mt-3">
		<div class="row align-items-start">
						
			<ul class="col pagination justify-content-center">								
				<c:set var="cp" value="${ pageInfo.getCurrentPage() }"/>

				<c:if test="${ pageInfo.getStartPage() != 1 }">
					<li class="page-item"><a href="getBoardList.do?p=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a href="getBoardList.do?p=${ pageInfo.getStartPage() - 10 }" class="page-link"><i class="fas fa-backward"></i></a></li>				
				</c:if>
			
				<c:forEach var="page" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
					<li class="page-item ${ (cp==page) ? 'active' : ''}"><a href="getBoardList.do?p=${page}" class="page-link">${page}</a></li>
				</c:forEach>
				
				<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPages() }">
					<li class="page-item"><a href="getBoardList.do?p=${ pageInfo.getEndPage() + 1 }" class="page-link"><i class="fas fa-forward"></i></a></li>				
					<li class="page-item"><a href="getBoardList.do?p=${ pageInfo.getTotalPages() }" class="page-link"><i class="fas fa-fast-forward"></i></a></li>				
				</c:if>
			</ul>	    	
		</div>
	</div> 		
</body>
</html>