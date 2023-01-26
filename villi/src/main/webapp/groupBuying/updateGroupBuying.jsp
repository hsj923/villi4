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
										aria-current="page" href="groupBuying/insertGroupBuying.jsp">글작성</a>
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

	<!-- 삭제시 confirm -->
	<script>
		function deleteQuestion() {
			if(confirm("자료를 삭제하겠습니까?")) {
		    	self.location.href = "deleteQuestion.do?seq=${ question.seq }";
		    }
		}
	</script>
</body>
</html>
