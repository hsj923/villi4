<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세보기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
.bi-heart {
	font-size: 30px;
	line-height: 30px;
	color: crimson;
}

.bi-heart-fill {
	font-size: 30px;
	line-height: 30px;
	color: crimson;
}


.navbar-light .navbar-nav .nav-link {
  color: rgba(0, 0, 0, 0.5);
  border-bottom: .15rem solid transparent;
}
.navbar-light .navbar-nav .nav-link:hover, .navbar-light .navbar-nav .nav-link:focus {
  color: rgba(0, 0, 0, 0.7);
  border-bottom-color: rgba(0, 0, 0, 0.7);
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
									<li class="nav-item"><!-- ================글작성버튼, 로그인============= --> <c:if
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
										<li class="nav-item"><a class="nav-link text-dark fw-bold"
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



<!-- form -->
	<div class="container mt-3" align="center">
		<form action="updateLost.do" method="post">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-start">
						<img  src="/img/noimg.png" 
							class="rounded-circle border border-dark" alt="img" width="75"
							height="75"><span>${lost.writer }</span> <span
							class="fs-5"><i class="bi bi-award text-warning"></i></span>

					</h5>

				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item text-start">
		<div class="row">
							<div class="col-4 text-start">
								<span class="fs-4 fw-bold">${ lost.title }</span>
							</div>
							<div class="col-8 text-end">
								<p class="fs-6 fst-italic 	text-decoration-underline">${lost.regDate}</p>
							</div>
						</div>
							<br><br>
							<p class="text-muted fs-5">${ lost.content }</p>	
	      <!-- 이미지 -->
	<div class="container w-100">
		<div class="p-3 " align="center">		

			<div id="carouselExampleIndicators"
				class="carousel carousel-dark slide" data-bs-ride="carousel">
				<div class="carousel-indicators">
				<c:if test="${ !empty  lost.fileName2}">
							<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</c:if>
					
					<!-- 					<button type="button" data-bs-target="#carouselExampleIndicators" -->
					<!-- 						data-bs-slide-to="3" aria-label="Slide 4"></button> -->
					<!-- 					<button type="button" data-bs-target="#carouselExampleIndicators" -->
					<!-- 						data-bs-slide-to="4" aria-label="Slide 5"></button> -->
				</div>


				<div class="carousel-inner">

					<div
						class="carousel-item active embed-responsive embed-responsive-4by3"
						id="fileimg">
						<c:if test="${ !empty  lost.fileName1}">
							<img src="/img/${ lost.fileName1 }"
								class="rounded mx-auto d-block w-75"
								alt="img">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3"
						id="fileimg">
						<c:if test="${ !empty  lost.fileName2}">
							<img src="/img/${ lost.fileName2 }"
								class="rounded mx-auto d-block w-75"
								alt="img">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3"
						id="fileimg">
						<c:if test="${ !empty  lost.fileName3}">
							<img src="/img/${ lost.fileName3 }"
								class="rounded mx-auto d-block w-75"
								alt="img">
						</c:if>

					</div>



				</div>

			</div>
		</div>
	</div>
					
													
						 <br> <br> <br>
						<p class="mt-4">조회 : ${ lost.cnt }</p></li>
				</ul>
				<div class="card-body">
					<div class="row">
						<div class="col-4 text-start">
								<span class="fs-4 mx-3"><i class="bi bi-heart fs-5"></i></span>
						</div>
						<div class="col-8 text-end">
							<a href="#" class="btn ps-6 text-white rounded-pill"
								style="background-color: #72CCD2;">채팅하기</a>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<c:if test="${ sessionScope.user.getNickname() != lost.writer }">
			<div class="container row-3" align="center">
			<a href="getLostList.do"
					class="btn btn-dark my-5 mx-4">게시글목록</a>
			</div>
		</c:if>
		<c:if test="${ sessionScope.user.getNickname() == lost.writer }">
			<div class="container row-3" align="center">
				<input type="submit" class="btn btn-dark my-5 mx-4" value="게시글수정" />
				<a href="deleteLost.do?seq=${lost.getSeq()}"
					class="btn btn-dark my-5 mx-2">게시글삭제</a> <a href="getLostList.do"
					class="btn btn-dark my-5 mx-4">게시글목록</a>
			</div>
		</c:if>
	</div>


	<script>
		var i = 0;
		$('.bi-heart').on('click', function() {
			if (i == 0) {
				$(this).removeClass('bi-heart');
				$(this).addClass('bi-heart-fill');
				i++;
			} else if (i == 1) {
				$(this).removeClass('bi-heart-fill');
				$(this).addClass('bi-heart');
				i--;
			}
		});
	</script>

</body>