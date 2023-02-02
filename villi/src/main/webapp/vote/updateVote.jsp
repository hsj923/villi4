<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>동네투표</title>
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
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- 차트 링크 -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
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
					<nav class="navbar navbar-expand navbar-light sticky-top">
						<div class="container-fluid">
							<a class="navbar-brand" href="getBoardList.do">Villi</a>
							<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<!--================ nav bar ===================-->
							<div class="navbar-collapse collapse show" id="navbarSupportedContent" style="">
								<ul class="navbar-nav me-auto mb-2 mb-lg-0">
									<li class="nav-item">
									
									
									<!-- ================글작성버튼, 로그인============= --> <c:if
											test="${ sessionScope.user.getNickname() == null }">
											<a class="nav-link active" aria-current="page"
												href="index.jsp">로그인</a>
										</c:if> 
										<c:if test="${ sessionScope.user.getNickname() != null }">
											<a class="nav-link active" aria-current="page" href="">글작성</a>
										</c:if>
									</li>
										

									<li class="nav-item"><a class="nav-link" aria-current="page" href="getQuestionList.do">동네질문</a></li>
									<li class="nav-item"><a class="nav-link" aria-current="page" href="getLostList.do">분실센터</a></li>
									<li class="nav-item"><a class="nav-link" aria-current="page" href="getMeetingList.do">동네모임</a></li>
									<li class="nav-item"><a class="nav-link" href="getVoteList.do">동네투표</a></li>
									<li class="nav-item"><a class="nav-link" aria-current="page" href="getDemandList.do">빌리요청</a></li>
									<li class="nav-item"><a class="nav-link" aria-current="page" href="getGroupBuyingList.do">공동구매</a></li>
								</ul>
								<form action="getVoteList.do" method="post" id="voteForm">
									<input type="hidden" id="curPage" name="curPage" value="1"> <input type="hidden" id="rowSizePerPage" name="rowSizePerPage" value="10">
									<div class="container">
										<div class="row justify-content-md">
											<div class="col-md-auto">
												<select class="form-select" id="searchType" name="searchType">
													<option value="">검색</option>
													<option value="title">제목</option>
													<option value="writer">작성자</option>
													<option value="cate2">카테고리</option>
												</select>
											</div>
											<div class="col col-lg-6">
												<input class="form-control" name="searchWord" type="text">
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
	<!-- 	<!--==============================게시물 제목===============================   -->
	<div class="container">
		
		<div class="row">
						<div class="col-4 text-start">
							<h4>${ vote.title } </h4>
						</div>
						<div class="col-8 text-end">
							<span class="text-muted fs-6 text-end">조회 : ${ vote.cnt }</span>
						</div>		 
					</div>



		<!-- 이미지 -->
		<!--              <div class="card" style="width: 18rem;"> -->
		<%-- 				   <img src="resources/images/${ vote.v_item1Pic }" class="card-img-top" alt="img"> --%>
		<!-- 			 </div> -->

		<!--==============================차트생성===============================   -->
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-body">
						<canvas id="myChart1"></canvas>
					</div>
					<div class="card-footer text-center text-dark">
						<h3 class= "text-muted ">${ vote.content }</h3>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--==============================체크박스===============================   -->
	<div class="container mt-3">

		<div class="form-check">
			<input class="form-check-input" type="radio" name="flexRadioDefault"
				id="check1" value="${ vote.itemcnt1 }"
				onchange="checkBox(this)"> <label class="form-check-label"
				for="flexRadioDefault1"> ${ vote.itemlist1 } </label>
		</div>


		<div class="form-check">
			<input class="form-check-input" type="radio" name="flexRadioDefault"
				id="check2" value="${ vote.itemcnt2 }"
				onchange="checkBox(this)"> <label class="form-check-label"
				for="flexRadioDefault2"> ${ vote.itemlist2 } </label>
		</div>


		<c:if test="${ !empty  vote.itemlist3}">
			<div class="form-check">
				<input class="form-check-input" type="radio" name="flexRadioDefault"
					id="check3" value="${ vote.itemcnt3 }"
					onchange="checkBox(this)"> <label class="form-check-label"
					for="flexRadioDefault3"> ${ vote.itemlist3 } </label>
			</div>
		</c:if>

		<c:if test="${ !empty  vote.itemlist4}">
			<div class="form-check">
				<input class="form-check-input" type="radio" name="flexRadioDefault"
					id="check4" value="${ vote.itemcnt4 }"
					onchange="checkBox(this)"> <label class="form-check-label"
					for="flexRadioDefault4"> ${ vote.itemlist4 } </label>
			</div>
		</c:if>
		<!-- ==================부트스트랩====================== -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>


		<!--==============================파이형 차트===============================   -->
		<script>
			//jstl변수 선언
			var list1 = '<c:out value="${ vote.itemlist1 }"/>';
			var list2 = '<c:out value="${ vote.itemlist2 }"/>';
			var list3 = '<c:out value="${ vote.itemlist3 }"/>';
			var list4 = '<c:out value="${ vote.itemlist4 }"/>';
			var count1 = '<c:out value="${ vote.itemcnt1 }"/>';
			var count2 = '<c:out value="${ vote.itemcnt2 }"/>';
			var count3 = '<c:out value="${ vote.itemcnt3 }"/>';
			var count4 = '<c:out value="${ vote.itemcnt4 }"/>';

			data = {
				datasets : [ {
					backgroundColor : [ '#ebce10', '#80dbd4', '#a2a2a2',
							'yellowgreen' ],
					data : [ count1, count2, count3, count4 ]
				} ],
				// 라벨의 이름이 툴팁처럼 마우스가 근처에 오면 나타남
				labels : [ list1, list2, list3, list4 ]
			};

			// 가운데 구멍이 없는 파이형 차트
			var ctx1 = document.getElementById("myChart1");
			var myPieChart = new Chart(ctx1, {
				type : 'pie',
				data : data,
				options : {}
			});

			//체크박스 체크시 체크된 값 출력
			function checkBox(box) {
				var obj_length = document.getElementsByName("flexRadioDefault").length;
				
				   for (var i=0; i<obj_length; i++) {
				if (box.checked==true) { // 체크가 되면 checed==true라는 값을 전달받는다. 
					if (check1.checked)
						document.getElementById("sumcnt1").value = parseInt(box.value) + 1; //getElementById메소드 이용&value속성 변경
					else if (check2.checked) {
						document.getElementById("sumcnt2").value = parseInt(box.value) + 1;
					} else if (check3.checked) {
						document.getElementById("sumcnt3").value = parseInt(box.value) + 1;
					} else if (check4.checked) {
						document.getElementById("sumcnt4").value = parseInt(box.value) + 1;
					} 
				}
			}
		}		   
			


		</script>

		<!-- ================================투표하기 버튼=============================== -->
		<!-- 체크된 값 -->
		<form action="updateVote.do" method="post">
			<hr>
			<input name="seq" type="hidden" value="${vote.seq}" /> <input
				name="itemcnt1" type="hidden" value="${vote.itemcnt1}" id="sumcnt1" />
			<input name="itemcnt2" type="hidden" value="${vote.itemcnt2}"
				id="sumcnt2" />
			<c:if test="${ !empty  vote.itemcnt3}">
				<input name="itemcnt3" type="hidden" value="${vote.itemcnt3}"
					id="sumcnt3" />
			</c:if>
			<c:if test="${ !empty  vote.itemcnt4}">
				<input name="itemcnt4" type="hidden" value="${vote.itemcnt4}"
					id="sumcnt4" />
			</c:if>

			<input type="submit" id="vote" class="btn btn-success" onclick="voteconfirm()" value="투표하기" />

   
<script>
    function voteconfirm() {
        alert("투표가 성공적으로 완료되었습니다");
    }
</script>
		</form>
	</div>
	<div class="container mt-5" align="center">
		<a href="vote/vote_insert.jsp" class="btn btn-primary">글등록</a><a
			href="report/report_insert.jsp" class="btn btn-danger">신고</a> <a
			href="deleteVote.do?seq=${board.getSeq()}" class="btn btn-primary">게시글삭제</a>
		<a href="getVoteList.do" class="btn btn-primary">게시글목록</a>
	</div>






</body>
</html>
