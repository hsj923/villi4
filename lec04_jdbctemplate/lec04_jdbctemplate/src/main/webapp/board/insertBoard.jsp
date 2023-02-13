<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>상품빌리 글쓰기</title>
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

<script type="text/javascript">
	function checkform() {
		if (document.frm.cate2.value == "카테고리") {
			alert("카테고리를 입력해주세요")
			document.frm.cate2.select();
			return false;
		} else if (document.frm.title.value == "") {
			alert("제목을 입력해주세요")
			form.title.focus();
			return false;
		} else if (document.frm.content.value == "") {
			alert("내용을 입력해주세요")
			document.frm.content.select();
			return false;
		} else if (document.frm.title.value == "") {
			alert("작성자를 입력해주세요")
			document.frm.title.select();
			return false;
		} else if (document.frm.uploadFile1.value == "") {
			alert("사진은 한 개 이상 등록해주세요")
			document.frm.uploadFile1.select();
			return false;
		} else if (document.frm.usedate.value == "") {
			alert("대여 날짜를 입력해주세요")
			document.frm.usedate.select();
			return false;
		} else if (document.frm.duedate.value == "") {
			alert("마감 날짜를 입력해주세요")
			document.frm.duedate.select();
			return false;
		}
		document.frm.submit();
	}
</script>

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
						class=mx-1><a href="../getUserList.do"
						style="text-decoration: none" class="text-dark">마이페이지</a></span> <span
						class="mx-2">${ sessionScope.user.getNickname() }님</span>

				</div>
			</div>
		</div>
	</header>
	
	<!--=============================================================================================== -->
	
	<div class="container col-5 mt-4"  align="center">
	 	<h3 class="fw-bold">상품 등록 게시글 작성하기</h3>
	</div>


	<!--뭐해 -->

	<!-- 카테고리 -->
	<div class="container mt-3" align="center">
		<form id="frm" action="insertBoard.do" method="post"
			onsubmit="return formCheck();" name="frm"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col">
					<div class="input-group mb-3 w-75">
						<span class="input-group-text"><i class="fas fa-user"></i></span>
						<input
							type="text" class="form-control"
							value="${ user.getNickname() }" disabled>
							<input type="hidden" class="form-control" name="nickname" id="nickname"
							value="${ user.getNickname() }">
							<input type="hidden" class="form-control" name="address" id="address"
							value="${ user.getAddress() }">
							
					</div>


					<div class="input-group mb-3 w-75">
						<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmark-plus-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M2 15.5V2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.74.439L8 13.069l-5.26 2.87A.5.5 0 0 1 2 15.5zm6.5-11a.5.5 0 0 0-1 0V6H6a.5.5 0 0 0 0 1h1.5v1.5a.5.5 0 0 0 1 0V7H10a.5.5 0 0 0 0-1H8.5V4.5z"/>
</svg></span><select
							class="form-select form-select w-75" name="cate2"
							aria-label=".form-select example">
							<option selected>카테고리</option>
							<option value="디지털기기">디지털기기</option>
							<option value="공구용품">공구용품</option>
							<option value="여성의류">여성의류</option>
							<option value="남성의류">남성의류</option>
							<option value="주방/화장실용품">주방/화장실용품</option>
							<option value="행사용품/캠핑용품">행사용품/캠핑용품</option>
							<option value="반려동물용품">반려동물용품</option>
							<option value="취미/게임/음반">취미/게임/음반</option>
							<option value="가구/인테리어">가구/인테리어</option>
							<option value="뷰티/미용용품">뷰티/미용용품</option>
							<option value="스포츠/레저">스포츠/레저</option>
							<option value="육아물품">육아물품</option>
							<option value="도서">도서</option>
							<option value="기타">기타</option>
						</select>
					</div>
				</div>
			</div>

			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-address-book"></i></span><input
					type="text" class="form-control" name="title" id="title"
					placeholder="글 제목">
			</div>
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
  <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"/>
</svg></span><input type="text" class="form-control" name="price" id="price"
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
				<span class="input-group-text"><i class="fas fa-clipboard"></i></span><textarea class="form-control" name="content" id="content" rows="20"
					placeholder="게시글 내용을 작성해주세요."></textarea>
			</div>
			<label for="form-control" class="form-control-label">대여날짜와
				마감날짜를 정해주세요</label>

			<div class="input-group mb-3 w-75">
			<span class="input-group-text">	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar-check" viewBox="0 0 16 16">
  <path d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
  <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
</svg></span>	<input type="date" class="form-control" name="usedate" id="usedate">
				<input type="date" class="form-control" name="duedate" id="duedate">
			</div>
			<!-- 파일첨부 -->

			<label for="formFile" class="form-label">사진은 최대 3장까지 등록가능합니다</label>
			<div class="input-group mb-3 w-75">

				<input type="file" class="form-control" name="uploadFile1"
					id="uploadFile1" aria-describedby="uploadFile" aria-label="Upload">
				<input type="file" class="form-control" name="uploadFile2"
					id="uploadFile2" aria-describedby="uploadFile" aria-label="Upload">
				<input type="file" class="form-control" name="uploadFile3"
					id="uploadFile3" aria-describedby="uploadFile" aria-label="Upload">
			</div>
			<input type="hidden" name="fileName" value="" />
			<div class="input-group input-group-lg mb-5 w-75">
				<input type="button" class="form-control btn btn-dark"
					OnClick="checkform()" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" id="click" value="글작성">
			</div>
		</form>
	</div>

</body>
</html>