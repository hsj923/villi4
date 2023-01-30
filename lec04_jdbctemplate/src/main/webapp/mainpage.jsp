<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<title>main page</title>
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
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

body{
font-family: 'Pretendard-Regular';}

</style>


</head>
<body>
                  <!-- ===========header================ -->
 <header>
	<div class="container border-bottom border-dark">
		<div class="row align-items-start mt-3 p-3 opacity-100">
		  <div class="col mt-2"><a href="#"><i class="fas fa-calendar fa-3x text-dark"></i></a></div>
		  <div class="col" align="center"><a href="index.jsp"><img src="resources/images/logo.png" alt="logo" width=90px height=90px ></a></div>
		  
		  <div class="col mt-2 text-end"><a href="#"><i class="fas fa-heart fa-3x text-dark"></i></a>
		  <span class="mx-4"><a href="mypage.jsp"><i class="fas fa-user fa-3x text-dark"></i></a></span>
		  <span><a href="#"><i class="fas fa-search fa-3x text-dark" ></i></a></span>	
		  </div>
		</div>
	</div>	
</header>

                  <!-- ============banner=============== -->
  
  <div id="carouselExampleControls" class="carousel carousel-dark slide mt-3" data-bs-ride="carousel" align="center">
  
  <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleControls" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleControls" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleControls" data-bs-slide-to="2" aria-label="Slide 3"></button>
              </div>
  
				  <div class="carousel-inner">
				        <div class="carousel-item active embed-responsive embed-responsive-4by3 ">
				          <img src="resources/images/1.png"   class="d-block w-50 card-img-top embed-responsive-item" alt="banner1" width="300" height="600">
				        </div>
					    <div class="carousel-item embed-responsive embed-responsive-4by3">
					      <img src="resources/images/22.png" class="d-block w-50 card-img-top embed-responsive-item" alt="banner2" width="300" height="600">
					    </div>
					    <div class="carousel-item embed-responsive embed-responsive-4by3">
				          <img src="resources/images/3.png" class="d-block w-50 card-img-top embed-responsive-item" alt="banner3" width="300" height="600">
				       </div>
				  </div>
		
			</div>
  
  
	             <!-- 전체보기 인력 상품 동네 -->
	<div class="container mt-3 bg-white sticky-top z-index-10">
	  <div class="row border-bottom border-dark border-top border-dark mt-3 p-3">
		 <div class="col" align="center">
		      <a href="getBoardList.do" class="btn btn-info">전체보기</a>
		      
		 </div>
		 <div class="col" align="center">
		      <a href="board/board_list.jsp" class="btn btn-info "  >상품</a>
		 </div>
		 <div class="col" align="center">
		    <a href="board/board_list.jsp" class="btn btn-info">인력</a>
		 </div>
		 <div class="col" align="center">
		   <a href="board/board_list.jsp" class="btn btn-info ">동네생활</a>
		 </div>
	  </div>
	 	

	              <!-- ================글작성버튼============= -->
  		<div class="container-lg mt-10 bg-white" align="right">
	     <a href="board/board_insert.jsp" class="w-20 p-3 col-1 mt-3 btn btn-secondary">글작성</a>
	 	</div>
  </div>
  
             <!-- =========상품보기=============== -->
              <!-- ======================LIST========================= -->
              
          <c:set var="i" value="0" />
		 <c:set var="j" value="2" />
		 <div class="container mt-1">
		 <div class="col" align="center">
		 <table>
		  <c:choose>
		   <c:when test="${boardList != null && fn:length(boardList) > 0 }">
		    <c:forEach items="${boardList}" var="board">
		     <c:if test="{i%j == 0}">
		      <tr>
		     </c:if>
		     
		       <!-- 사진이 있으면 -->
			     <c:if test="${ !empty  board.fileName1}">
			     <td align="center"><img src="resources/images/${ board.fileName1 }" class="d-block w-50 card-img-top embed-responsive-item border border-dark mt-3" alt="img"  width="350" height="350">
			     </c:if>
			     <!-- 사진이 없으면 -->
			     <c:if test="${ empty  board.fileName1}">
			     <td align="center"><img src="resources/images/noimg.png"  class="d-block w-50 card-img-top embed-responsive-item border border-dark mt-3" alt="img"  width="350" height="350">
			     </c:if>
				 
				 
		         <a href="getBoard.do?seq=${ board.seq}"><h4>${board.title}</h4></a>  <h5>${board.writer} / ${board.regDate}</h5>  대충위치자리  대충좋아요자리  대충조회수자리</td>
		    <c:if test="${i%j == j-1}">
		     </tr>
		    </c:if> 
		   <c:set var="i" value="${i+1}" />
		    </c:forEach>		    
		   </c:when>		   
		  <c:otherwise>
		   <tr>
		    <td>존재하지 않습니다.</td>
		   </tr>
		  </c:otherwise>
		  </c:choose>		    
		 </table>
		 </div>
    </div>
    

	                 <!-- =======================LIST 끝========================== -->         


			  <!--====== admin일경우 사용자관리 및 신고글관리============  -->
		<c:if test="${ sessionScope.isAdmin }">
		<a href="getUserList.do" class="btn btn-primary">사용자관리</a>
		</c:if>	
		
		<c:if test="${ sessionScope.isAdmin }">
		<a href="getReportList.do" class="btn btn-primary">신고글관리</a>
		</c:if>	

	

                    <!-- ==================페이징============== -->
	
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