<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>신고하기</title>
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

</style>
</head>
<body>

         
	<form action="insertReport.do" method="post">
		<div class="container mt-3 w-75" align="center">
			<div class="input-group mb-3 w-75">
			</div>
			<div class="input-group mb-3 w-75">
				<input type="text" class="form-control" name="name" id="name"
					placeholder="${ sessionScope.user.getNickname() }" disabled>
			</div>
			

             <input type="text" name="writer" value="${user.nickname}">
			
			<select class="form-select form-select mb-3 w-75" name="r_rs1"
				aria-label=".form-select example">
				<option selected>신고이유</option>
				<option value="거래가 금지된 물건을 거래합니다">거래가 금지된 물건을 거래합니다</option>
				<option value="동네 이웃 주민이 아닌것 같습니다">동네 이웃 주민이 아닌것 같습니다</option>
				<option value="사기 글입니다">사기 글입니다</option>
				<option value="중복 게시글입니다">중복 게시글입니다</option>
				<option value="거래/환불분쟁">거래/환불분쟁</option>
				<option value="금전 요구를 합니다">금전 요구를 합니다</option>
				<option value="성희롱을 합니다">성희롱을 합니다</option>
				<option value="욕설을 합니다">욕설을 합니다</option>
				<option value="비매너 사용자입니다">비매너 사용자입니다</option>
				<option value="기타 다른 문제가 있습니다">기타 다른 문제가 있습니다</option>
			</select>

			<div class="input-group mb-3 w-75">
				<textarea class="form-control" name="r_con" id=" r_con" rows="20"
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









