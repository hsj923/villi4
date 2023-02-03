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
								<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav me-auto mb-2 mb-lg-0">
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="">글작성</a>
									</li>
											
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


	<!--=============================================================================================== -->
<form action="insertLost.do" method="post">
		<div class="container mt-3 w-75" align="center">
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-user"></i></span> <input
					type="text" class="form-control" name="writer" id="writer"
					placeholder="분실센터글 작성자....">
			</div>
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-address-book"></i></span>
				<input type="text" class="form-control" name="title" id="title"
					placeholder="동네질문글 제목....">
			</div>
			<div class="input-group mb-3 w-75">
				<span class="input-group-text"><i class="fas fa-clipboard"></i></span>
				<textarea class="form-control" name="content" id="content" rows="20"
					placeholder="동네질문글 상세내용...."></textarea>
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







