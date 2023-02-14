<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>신고게시판</title>
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

nav {
	background-color: #FFFAFA;
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
<!-- ===========header================ -->
	<header class="border-bottom border-white">
		<div class="container">
			<div class="row align-items-start p-3">


				<div class="col mb-4">
					<a href="getBoardList.do"><img src="/img/test.png" alt="logo"
						width=70px height=70px></a>
				</div>

				<c:if test="${ sessionScope.user.getNickname() == null }">
					<div class="col mt-3 text-end r_menu">
						<span class=mx-2><a href="index.jsp"
							style="text-decoration: none" class="text-dark">로그인</a> </span>
					</div>
				</c:if>

				<c:if test="${ sessionScope.user.getNickname() != null }">
					<div class="col mt-3 text-end r_menu">

						<c:if test="${ !sessionScope.isAdmin }">
							<span class=mx-2><a href="getUserList.do"
								style="text-decoration: none" class="text-dark">마이페이지</a></span>
						</c:if>
						<c:if test="${sessionScope.isAdmin }">
							<span class=mx-2><a href="user/adminpage.jsp"
								style="text-decoration: none" class="text-dark">관리자페이지</a></span>
						</c:if>

						<span class=mx-1><a href="location/infoVilli.jsp"
							style="text-decoration: none" class="text-dark">동네정보</a></span> <span
							class="mx-2">${ sessionScope.user.getNickname() }님</span>
					</div>
				</c:if>
			</div>
		</div>
	</header>

	<!-- ======================LIST========================= -->

	<div class="container mt-3">
		<div class="row mt-4">
			<table class="table table-hover table-bordered">
				<thead class="table-dark">
					<th scope="col">글번호</th>
					<th scope="col">신고이유</th>
					<th scope="col">처리여부</th>
					<th scope="col">신고한대상</th>
					<th scope="col">처리시간</th>
					<th scope="col">작성시간</th>
	
				</thead>
				<tbody>
					<c:forEach var="reportList" items="${ reportList }">
						<tr>
						   	<td><a href="updateReport.do?seq=${reportList.seq}"
								style="text-decoration: none">${ reportList.seq }</a></td>
							<td>${ reportList.r_rs1 }</td>
							<td>${ reportList.r_status }</td>
							<td>${ reportList.nickname }</td>
							<td>${ reportList.r_etime }</td>
							<td>${ reportList.r_time }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<!-- =======================LIST 끝========================== -->
	<div class="row align-items-start mt-3">
		<ul class="col pagination justify-content-center">

			<c:set var="cp" value="${searchVO.getCurPage()}" />
			<c:set var="rp" value="${searchVO.getRowSizePerPage()}" />
			<c:set var="fp" value="${searchVO.getFirstPage()}" />
			<c:set var="lp" value="${searchVO.getLastPage()}" />
			<c:set var="ps" value="${searchVO.getPageSize()}" />
			<c:set var="tp" value="${searchVO.getTotalPageCount()}" />
			<c:set var="sc" value="${searchVO.getSearchCategory()}" />
			<c:set var="st" value="${searchVO.getSearchType()}" />
			<c:set var="sw" value="${searchVO.getSearchWord()}" />

			<c:if test="${ fp != 1 }">
				<li class="page-item"><a
					href="getReportList.do?curPage=1&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
					class="page-link"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item"><a
					href="getReportList.do?curPage=${fp-1}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
					class="page-link"><i class="fas fa-backward"></i></a></li>
			</c:if>

			<c:forEach var="page" begin="${fp}" end="${lp}">
				<li class="page-item ${cp==page ? 'active' : ''}"><a
					href="getReportList.do?curPage=${page}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
					class="page-link">${page}</a></li>
			</c:forEach>

			<c:if test="${ lp < tp }">
				<li class="page-item"><a
					href="getReportList.do?curPage=${lp+ps}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
					class="page-link"><i class="fas fa-forward"></i></a></li>
				<li class="page-item"><a
					href="getReportList.do?curPage=${tp}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
					class="page-link"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
		</ul>
		<!-- pagination -->


		<!-- rowSizePerPage -->
	</div>
	<!-- 페이징 -->



</body>
</html>