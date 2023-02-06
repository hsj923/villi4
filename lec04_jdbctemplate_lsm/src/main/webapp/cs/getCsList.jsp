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

.pagination li a {
	border-radius: 0 !important;
	color: #333 !important;
}
.pagination li.active a {
	color: #fff !important;
	background: #444 !important;
	border-color: #444 !important;
}
</style>


</head>
<body>
 <!--------------- header --------------->
 
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
               <span class="mx-2">${ sessionScope.user.getNickname() }님</span>
            </div>
         </div>
      </div>
      
 <!-------------- script -------------->     
	<script>
		function deleteCs() {
			if(confirm("문의사항을 삭제하겠습니까?")) {
		    	self.location.href = "deleteCs.do?noti_seq=${ cs.noti_seq }";
		    }
		}
	</script>
</header>

<!------------------ 본문 ------------------->
	<div class="container col-5 mt-4"  align="center">
	 	<h3 class="fw-bold">고객 문의</h3>
	</div>
	<hr/>	
	
	
	<!-- =============== 자주 묻는 질문(if문으로 관리자가 작성한 글로만 수정해야함, 사용자들이 등록한 문의게시물 리스트 따로 밑에 필요함) =================== -->
	<div class="container mt-3">	
	<h4 class="fw-bold  mt-4 mb-3">자주 묻는 질문</h4>
		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark text-center">
				<th scope="col" class="col-1 text-center">No.</th>
				<th scope="col" class="col-5">제목</th>
				<th scope="col" class="col-1 text-center">작성자</th>
			    <th scope="col" class="col-1 text-center">조회수</th>
				<th scope="col" class="col-1 text-center">등록일</th>
				
				<!-- ================ 관리자일때 표시 =================== -->
			    <c:if test="${ sessionScope.isAdmin }">
					<th scope="col" class="col-1 text-center">삭제</th>
				</c:if>			
				
			</thead>
		    <tbody>
				<c:forEach var="cs" items="${ csList }">
					<tr>
					    <td scope="row" align="center">${cs.seq }</td>
						<td align="left"><a href="updateCs.do?seq=${cs.seq}" class="title">${ cs.title }</a></td>
						<td scope="row" align="center">${cs.writer }</td>
						<td scope="row" align="right">${cs.cnt }</td>
						<td><fmt:formatDate value="${cs.regDate }" pattern="yyyy-MM-dd"/></td>
					<c:if test="${ sessionScope.isAdmin }">
						<td align="center">
							<a href="deleteCs.do?noti_seq=${ cs.seq }" class="btn btn-danger" onclick="deleteCs()"><i class="fas fa-trash"></i></a>
						</td>
					</c:if>
					</tr>
				</c:forEach>			
			</tbody>
		</table>	
		
		<!-- ==================== 검색 ====================== -->
		<div class="row">
		<div class="col text-start">
       <form action="getCsList.do" method="post" id="csForm">
		 <input type="hidden" id="curPage" name="curPage"
			value="${searchVO.getCurPage()}"> <input
			type="hidden" id="rowSizePerPage" name="rowSizePerPage"
			value="${searchVO.getRowSizePerPage()}">
		 <div class="container">
			<div class="row justify-content-md">
				<div class="col-md-auto">

					<select class="form-select" id="searchType"
						name="searchType">
						<option value="">검색</option>
						<option value="title"
							${searchVO.getSearchType()=="title" ? "selected" : ""}>제목</option>
						<option value="content"
							${searchVO.getSearchType()=="content" ? "selected" : "" }>내용</option>
					</select>
					
				</div>
				<div class="col col-lg-4">
					<input class="form-control" name="searchWord" type="text"
						placeholder="${searchVO.getCurPage()}of ${searchVO.getTotalRowCount()}" />
				</div>
				<div class="col col-lg-2">
					<button class="btn text-white "  style="background-color: #72CCD2;" type="submit">Search</button>
				</div>
			</div>
		 </div>
		</form>
		</div>
		
		
		<div class="col text-end">
		<input type="submit" class="btn btn-dark mx-4 "  value="1:1 문의하기" onClick="location.href='cs/insertCs.jsp'"/>
		</div>
		</div>
		
			
	</div>
	
	
	
	
	

	<!------- 여기서부터는 페이징 처리 ------->
	<div class="container mt-3">
		<div class="row align-items-start">
						
			<ul class="pagination justify-content-center">								
				<c:set var="cp" value="${ pageInfo.getCurrentPage() }"/>

				<c:if test="${ pageInfo.getStartPage() != 1 }">
					<li class="page-item"><a href="getCsList.do?p=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a href="getCsList.do?p=${ pageInfo.getStartPage() - 10 }" class="page-link"><i class="fas fa-backward"></i></a></li>				
				</c:if>
			
				<c:forEach var="page" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
					<li class="page-item ${ (cp==page) ? 'active' : ''}"><a href="getCsList.do?p=${page}" class="page-link">${page}</a></li>
				</c:forEach>
				
				<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPages() }">
					<li class="page-item"><a href="getCsList.do?p=${ pageInfo.getEndPage() + 1 }" class="page-link"><i class="fas fa-forward"></i></a></li>				
					<li class="page-item"><a href="getCsList.do?p=${ pageInfo.getTotalPages() }" class="page-link"><i class="fas fa-fast-forward"></i></a></li>				
				</c:if>
			</ul>	    	
		</div>
	</div> 		
</body>
</html>