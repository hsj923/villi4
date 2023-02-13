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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	background-color: #FFF;
}

nav {
	background-color: #fcfcfc;
}

.trust-image-01 {
	background-image:
		url(https://d1unjqcospf8gs.cloudfront.net/assets/home/trust/3x/img-trust-1-08564a68dc6a07f9f05a35b2308a288ace19158318c3412960a257b4ffa2d9f8.png);
}

#fileimg img {
	height: 600px;
	object-fit: fill;
}

a {
	text-decoration: none
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
										</c:if>
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
													<option value="nickname"
														${searchVO.getSearchType()=="nickname" ? "selected" : "" }>작성자</option>
													<option value="cate2"
														${searchVO.getSearchType()=="cate2" ? "selected" : ""}>카테고리</option>
												</select>
											</div>
											<div class="col col-lg-6">
												<input class="form-control" name="searchWord" type="text"
													placeholder="${searchVO.getCurPage()}of ${searchVO.getTotalRowCount()}" />
											</div>
												<div class="col col-lg-2">
												<button class="btn text-white "
													style="background-color: #72CCD2;" type="submit">Search</button>
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
	<div class="container w-50">
		<div class="py-3 " align="center">

			<div id="carouselExampleIndicators"
				class="carousel carousel-dark slide" data-bs-ride="carousel">
				<div class="carousel-indicators">

					<c:if test="${ !empty  board.fileName2 and empty board.fileName3}">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
					</c:if>
					<c:if test="${ !empty  board.fileName3}">
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
						<c:if test="${ !empty  board.fileName1}">
							<img src="/img/${ board.fileName1 }"
								class="d-block w-100 card-img-top embed-responsive-item"
								alt="img">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3"
						id="fileimg">
						<c:if test="${ !empty  board.fileName2}">
							<img src="/img/${ board.fileName2 }"
								class="d-block w-100 card-img-top embed-responsive-item rounded-3"
								alt="img">
						</c:if>
					</div>


					<div class="carousel-item embed-responsive embed-responsive-4by3"
						id="fileimg">
						<c:if test="${ !empty  board.fileName3}">
							<img src="/img/${ board.fileName3 }"
								class="d-block w-100 card-img-top embed-responsive-item rounded-3"
								alt="img">
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- form -->
	<div class="container w-50" align="center">
		<form action="updateBoard.do" method="post">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-start">
						<a href="getUser.do?nickname=${ board.nickname }"
							style="text-decoration: none" class="text-dark">
<%-- 							<img src="/img/${ user.fileName }" class="rounded-circle border border-dark" alt="img" width="75" height="75">  --%>
                                    
							<span>작성자 : ${ board.nickname }</span> <span
							class="fs-5"></span></a>
					</h5>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item text-start">
						<div class="row">
							<div class="col-4 text-start">
								<span class="fs-4 fw-bold">${ board.title }</span>
								<c:choose>
									<c:when test="${board.status eq '대기중'}">
										<span class="badge bg-success text-white rounded-pill">${board.status}</span>
									</c:when>
									<c:when test="${board.status eq '예약중'}">
										<span class="badge bg-warning text-white rounded-pill">${board.status}</span>
									</c:when>
									<c:when test="${board.status eq '대여중'}">
										<span class="badge bg-danger text-white rounded-pill">${board.status}</span>
									</c:when>
								</c:choose>
							</div>
							<div class="col-8 text-end">
								<p class="fs-6 fst-italic 	text-decoration-underline">${board.regDate}</p>
							</div>
						</div>
						<p class="fs-6 fst-italic 	text-decoration-underline">${ board.cate2 }</p>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-calendar-check"
							viewBox="0 0 16 16">
  <path
								d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
  <path
								d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
</svg> <c:if test="${ !empty  board.usedate}">
							<span class="fs-6 ms-2">대여가능일 : ${ board.usedate } ~ ${ board.duedate }
							</span>
							<br>
						</c:if> <c:if test="${ empty  board.usedate}">
							<span>날짜상의</span>
						</c:if> <br> <br>
						<p class="fs-5">${ board.content }</p> <br> <br> <br>
						<p class="mt-4">조회 : ${ board.cnt }</p>
					</li>
<!-- 					<li class="list-group-item text-end "><a -->
<!-- 						href="report/insertReport.jsp" class="stretched-link text-danger">이 -->
<!-- 							게시글 신고하기</a></li> -->
				</ul>
				<div class="card-body">
					<div class="row">
						<div class="col-4 text-start">
							<c:if test="${ !empty  board.price}">
								<span class="fs-4 mx-3"> <i class="bi bi-heart fs-5"></i></span>
								<span class="fs-5">${ board.price }원</span>
							</c:if>
							<c:if test="${ empty  board.price}">
								<span class="fs-4 mx-3"><i class="bi bi-heart fs-5"></i></span>
								<span class="fs-5">가격협의</span>
							</c:if>
						</div>
						<div class="col-8 text-end">
							<a href="getChatList.do" class="btn ps-6 text-white rounded-pill"
								style="background-color: #72CCD2;">채팅하기</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<!-- 삭제시 confirm -->
	<script>
		function deleteBoard() {
			if (confirm("자료를 삭제하겠습니까?")) {
				self.location.href = "deleteBoard.do?seq=${ board.seq }";
			}
		}
		
		<!-- ======================좋아요 02-06 update중================= -->
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


	<!-- 안전거래 -->
	<div class="container w-50" align="center">
		<section class="home-main-section " id="section1">
			<h2 class="main-title text-center my-5 fw-bold">
				잠깐! 빌리는 안전하고 신뢰할 수 있는 거래를 지향합니다 <br>안전수칙을 확인해주세요
			</h2>
			<div class="container">
				<div class="row">
					<div class="col">
						<img class="img-fluid" alt="동네인증거래"
							src="/img/img-trust-1.png">
					</div>
					<div class="col align-self-center">
						<h2 class="home-main-title fw-bold">동네인증한 사용자만 거래해요</h2>
						<p class="text-m">빌리에서 거래하려면 동네인증이 필요해요. 동네인증은 설정한 동네에 있어야만 할
							수 있어요. GPS를 이용하여 우리 동네를 인증한 진짜 이웃들과 거래하세요. 거래하려는 상대방의 인증 횟수를 보면
							얼마나 자주 이 동네에서 사용했는지 알 수 있어요.</p>

						<div class="home-buttons">
							<p>
								<a target="_blank"
									class="block text-m text-carrot text-no-decoration mt-3"
									href="https://www.consumer.go.kr/user/bbs/consumer/120/461/bbsDataView/2730.do">
									<span class="text-info">직거래 사기예방 수칙</span>
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- 채팅거래 -->
		<section class="home-main-section1" id="section2">
			<div class="container">
				<div class="row">
					<div class="col align-self-center">
						<div class="col mt-3 text-end r_menu">
							<h2 class="home-main-title fw-bold">1:1 빌리채팅으로 대화해요</h2>
							<p>빌리 내의 채팅을 통해 거래하는 게 가장 안전해요. 개인정보 공유 없이도 쉽고 편하게 거래할 수 있어요.
								1:1 채팅으로 약속을 잡고 만나서 거래하세요. 채팅 내의 약속 알림을 설정하면 약속 시간 전에 알림을 받을 수
								있어요.</p>
						</div>
					</div>
					<div class="col">
						<img class="img-fluid" alt="이웃과의 거래, 동네생활 질문글과 동네가게"
							src="/img/img-trust-2.png">
					</div>
				</div>
			</div>
		</section>




		<!-- 동네거래 -->


		<section class="home-main-section" id="section1">
			<div class="container">
				<div class="row">
					<div class="col">
						<img class="img-fluid" alt="동네거래"
							src="/img/img-trust-3.png">
					</div>
					<div class="col align-self-center">
						<h2 class="home-main-title fw-bold">근처에서 만나서 거래해요</h2>
						<p class="text-m">중고거래 사기의 대부분은 택배거래에서 발생한다는 사실, 알고 계셨나요?
							빌리에서는 택배거래보다 직거래를 권장해요. 만나서 거래할 때는 누구나 찾기 쉽고 안전한 공공장소가 좋아요. 빌리에서
							가까운 이웃과 따뜻하게 거래하세요.</p>
						<div class="home-buttons">
							<p>
								<a target="_blank"
									class="block text-m text-carrot text-no-decoration mt-3"
									href="https://ncv.kdca.go.kr/menu.es?mid=a30200000000"> <span
									class="text-info">코로나19 예방 수칙</span>
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<c:if test="${ sessionScope.user.getName() != board.nickname }">
			<div class="container row-3" align="center">
				<a href="getBoardList.do" class="btn btn-dark my-5 mx-4">게시글목록</a>
			</div>
		</c:if>
		<c:if test="${ sessionScope.user.getName() ==  board.nickname}">

			<div class="container mt-3" align="center">
				<form action="updateBoard.do" method="post">
					<input name="seq" type="hidden" value="${board.seq}" />
					<div class="input-group mb-3">
						<span class="input-group-text" id="desc_title"><i
							class="fas fa-address-book"></i></span> <input type="text"
							class="form-control" name="title" value="${ board.title }">
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="desc_title"><i
							class="fas fa-user"></i></span> <input type="text" class="form-control"
							name="nickname" value="${ board.nickname }" disabled>
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text"><i class="fas fa-clipboard"></i></span>
						<textarea class="form-control" name="content" rows="15">${ board.content }</textarea>
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="desc_title"><i
							class="fas fa-calendar"></i></span> <input type="text"
							class="form-control" name="regDate" value="${board.regDate }"
							disabled>
					</div>
					<div class="input-group mb-3">
						<span class="input-group-text" id="desc_title"><i
							class="fas fa-hashtag"></i></span> <input type="text"
							class="form-control" name="cnt" value="${ board.cnt }"
							disabled>
					</div>
					<div class="container row-3" align="center">
						<input type="submit" class="btn btn-dark my-5 me-4" value="게시글수정" />
						<a href="deleteBoard.do?seq=${board.getSeq()}"
							class="btn btn-dark my-5 mx-2">게시글삭제</a> <a
							href="getBoardList.do" class="btn btn-dark my-5 mx-4">게시글목록</a>
					</div>
				</form>
			</div>
		</c:if>
	</div>
</body>
</html>