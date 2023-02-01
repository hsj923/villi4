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
			if ( document.frm.cate2.value == "카테고리") {
				alert("카테고리를 입력해주세요")
				document.frm.cate2.select();
				return false;
			}
			else if ( document.frm.title.value == "") {
				alert("제목을 입력해주세요")
				form.title.focus();
				return false;		
			}
			else if ( document.frm.content.value == "") {
				alert("내용을 입력해주세요")
				document.frm.content.select();
				return false;
			}
			else if ( document.frm.title.value == "") {
				alert("작성자를 입력해주세요")
				document.frm.title.select();
				return false;
			}
			else if ( document.frm.uploadFile1.value == "") {
				alert("사진은 한 개 이상 등록해주세요")
				document.frm.uploadFile1.select();
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
								<div class="collapse navbar-collapse"
									id="navbarSupportedContent">
									<ul class="navbar-nav me-auto mb-2 mb-lg-0">
										<li class="nav-item">
											<!-- ================글작성버튼============= -->
											<div class="dropdown">
												<button class="btn dropdown-toggle" type="button"
													id="dropdownMenuButton2" data-bs-toggle="dropdown"
													aria-expanded="false">글작성</button>
												<ul class="dropdown-menu dropdown-menu-dark"
													aria-labelledby="dropdownMenuButton2">
													<li><a class="dropdown-item"
														href="">상품</a></li>
													<li><a class="dropdown-item"
														href="insertServiceBoard.jsp">서비스</a></li>
												</ul>
											</div>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="../getQuestionList.do">동네질문</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="../getLostList.do">분실센터</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="../getMeetingList.do">동네모임</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="../getVoteList.do">동네투표</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="../getDemandList.do">빌리요청</a></li>
										<li class="nav-item"><a class="nav-link"
											aria-current="page" href="../getGroupBuyingList.do">공동구매</a></li>
									</ul>
									<form action="getBoardList.do" method="post" id="boardForm">
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


<!--뭐해 -->

	<!-- 카테고리 -->
	<div class="container mt-3" align="center">
		<form id="frm" action="insertBoard.do" method="post" onsubmit="return formCheck();" name="frm"
			enctype="multipart/form-data">
			<div class="row">
<!-- 				<div class="col"> -->
<!-- 					<select class="form-select form-select-lg mb-3"  -->
<!-- 						aria-label=".form-select-lg example"> -->
<!-- 						<option selected value="lend">빌리합니다</option> -->
<!-- 						<option value="borrow">빌리해주세요</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
				<div class="col">
					<select class="form-select form-select mb-3 w-75" name="cate2"
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
			<div class="input-group mb-3 w-75">
				<input type="text" class="form-control" name="writer" id="writer"
					placeholder="글 작성자">
			</div>
			<div class="input-group mb-3 w-75">
				<input type="text" class="form-control" name="title" id="title"
					placeholder="글 제목">
			</div>
			<div class="input-group mb-3 w-75">
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
				<input type="date" class="form-control" name="usedate" id="usedate" placeholder="대여날짜(선택사항)">
				<input type="date" class="form-control" name="duedate" id="duedate" placeholder="마감날짜(선택사항)">
			</div>
			<div class="input-group mb-3 w-75">
				<textarea class="form-control" name="content" id="content" rows="20" placeholder="게시글 내용을 작성해주세요."></textarea>
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
				<input type="button" class="form-control btn btn-dark" OnClick="checkform()"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" id="click"  value="글작성">
			</div>
		</form>
	</div>
	
</body>
</html>