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
	 	<h3 class="fw-bold">동네 투표 게시글 작성하기</h3>
	</div>


	<!--=============================================================================================== -->

	<form action="insertVote.do" method="post">
		<div class="container mt-3 w-75" align="center">
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-user"></i></span><input
					type="text" class="form-control" name="writer" id="writer"
					value="${ sessionScope.user.getNickname() }" disabled>
			</div>
			<div class="input-group mb-3 w-75">
				
				<span class="input-group-text"><i class="fas fa-address-book"></i></span><input type="text" class="form-control" name="title" id="title"
					placeholder="동네투표글 제목">
			</div>

			<div class="input-group mb-3 w-75">
				
				<span class="input-group-text"><i class="fas fa-clipboard"></i></span><textarea class="form-control" name="content" id="content" rows="20"
					placeholder="동네투표글 내용"></textarea>
			</div>
			<div class="input-group mb-3 w-75">
				
				<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-1-square-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm7.283 4.002V12H7.971V5.338h-.065L6.072 6.656V5.385l1.899-1.383h1.312Z"/>
</svg></span><input type="text" class="form-control" name="itemlist1" id="itemlist1"
					placeholder="항목1">
			</div>
			<div class="input-group mb-3 w-75">
				
				<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-2-square-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm4.646 6.24v.07H5.375v-.064c0-1.213.879-2.402 2.637-2.402 1.582 0 2.613.949 2.613 2.215 0 1.002-.6 1.667-1.287 2.43l-.096.107-1.974 2.22v.077h3.498V12H5.422v-.832l2.97-3.293c.434-.475.903-1.008.903-1.705 0-.744-.557-1.236-1.313-1.236-.843 0-1.336.615-1.336 1.306Z"/>
</svg></span><input type="text" class="form-control" name="itemlist2" id="itemlist2"
					placeholder="항목2">
			</div>
			<div class="input-group mb-3 w-75">
			
				<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-3-square-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm5.918 8.414h-.879V7.342h.838c.78 0 1.348-.522 1.342-1.237 0-.709-.563-1.195-1.348-1.195-.79 0-1.312.498-1.348 1.055H5.275c.036-1.137.95-2.115 2.625-2.121 1.594-.012 2.608.885 2.637 2.062.023 1.137-.885 1.776-1.482 1.875v.07c.703.07 1.71.64 1.734 1.917.024 1.459-1.277 2.396-2.93 2.396-1.705 0-2.707-.967-2.754-2.144H6.33c.059.597.68 1.06 1.541 1.066.973.006 1.6-.563 1.588-1.354-.006-.779-.621-1.318-1.541-1.318Z"/>
</svg></span><input type="text" class="form-control" name="itemlist3" id="itemlist3"
					placeholder="항목3">
			</div>
			<div class="input-group mb-3 w-75">
			
				<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-4-square-fill" viewBox="0 0 16 16">
  <path d="M6.225 9.281v.053H8.85V5.063h-.065c-.867 1.33-1.787 2.806-2.56 4.218Z"/>
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Zm5.519 5.057c.22-.352.439-.703.657-1.055h1.933v5.332h1.008v1.107H10.11V12H8.85v-1.559H4.978V9.322c.77-1.427 1.656-2.847 2.542-4.265Z"/>
</svg></span><input type="text" class="form-control" name="itemlist4" id="itemlist4"
					placeholder="항목4">
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









