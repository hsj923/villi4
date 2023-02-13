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

pre {
	white-space: pre-wrap;
	font-family: 'Pretendard-Regular';
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
							<a class="navbar-brand" href="getBoardList.do">Villi</a>
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
										aria-current="page" href="meeting/insertMeeting.jsp">글작성</a></li>

									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getQuestionList.do">동네질문</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getLostList.do">분실센터</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getMeetingList.do">동네모임</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getVoteList.do">동네투표</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getDemandList.do">빌리요청</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="getGroupBuyingList.do">공동구매</a></li>
								</ul>
								<form action="getMeetingList.do" method="post" id="meetingForm">
									<input type="hidden" id="curPage" name="curPage"
										value="${searchVO.getCurPage()}"> <input type="hidden"
										id="rowSizePerPage" name="rowSizePerPage"
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



	<!-- form -->
	<div class="container-sm mt-3" align="center">
		<form action="updateMeeting.do" method="post">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title text-start">
						<img src="resources/images/noimg.png"
							class="rounded-circle border border-dark" alt="img" width="75"
							height="75"><span>${meeting.writer }</span> <span
							class="fs-5"><i class="bi bi-award text-warning"></i></span>

						<!-- 	   <p class="fs-4 bg-secondary text-end">대여중</p>    -->
					</h5>

				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item text-start"><c:choose>
							<c:when test="${meeting.status eq '모집중'}">
								<span class="badge bg-success text-white rounded-pill ">${meeting.status}</span>
							</c:when>
							<c:when test="${meeting.status eq '모임종료'}">
								<span class="badge bg-danger text-white rounded-pill ">${meeting.status}</span>
							</c:when>
						</c:choose> <span class="fs-4 fw-bold">${ meeting.title }</span>
						<p class="text-muted fs-6 fst-italic">${meeting.regDate}</p> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
  <path
								d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94zM8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10z" />
  <path
								d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4zm0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
</svg><span class="fs-6 ms-2">${ meeting.place }</span><br> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-square"
							viewBox="0 0 16 16">
  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
  <path
								d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12z" />
</svg><span class="fs-6 ms-2">${ meeting.per }명 모집</span><br> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-calendar-check"
							viewBox="0 0 16 16">
  <path
								d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
  <path
								d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" />
</svg><span class="fs-6 ms-2">${ meeting.meet_date }</span> <br> <br>


						<p class="text-muted fs-5">${ meeting.content }</p> <br> <br>
						<br>
						<p class="mt-4">조회 : ${ meeting.cnt }</p></li>
					<li class="list-group-item text-end "><a
						href="report/report_insert.jsp" class="stretched-link text-danger">이
							게시글 신고하기</a></li>
				</ul>
				<div class="card-body">
					<div class="row">
						<div class="col-4 text-start">
							<span class="fs-4 mx-3"><i
								class="bi bi-heart-fill text-danger"></i></span>
						</div>
						<div class="col-8 text-end">
							<a href="#" class="btn ps-6 text-white rounded-pill"
								style="background-color: #72CCD2;">채팅하기</a>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- 댓글 자리 -->
		<!-- 댓글 작성 -->
		<div class="container-sm mt-5" align="center">
			<form method="post" action="insertMReply.do">
				<p>
					<label>댓글 작성자 : </label> <input type="text" name="writer"
						value="${ sessionScope.user.getName() }" readonly>
				</p>
				<p>
					<textarea rows="5" cols="50" name="content" style="width: 100%"></textarea>
				</p>
				<p>
					<input type="hidden" name="seq" value="${meeting.seq}">
					<c:if test="${ sessionScope.isAdmin }">
						<button type="submit">댓글 작성</button>
					</c:if>
				</p>
			</form>
		</div>

		<!-- 댓글 시작 -->
		<div class="container-sm mt-5" align="center">
			<c:forEach items="${mreplyList}" var="mreplyList">
				<div class="card" style="border: 0;">
					<ul class="list-group list-group-flush">
						<li class="list-group-item text-start"><span
							class="fs-5 fw-bold" style="color: #4881f7;">${mreplyList.writer}</span>
							&nbsp; <span class="mt-4 text-end" style="font-size: 12px">댓글
								등록일 : ${mreplyList.regDate}</span> &nbsp; <a
							href="deleteMReply.do?rno=${mreplyList.rno}"
							style="font-size: 12px; color: #999; text-decoration: none;"
							onclick="deleteMReply()">삭제</a> <pre class="fs-6">${mreplyList.content}</pre>
						</li>
					</ul>
				</div>
				<hr />
			</c:forEach>
			<br />

			<!-- 댓글 끝 -->

			<div class="container row-3" align="center">
				<input type="submit" class="btn btn-dark my-5 mx-4" value="게시글수정" />
				<a href="deleteMeeting.do?seq=${meeting.getSeq()}"
					class="btn btn-dark my-5 mx-2">게시글삭제</a> <a
					href="getMeetingList.do" class="btn btn-dark my-5 mx-4">게시글목록</a>
			</div>
		</div>
		<!-- 댓글 삭제 시 -->
		<script>
			function deleteMReply() {
				if (confirm("댓글을 삭제하겠습니까?")) {
					self.location.href = "deleteMReply.do?rno=${ mreply.rno }";
				}
			}
		</script>

		<!-- 삭제시 confirm -->
		<script>
			function deleteQuestion() {
				if (confirm("자료를 삭제하겠습니까?")) {
					self.location.href = "deleteQuestion.do?seq=${ question.seq }";
				}
			}
		</script>
</body>
</html>