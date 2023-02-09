<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Framework</title>
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

header {
	background-color: #FFF;
	height: 90px;
}

.r_menu a:hover {
	color: #23dbc9
}
</style>
</head>
<body>
<header class="border-bottom border-dark">
		<div class="container w-50">
			<div class="row align-items-start p-3">
				<div class="col mt-3">
					<a href="#"><i class="fas fa-calendar fa-2x text-dark"></i></a>
				</div>
				<div class="col" align="center">
					<a href="../getBoardList.do"><img
						src="/img/test.png" alt="logo" width=70px
						height=70px></a>
				</div>

				<div class="col mt-3 text-end r_menu">
					<span class=mx-2><a href="../getLikeList.do"
						style="text-decoration: none" class="text-dark">좋아요</a> </span> <span
						class=mx-1><a href="../user/mypage.jsp"
						style="text-decoration: none" class="text-dark">마이페이지</a></span> <span
						class="mx-2">${ sessionScope.user.getNickname() }님</span>

				</div>
			</div>
		</div>
	</header>
	
	<!--=============================================================================================== -->
	
	<div class="container col-5 mt-4"  align="center">
	 	<h3 class="fw-bold">동네모임 게시글 작성하기</h3>
	</div>

	<!--=============================================================================================== -->

	<form action="insertMeeting.do" method="post">
		<div class="container mt-3 w-75" align="center">
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-user"></i></span><input
					type="text" class="form-control" name="writer" id="writer"
					value="${ sessionScope.user.getNickname() }" disabled>
			</div>
			<div class="input-group mb-3 w-75">

				<span class="input-group-text"><i class="fas fa-address-book"></i></span><input
					type="text" class="form-control" name="title" id="title"
					placeholder="동네모임글 제목">
			</div>
			<div class="input-group mb-3 w-75">

				<span class="input-group-text"><svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-person-plus-fill"
						viewBox="0 0 16 16">
  <path
							d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
  <path fill-rule="evenodd"
							d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z" />
</svg></span><input type="number" class="form-control" name="per" id="per"
					placeholder="인원">
			</div>
			<div class="input-group mb-3 w-75">

				<span class="input-group-text"> <svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-calendar-check"
						viewBox="0 0 16 16">
  <path
							d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
  <path
							d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
</svg></span><input type="date" class="form-control" name="meet_date" id="meet_date">
			</div>
			<div class="input-group mb-3 w-75">

				<span class="input-group-text"><svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
  <path
							d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z" />
  <path
							d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
</svg></span><input type="text" class="form-control" name="place" id="place"
					placeholder="장소">
			</div>





			<div class="input-group mb-3 w-75">

				<span class="input-group-text"><i class="fas fa-clipboard"></i></span>
				<textarea class="form-control" name="content" id="content" rows="20"
					placeholder="동네모임글 상세내용"></textarea>
			</div>




			<div class="input-group input-group-lg mb-5 w-75">
				<input type="submit" class="form-control btn btn-dark"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-lg" value=" 작성 ">
			</div>


			<!-- 		    <input type="submit" class="input-group input-group-lg btn btn-primary" value="새글 작성 " />  -->
			<!--  		    <button type="button" class="btn btn-primary" onclick="history.go(-1)">글 목록 가기</button> -->
		</div>
	</form>
</body>
</html>









