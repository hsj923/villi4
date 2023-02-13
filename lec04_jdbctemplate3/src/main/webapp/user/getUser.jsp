<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Villi : 프로필 수정</title>
<link rel="icon" href="/img/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

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

/*거래 후기 창 css*/
#user-filter {
	margin-top: 20px;
	margin-bottom: 20px;
}

/* line 121, app/assets/stylesheets/home/users/show.css.scss */
#user-filter ul {
	list-style-type: none;
	border-bottom: 1px solid #e9ecef;
	padding-bottom: 10px;
}

/* line 125, app/assets/stylesheets/home/users/show.css.scss */
#user-filter ul li {
	display: inline-block;
	font-size: 17px;
}

/* line 128, app/assets/stylesheets/home/users/show.css.scss */
#user-filter ul li a {
	color: #868e96;
	text-decoration: none;
	padding: 8px 20px;
}

/* line 133, app/assets/stylesheets/home/users/show.css.scss */
#user-filter ul li a:hover {
	color: #f76707;
}

/* line 136, app/assets/stylesheets/home/users/show.css.scss */
#user-filter ul li a.active {
	border-bottom: 3px solid #f76707;
	color: #f76707;
	font-weight: 600;
}
/* 전체 후기 영역 */
#user-records {
	position: relative;
}

/* line 186, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-nickname-nickname .destroyed
	{
	color: #adb5bd;
	font-weight: normal;
}

/* line 190, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-writer-nickname a {
	color: #212529;
	text-decoration: none;
}

/* line 194, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-writer-nickname a:hover {
	text-decoration: underline;
}
</style>

<style type="text/css">

/* Header */
header {
	background-color: #FFF;
}

.r_menu a {
	text-decoration: none;
	color: black;
}

.r_menu a:hover {
	color: #23dbc9;
}

.btn_radius {
	border-radius: 1.5em;
}
</style>
</head>


<body>
	<!-- ===========header================ -->
	<header class="border-bottom border-white">
		<div class="container">
			<div class="row align-items-start p-3">	
				<div class="col mb-4">
					<a href="getBoardList.do"><img src="/img/test.png"
						alt="logo" width=70px height=70px></a>
				</div>
				
					<c:if test="${ sessionScope.user.getNickname() == null }">
					   <div class="col mt-3 text-end r_menu">
						 <span class=mx-2><a href="index.jsp" style="text-decoration:none" class="text-dark">로그인</a> </span> 
					   </div>
					</c:if> 
										
					<c:if test="${ sessionScope.user.getNickname() != null }">			
					 <div class="col mt-3 text-end r_menu">
					    <span class=mx-2><a href="#" style="text-decoration:none" class="text-dark">좋아요</a></span> 
					    
					   <c:if test="${ !sessionScope.isAdmin }">
						<span class=mx-1><a href="getUserList.do" style="text-decoration:none" class="text-dark">마이페이지</a></span>
						</c:if>
						<c:if test="${sessionScope.isAdmin }">
						<span class=mx-1><a href="user/adminpage.jsp" style="text-decoration:none" class="text-dark">관리자페이지</a></span>
						</c:if>
						
						<span class=mx-1><a href="location/infoVilli.jsp" style="text-decoration:none" class="text-dark">동네정보</a></span>  
						<span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				     </div>							
				   </c:if>
			</div>
		</div>
	</header>
	<!------------------ 본문 --------------------->
	<div class="container w-50 mt-4">
		<h3 class="fw-bold">${ user.nickname }</h3>
		<span> ${ user.address } </span>
		<hr />
		<section id="content">
			<label for="inputProfile" class="mt-3">* 프로필 사진</label>
			<div class="col-2 input-group mb-3 mt-2">

				<c:if test="${ !empty  user.fileName}">
					<img src="/img/${ user.fileName }"
						class="rounded-circle border border-dark" width="80" height="80"
						alt="img">
				</c:if>
				<c:if test="${ empty  user.fileName}">
					<img src="/img/noimg.png"
						class="rounded-circle border border-dark" width="80" height="80"
						alt="img">
				</c:if>
			</div>
			
			
			<!-- 거래 후기 목록 -->
			<div id="user-records-detail">
				<section id="user-filter">
					<ul>
						<li><a class="active" href="getUser.do?nickname=${ user.nickname }">등록 게시물 </a></li>
						<li><a class="" href="../user/getUser.jsp">거래 후기</a></li>
						<li><a class="ReportList" href="">신고</a></li>
					</ul>
				</section>
			</div>
			<div class="container mt-1">
				<div class="row">
					<c:forEach items="${MyboardList}" var="MyboardList">
						<div class="col-12 col-md-6 col-lg-4 mt-2">
							<div class="card">
								<span class="border border-dark"> <a
									href="updateBoard.do?seq=${MyboardList.getSeq()}"
									class="link-dark" style="text-decoration: none"> <img
										class="card-img-top" width="450" height="250"
										src="/img/${ MyboardList.fileName1 }" alt="image"></a></span>
								<div class="card-body">

									<!-- 글자수 넘칠 경우 자르기 -->
									<h6 class="card-title fw-bold">
										<c:choose>
											<c:when test="${fn:length(MyboardList.title) > 19}">
												<c:out value="${fn:substring(MyboardList.title,0,18)}" />....
           </c:when>
											<c:otherwise>
												<c:out value="${MyboardList.title}" />
											</c:otherwise>
										</c:choose>

										<!-- status 따라서 버튼 색상 변경 -->
										<c:choose>
											<c:when test="${MyboardList.status eq '대기중'}">
												<span class="badge bg-success text-white rounded-pill">${MyboardList.status}</span>
											</c:when>
											<c:when test="${MyboardList.status eq '예약중'}">
												<span class="badge bg-warning text-white rounded-pill">${MyboardList.status}</span>
											</c:when>
											<c:when test="${MyboardList.status eq '대여중'}">
												<span class="badge bg-danger text-white rounded-pill">${MyboardList.status}</span>
											</c:when>
										</c:choose>
									</h6>
									<div class="fw-bold">
										<c:if test="${ !empty  MyboardList.price}">
											<span>${ MyboardList.price }원</span>
										</c:if>
										<c:if test="${ empty  MyboardList.price}">
											<span>가격협의</span>
										</c:if>

									</div>
									<div>
										<c:if test="${ !empty  MyboardList.usedate}">
											<span>${ MyboardList.usedate } ~ ${ MyboardList.duedate }</span>
										</c:if>
										<c:if test="${ empty  MyboardList.usedate}">
											<span>날짜상의</span>
										</c:if>
									</div>
									<div class="mt-3">작성자 : ${ MyboardList.nickname }</div>
									<div class="text-muted">위치</div>
									<p class="card-mtext">


										<svg xmlns="http://www.w3.org/2000/svg" width="13" height="13"
											fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
  <path
												d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
</svg>
										${ MyboardList.like_cnt }

										<svg xmlns="http://www.w3.org/2000/svg" width="13" height="13"
											fill="currentColor" class="bi bi-chat-square-dots"
											viewBox="0 0 16 16">
  <path
												d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
  <path
												d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0
z" />
</svg>
										${ MyboardList.cnt }
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</div>

	<script>
		$(function() {
			
				
			$('.ReportList').click(function() {
		        var form = {
		                email : "admin@gmail.com"
		        }	
		        $.ajax({
		            url: "good.do",
		            type: "POST",
		            data: form,
		            success: function(data){
		                $('#result').text(data);
		            },
		            error: function(){
		                alert("ajax 에러!!!!!!!!");
		            }
		        });		        				
			}); 
		})
	</script>
	

</body>
</html>
