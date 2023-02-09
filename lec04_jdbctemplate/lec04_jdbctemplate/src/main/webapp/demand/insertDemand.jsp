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
	 	<h3 class="fw-bold">빌리요청 게시글 작성하기</h3>
	</div>

	<!--=============================================================================================== -->

	<form id="frm" action="insertDemand.do" method="post" onsubmit="return formCheck();" name="frm"
			enctype="multipart/form-data">
		<div class="container mt-3" align="center">
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-user"></i></span> <input
					type="text" class="form-control" name="writer" id="writer"
					value="${ sessionScope.user.getNickname() }" disabled>
			</div>
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-address-book"></i></span>
				<input type="text" class="form-control" name="title" id="title"
					placeholder="빌리요청글 제목">
			</div>
			<div class="input-group mb-3 w-75">
			<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
  <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"/>
</svg></span>
				<input type="text" class="form-control" name="price" id="price"
					onkeyup="inputNumberFormat(this)" placeholder="가격(선택사항)">
				<script>
					 function inputNumberFormat(obj) {
					     obj.value = comma(uncomma(obj.value));
					 }

					 function comma(str) {
					     str = String(str);
					     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
					 }

					 function uncomma(str) {
					     str = String(str);
					     return str.replace(/[^\d]+/g, '');
					 }
					</script>
			</div>
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-clipboard"></i></span>
				<textarea class="form-control" name="content" id="content" rows="20"
					placeholder="빌리요청글 상세내용"></textarea>
			</div>


			<!-- 파일첨부 -->
			
			<div class="input-group mb-3 w-75">
				<label class="input-group-text" for="uploadFile1"><i
					class="fas fa-file"></i></label> <input type="file" class="form-control"
					name="uploadFile1" id="uploadFile1" aria-describedby="uploadFile"
					aria-label="Upload">
			</div>
			<input type="hidden" name="fileName" value="" />



			<div class="input-group input-group-lg mb-5 w-75">
				<input type="submit" class="form-control btn btn-dark""
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-lg" value=" 작성 ">
			</div>


			<!-- 		    <input type="submit" class="input-group input-group-lg btn btn-primary" value="새글 작성 " />  -->
			<!--  		    <button type="button" class="btn btn-primary" onclick="history.go(-1)">글 목록 가기</button> -->
		</div>
	</form>
</body>
</html>









