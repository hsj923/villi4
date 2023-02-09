<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

.title{
text-decoration: none;
color:black;
}

.title:hover{

color:#23dbc9;
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
						<span class=mx-1><a href="getUserList.do" style="text-decoration:none" class="text-dark">마이페이지</a></span>
						<span class=mx-1><a href="location/infoVilli.jsp" style="text-decoration:none" class="text-dark">동네정보</a></span>  
						<span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				</div>
			</div>
		</div>
	</header>
 <!-------------- script -------------->     
	<script>
		function deleteNotice() {
			if(confirm("공지를 삭제하겠습니까?")) {
		    	self.location.href = "deleteNotice.do?noti_seq=${ notice.noti_seq }";
		    }
		}
	</script>
</header>

<!------------------ 본문 ------------------->

	<div class="container col-5 mt-4"  align="center">
	 	<h3 class="fw-bold">공지사항</h3>
	</div>
	
	<hr/>
				
	<div class="container mt-3">
		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark text-center">
				<th scope="col" class="col-1 text-center">No.</th>
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
						<td align="left"><a href="updateNotice.do?noti_seq=${ notice.noti_seq}" class="title">${ notice.noti_title }</a></td>
						<td><fmt:formatDate value="${notice.noti_regDate }" pattern="yyyy-MM-dd"/></td>
					<c:if test="${ sessionScope.isAdmin }">
						<td align="center">
							<a href="deleteNotice.do?noti_seq=${ notice.noti_seq }" class="btn btn-danger" onclick="deleteNotice()"><i class="fas fa-trash"></i></a>
						</td>
					</c:if>
					</tr>
				</c:forEach>			
			</tbody>
		</table>		
	</div>

	<!------- 여기서부터는 페이징 처리 ------->
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