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
</style>
<!-- ============search=============== -->
	<nav class="border-bottom border-dark sticky-top z-index-10">
		<div class="container" align="center">
			<div class="row p-3">
				<div class="col">

					<nav class="navbar navbar-expand-lg navbar-light">
						<div class="container-fluid">
							<a class="navbar-brand" href="../getBoardList.do">Villi</a>
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
										<!-- ================글작성버튼============= -->
										<div class="dropdown">
											<button class="btn dropdown-toggle" type="button"
												id="dropdownMenuButton2" data-bs-toggle="dropdown"
												aria-expanded="false">글작성</button>
											<ul class="dropdown-menu dropdown-menu-dark"
												aria-labelledby="dropdownMenuButton2">
												<li><a class="dropdown-item active" href="#">상품</a></li>
												<li><a class="dropdown-item" href="board_sinsert.jsp">서비스</a></li>
												<li><a class="dropdown-item" href="../dongnae/dongnae_main.jsp">동네생활</a></li>
											</ul>
										</div>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="../getQuestionList.do">우리동네질문</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="../getLostList.do">동네분실센터</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="../getMeetingList.do">동네모임</a></li>
									<li class="nav-item"><a class="nav-link"
										href="getVoteList.do">동네투표</a></li>
								</ul>
								<form action="getBoardList.do" method="post" id="boardForm">
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
												<input class="form-control" name="searchWord" type="text" />
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
	<!-- 이미지 -->
	<div class="container-lg">
		<div class="p-3 " align="center">
			<!-- 이미지 -->
			<div id="carouselExampleIndicators"
				class="carousel carousel-dark slide" data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="3" aria-label="Slide 4"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="4" aria-label="Slide 5"></button>
				</div>


				<div class="carousel-inner">

					<div
						class="carousel-item active embed-responsive embed-responsive-4by3"
						data-bs-interval="10000">
						<c:if test="${ !empty  board.fileName1}">
							<img src="resources/images/${ board.fileName1 }"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
						<c:if test="${ empty  board.fileName1}">
							<img src="resources/images/noimg.png"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3"
						data-bs-interval="2000">
						<c:if test="${ !empty  board.fileName2}">
							<img src="resources/images/${ board.fileName2 }"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
						<c:if test="${ empty  board.fileName2}">
							<img src="resources/images/noimg.png"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3">
						<c:if test="${ !empty  board.fileName3}">
							<img src="resources/images/${ board.fileName3 }"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
						<c:if test="${ empty  board.fileName3}">
							<img src="resources/images/noimg.png"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
					</div>



					<div class="carousel-item embed-responsive embed-responsive-4by3">
						<c:if test="${ !empty  board.fileName4}">
							<img src="resources/images/${ board.fileName4}"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
						<c:if test="${ empty  board.fileName4}">
							<img src="resources/images/noimg.png"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3">
						<c:if test="${ !empty  board.fileName5}">
							<img src="resources/images/${ board.fileName5}"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
						<c:if test="${ empty  board.fileName5}">
							<img src="resources/images/noimg.png"
								class="d-block w-50 card-img-top embed-responsive-item"
								alt="img" width="500" height="500">
						</c:if>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- form -->
	<div class="container" align="center">
		<form action="updateBoard.do" method="post">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-start">
						<img src="resources/images/noimg.png"
							class="rounded-circle border border-dark" alt="img" width="75"
							height="75"> <span class="col-md-auto text-success fw-bold">
							${board.status} </span> <span>${ board.writer }</span> <span
							class="fs-5"><i class="bi bi-award text-warning"></i></span>

						<!-- 	   <p class="fs-4 bg-secondary text-end">대여중</p>    -->
					</h5>

				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item text-start"><p class="fs-3 fw-bold">(${ board.cate })${ board.title }</p>
						<p class="fs-6 fst-italic">${ board.cate2 }· ${board.regDate}</p>
						<br>
					<br>
					<br>
						<p class="fs-3 mt-4">${ board.content }</p> <br>
					<br>
					<br>
						<p class="mt-4">조회 : ${ board.cnt }</p></li>
					<li class="list-group-item text-start"><a
						href="report/report_insert.jsp" class="btn btn-danger">이 게시글
							신고하기</a></li>
				</ul>
				<div class="card-body">
					<!-- 		    <input type="submit" class="btn btn-primary" value="글수정" /> -->
					<!-- 		<a href="board/board_insert.jsp" class="btn btn-primary">글등록</a> -->
					<!-- 			<a href="getBoardList.do" class="btn btn-primary">글목록</a> -->
					<!-- 			<a href="#" class="btn btn-danger"  onclick="deleteBoard()">글삭제</a> -->

					<div class="row">
						<div class="col-4 text-start">
							<span class="fs-4 mx-3"><i class="bi bi-heart-fill text-danger"> </i></span>
							
							<span class="fs-5">${ board.price }₩</span>
						</div>
						<div class="col-8 text-end">
							<a href="#" class="btn boarder border-dark fs-4 fw-bold">채팅하기</a>
						</div>
					</div>
					<!--          <div class="col text-end" align="center">   -->
					<!--          	     <span class="fs-5"><i class="bi bi-heart-fill text-danger"></i></span> -->
					<%--          	     <span class="fs-5">${ board.price }₩</span> --%>
					<!-- 		   <a href="#" class="btn boarder border-dark fs-4 fw-bold"">채팅하기</a> -->
					<!-- 		 </div> -->
				</div>
			</div>
		</form>
	</div>


	<!-- 삭제시 confirm -->
	<script>
		function deleteBoard() {
			if(confirm("자료를 삭제하겠습니까?")) {
		    	self.location.href = "deleteBoard.do?seq=${ board.seq }";
		    }
		}
	</script>
</body>
</html>
