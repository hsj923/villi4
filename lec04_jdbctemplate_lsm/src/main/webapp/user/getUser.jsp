<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Villi : 프로필 수정</title>
<link rel="icon" href="../resources/images/favicon.png">
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

/* line 147, app/assets/stylesheets/home/users/show.css.scss */
#user-records #no-records {
	text-align: center;
	font-size: 17px;
	padding: 140px 0;
}
/*후기 내용 영역*/
.user-articles {
  padding-top: 20px;
}

/* line 157, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews {
  padding-bottom: 30px;
}

/* line 159, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list {
  list-style-type: none;
}

/* line 161, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review {
  padding: 16px 0;
  border-bottom: 1px solid #e9ecef;
  position: relative;
}

/* line 165, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-profile-photo {
  display: inline-block;
  vertical-align: middle;
}

/* line 168, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-profile-photo img {
  width: 24px;
  height: 24px;
  -o-object-fit: cover;
     object-fit: cover;
  border-radius: 50%;
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
}

/* line 177, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-writer-nickname {
  display: inline-block;
  font-size: 15px;
  font-weight: 600;
  line-height: 1.47;
  letter-spacing: -0.5px;
  vertical-align: middle;
  margin-right: 8px;
  margin-left: 8px;
}

/* line 186, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-writer-nickname .destroyed {
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

/* line 198, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-writer-region-name {
  display: inline-block;
  font-size: 13px;
  line-height: 1.46;
  letter-spacing: -0.5px;
  vertical-align: middle;
}

/* line 205, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-content {
  padding-top: 8px;
  font-size: 15px;
  line-height: 1.47;
  letter-spacing: -0.5px;
  width: calc(100% - 80px);
}

/* line 212, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-time {
  display: block;
  font-size: 13px;
  line-height: 1.46;
  letter-spacing: -0.5px;
  color: #868e96;
  margin-top: 8px;
}

/* line 220, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-image {
  position: absolute;
  top: 16px;
  right: 0;
}

/* line 224, app/assets/stylesheets/home/users/show.css.scss */
.user-reviews #reviews-list .review .review-image img {
  width: 60px;
  height: 60px;
  border-radius: 3px;
  -webkit-border-radius: 3px;
  -moz-border-radius: 3px;
}
</style>


</script>

<script type="text/javascript">
	
</script>


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
				<div class="col mt-3">
					<a href="#"><i class="fas fa-calendar fa-2x text-dark"></i></a>
				</div>
				<div class="col" align="center">
					<a href="getBoardList.do"><img src="resources/images/test.png"
						alt="logo" width=70px height=70px></a>
				</div>

				<div class="col mt-3 text-end r_menu">
					<span class=mx-2><a href="#">좋아요</a> </span> <span class=mx-1><a
						href="user/mypage.jsp">마이페이지</a></span> <span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				</div>
			</div>
		</div>
	</header>

	<!------------------ 본문 --------------------->

	<div class="container col-5 mt-4">
		<h3 class="fw-bold">내 프로필</h3>
		<hr />
		<form role="form" action="updateUser.do" method="post"
			onSubmit="return checkResult();">


			<input type="hidden" name="email" value="${user.getEmail()}">
			<input type="hidden" name="curPage" value="${searchVO.getCurPage()}">
			<input type="hidden" name="rowSizePerPage"
				value="${searchVO.getRowSizePerPage()}"> <input
				type="hidden" name="searchCategory"
				value="${searchVO.getSearchCategory()}"> <input
				type="hidden" name="searchType" value="${searchVO.getSearchType()}">
			<input type="hidden" name="searchWord"
				value="${searchVO.getSearchWord()}">


			<!-- 프로필 사진 수정 -->

			<section id="content">
				<label for="inputProfile" class="mt-3">* 프로필 사진</label>
				<div class="col-2 input-group mb-3 mt-2">

					<c:if test="${ !empty  user.fileName}">
						<img src="resources/images/${ user.fileName }"
							class="rounded-circle border border-dark" width="80" height="80"
							alt="img">
					</c:if>
					<c:if test="${ empty  user.fileName}">
						<img src="resources/images/noimg.png"
							class="rounded-circle border border-dark" width="80" height="80"
							alt="img">
					</c:if>
				</div>
				<!-- 거래 후기 목록 -->
				<div id="user-records-detail">
					<section id="user-filter">
						<h3 class="hide">${ sessionScope.user.getNickname() }님의 거래 후기
							목록</h3>
						<ul>
							<li><a class="active" href="#">거래 후기</a></li>
							<li><a class="" href="#">매너 칭찬</a></li>
						</ul>
					</section>
					<section id="user-records" class="user-reviews" data-total-page="1"
						data-current-page="1">
						<ul id="reviews-list">
							<!-- 후기 내용 insertReview에서 작성 한 리스트 불러오는 공간 -->	
							<div class="review">${ board.Seq }</div>
							<div class="review">${ sessionScope.user.getNickname() } : 물건이 별로에요</div>
							<div class="review">${ sessionScope.user.getNickname() } : 맛있게 잘먹었어요</div>
							<div class="review">${ sessionScope.user.getNickname() }</div>
							<div class="review-profile-photo"></div>
						</ul>
					</section>
				</div>
			</section>
</body>
</html>