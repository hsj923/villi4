<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>동네분실센터</title>
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
	<!-- ============search=============== -->
	<nav class="border-bottom border-dark sticky-top z-index-10">
		<div class="container" align="center">
			<div class="row p-3">
				<div class="col">

					<nav class="navbar navbar-expand-lg navbar-light">
						<div class="container-fluid">
							<a class="navbar-brand" href="getBoardList.do">Villi</a>
							<button class="navbar-toggler" type="button"
								data-bs-toggle="collapse"
								data-bs-target="#navbarSupportedContent"
								aria-controls="navbarSupportedContent" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<!--================ nav bar ===================-->
							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav me-auto mb-2 mb-lg-0">
									<li class="nav-item">
										<!-- ================글작성버튼, 로그인============= --> <c:if
											test="${ sessionScope.user.getNickname() == null }">
											<a class="nav-link active" aria-current="page"
												href="index.jsp">로그인</a>
										</c:if> <c:if test="${ sessionScope.user.getNickname() != null }">
											<a class="nav-link active" aria-current="page"
												href="lost/insertLost.jsp">글작성</a>
										</c:if>
									</li>

									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getQuestionList.do">동네질문</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getLostList.do">분실센터</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getMeetingList.do">동네모임</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getVoteList.do">동네투표</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getDemandList.do">빌리요청</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getGroupBuyingList.do">공동구매</a></li>
								</ul>
								<form action="getLostList.do" method="post" id="lostForm">
									<input type="hidden" id="curPage" name="curPage"
										value="${searchVO.getCurPage()}"> <input type="hidden"
										id="rowSizePerPage" name="rowSizePerPage"
										value="${searchVO.getRowSizePerPage()}">
									<div class="container">
										<div class="row justify-content-md">
											<div class="col-md-auto">

												<select class="form-select" id="searchType"
													name="searchType">
													<option value="">검색</option>
													<option value="title"
														${searchVO.getSearchType()=="title" ? "selected" : ""}>제목</option>
													<option value="writer"
														${searchVO.getSearchType()=="writer" ? "selected" : "" }>작성자</option>
													<option value="cate2"
														${searchVO.getSearchType()=="cate2" ? "selected" : ""}>카테고리</option>
												</select>
											</div>
											<div class="col col-lg-6">
												<input class="form-control" name="searchWord" type="text"
													placeholder="${searchVO.getCurPage()}of ${searchVO.getTotalRowCount()}" />
											</div>
											<div class="col col-lg-2">
												<button class="btn btn-outline-success" type="submit">Search</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</nav>
	<!-- =========상품보기=============== -->
	<!-- ======================LIST========================= -->

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
					<c:forEach var="lost" items="${ lostList }">
						<tr>
							<td><a href="updateLost.do?seq=${lost.getSeq()}"
								style="text-decoration: none">${ lost.seq }</a></td>
							<td>${ lost.title }</td>
							<td>${ lost.content }</td>
							<td>${ lost.regDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>



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
							href="getLostList.do?curPage=1&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
							class="page-link"><i class="fas fa-fast-backward"></i></a></li>
						<li class="page-item"><a
							href="getLostList.do?curPage=${fp-1}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
							class="page-link"><i class="fas fa-backward"></i></a></li>
					</c:if>

					<c:forEach var="page" begin="${fp}" end="${lp}">
						<li class="page-item ${cp==page ? 'active' : ''}"><a
							href="getLostList.do?curPage=${page}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
							class="page-link">${page}</a></li>
					</c:forEach>

					<c:if test="${ lp < tp }">
						<li class="page-item"><a
							href="getLostList.do?curPage=${lp+ps}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
							class="page-link"><i class="fas fa-forward"></i></a></li>
						<li class="page-item"><a
							href="getLostList.do?curPage=${tp}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
							class="page-link"><i class="fas fa-fast-forward"></i></a></li>
					</c:if>
				</ul>
				<!-- pagination -->
			</div>
		</div>
	</div>

</body>
</html>