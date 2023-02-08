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
						src="../resources/images/test.png" alt="logo" width=70px
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
	 	<h3 class="fw-bold">분실센터 게시글 작성하기</h3>
	</div>
	<!--=============================================================================================== -->
<form action="insertLost.do" method="post">
		<div class="container mt-3 w-75" align="center">
			<div class="input-group mb-3 w-75">
				 <span class="input-group-text"><i class="fas fa-user"></i></span><input
					type="text" class="form-control" name="writer" id="writer"
					placeholder="분실센터글 작성자">
			</div>
			<div class="input-group mb-3 w-75">
			
				<span class="input-group-text"><i class="fas fa-address-book"></i></span><input type="text" class="form-control" name="title" id="title"
					placeholder="동네질문글 제목">
			</div>
			<div class="input-group mb-3 w-75">
		
				<span class="input-group-text"><i class="fas fa-clipboard"></i></span><textarea class="form-control" name="content" id="content" rows="20"
					placeholder="동네질문글 상세내용"></textarea>
			</div>


			<!-- 파일첨부 -->
			<div class="input-group mb-3 w-75">
				<label class="input-group-text" for="uploadFile1"><i
					class="fas fa-file"></i></label> <input type="file" class="form-control"
					name="uploadFile1" id="uploadFile1" aria-describedby="uploadFile"
					aria-label="Upload"> <label class="input-group-text"
					for="uploadFile2"><i class="fas fa-file"></i></label> <input
					type="file" class="form-control" name="uploadFile2"
					id="uploadFile2" aria-describedby="uploadFile" aria-label="Upload">


				<label class="input-group-text" for="uploadFile4"><i
					class="fas fa-file"></i></label> <input type="file" class="form-control"
					name="uploadFile3" id="uploadFile3" aria-describedby="uploadFile"
					aria-label="Upload">
			</div>
			<input type="hidden" name="fileName" value="" />



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









