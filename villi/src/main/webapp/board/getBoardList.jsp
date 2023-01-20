<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Framework</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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

header {
	background-color: #FFFAFA;
}

nav {
	background-color: #FFFAFA;
}

#banner2 {
	background-color: #ebecf0;
}

#banner img {
	width: 100%;
	height: 650px;
	object-fit: cover;
}

.r_menu a {
	text-decoration: none;
	color: black;
	.
	card
	{
	margin-bottom
	:
	1rem;
}

.card-mtext {width =10px;height =10px;
	
}
</style>
</head>
<body>
	<div>
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
						<a href="#">좋아요</a> <span class="mx-4"> <a
							href="getUserList.do">마이페이지</a></span> <span>
					</div>
				</div>
			</div>
		</header>
		<!-- ============banner=============== -->

		<div id="carouselExampleControls"
			class="carousel carousel-dark slide border-bottom border-dark"
			data-bs-ride="carousel" align="center">

			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleControls"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleControls"
					data-bs-slide-to="1" aria-label="Slide 2"></button>

			</div>
			<div class="carousel-inner">
				<div
					class="carousel-item active embed-responsive embed-responsive-4by3"
					id="banner">
					<img src="resources/images/banner1.JPG"
						class="d-block w-100 card-img-top embed-responsive-item"
						alt="banner1">
				</div>
				<div class="carousel-item embed-responsive embed-responsive-4by3"
					id="banner">
					<img src="resources/images/banner2.JPG"
						class="d-block w-100 card-img-top embed-responsive-item"
						alt="banner2">
				</div>
			</div>

			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>

		</div>

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
								<div class="collapse navbar-collapse"
									id="navbarSupportedContent">
									<ul class="navbar-nav me-auto mb-2 mb-lg-0">
										<li class="nav-item">
											<!-- ================글작성버튼============= -->
											<div class="dropdown">
												<button class="btn dropdown-toggle" type="button"
													id="dropdownMenuButton2" data-bs-toggle="dropdown"
													aria-expanded="false">글작성</button>
												<ul class="dropdown-menu dropdown-menu-dark"
													aria-labelledby="dropdownMenuButton2">
													<li><a class="dropdown-item"
														href="board/insertBoard.jsp">상품</a></li>
													<li><a class="dropdown-item"
														href="board/insertServiceBoard.jsp">서비스</a></li>
												</ul>
											</div>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="getQuestionList.do">우리동네질문</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="getLostList.do">동네분실센터</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="getMeetingList.do">동네모임</a></li>
										<li class="nav-item"><a class="nav-link"
											href="getVoteList.do">동네투표</a></li>
										<li class="nav-item"><a class="nav-link"
											href="getWantBoardList.do">빌리요청</a></li>
									</ul>
									<form action="getBoardList.do" method="post" id="boardForm">
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
		<!-- getBoardList.do -->

		<!-- =========상품보기=============== -->
		<!-- ======================LIST========================= -->

		<div class="container grid-container">
			<div class="row">
				<c:forEach items="${boardList}" var="board">
					<div class="col-12 col-md-6 col-lg-3 mt-5">
						<div class="card">
							<a href="updateBoard.do?seq=${board.getSeq()}" class="link-dark"
								style="text-decoration: none"><img class="card-img-top"
								src="resources/images/${ board.fileName1 }" alt="image"></a>
							<div class="card-body">
								<h6 class="card-title fw-bold">${board.title}</h6>
								<p class="card-text">


									<c:choose>
										<c:when test="${board.status eq '대기중'}">
											<span class="card-text bg-success text-white fs-6">${board.status}</span>
										</c:when>
										<c:when test="${board.status eq '예약중'}">
											<span class="card-text bg-warning text-white fs-6">${board.status}</span>
											</c:when>
										<c:when test="${board.status eq '대여중'}">
											<span class="card-text bg-danger text-white fs-6">${board.status}</span>
											</c:when>
									</c:choose>					
									<c:if test="${ !empty  board.price}">
										<span>${ board.price }원</span>
									</c:if>
									<c:if test="${ empty  board.price}">
										<span>가격협의</span>
									</c:if>


									<%-- 									<span class="card-text bg-success text-white fs-6">${board.status}</span> --%>
									<%-- 									${ board.price } --%>
								</p>
								<p class="card-text">대충위지자리</p>
								<p class="card-mtext">
									<svg xmlns="http://www.w3.org/2000/svg" width="13" height="13"
										fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
  <path
											d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
</svg>
									${board.cnt}
									<svg xmlns="http://www.w3.org/2000/svg" width="13" height="13"
										fill="currentColor" class="bi bi-chat-square-dots"
										viewBox="0 0 16 16">
  <path
											d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
  <path
											d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
</svg>
									10
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- 게시판 -->

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
						href="getBoardList.do?curPage=1&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
						class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a
						href="getBoardList.do?curPage=${fp-1}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
						class="page-link"><i class="fas fa-backward"></i></a></li>
				</c:if>

				<c:forEach var="page" begin="${fp}" end="${lp}">
					<li class="page-item ${cp==page ? 'active' : ''}"><a
						href="getBoardList.do?curPage=${page}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
						class="page-link">${page}</a></li>
				</c:forEach>

				<c:if test="${ lp < tp }">
					<li class="page-item"><a
						href="getBoardList.do?curPage=${lp+ps}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
						class="page-link"><i class="fas fa-forward"></i></a></li>
					<li class="page-item"><a
						href="getBoardList.do?curPage=${tp}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}"
						class="page-link"><i class="fas fa-fast-forward"></i></a></li>
				</c:if>
			</ul>
			<!-- pagination -->

			<div class="col-auto me-1">
				<div class="input-group mb-3">
					<span class="input-group-text"><i class="fas fa-list"></i></span> <select
						class="col-auto form-select" id="rowPerPage" name="rowPerPage">
						<option value="10" ${ rp == 10 ? "selected" : "" }>10</option>
						<option value="20" ${ rp == 20 ? "selected" : "" }>20</option>
						<option value="40" ${ rp == 40 ? "selected" : "" }>40</option>
						<option value="60" ${ rp == 60 ? "selected" : "" }>60</option>
					</select>
				</div>
			</div>
			<!-- rowSizePerPage -->
		</div>
		<!-- 페이징 -->
	</div>
	<!-- main  -->


	<script>
		$(function() {

			// 목록 갯수 변경
			$('#rowPerPage').change(function(e) {
				$('#curPage').val(1);
				$('#rowSizePerPage').val($(this).val());
				$('#boardForm').submit();
			}); //#rowPerPage

			// 초기화 버튼 클릭
			$('#btnReset').click(
					function() {
						$('#curPage').val(1);
						$('#boardForm').find(
								"select[name='searchCategory'] option:eq(0)")
								.attr("selected", "selected");
						$('#boardForm').find(
								"select[name='searchType'] option:eq(0)").attr(
								"selected", "selected");
						$('#boardForm').find("input[name='searchWord']")
								.val("");
						$('#boardForm').submit();
					}); // #id_btn_reset.cli			

		})
	</script>

</body>
</html>
