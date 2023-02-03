<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>Villi : 고객문의</title>
<link rel="icon" href="../resources/images/favicon.png">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
		integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
		crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	

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
   
/* Header */

header {
   background-color: #FFF;
}

.r_menu a{
text-decoration: none;
color:black;
}

.r_menu a:hover{
color:#23dbc9;
}

.btn_radius{
border-radius:1.5em;
}

.bg-dark a{
text-decoration: none;
color:white;
}

.bg-dark:hover{
text-decoration: none;
color:white;
}

.container btn_box mt-5{
width:100%;
border : 1px solid black; 
}

.row align-items-start{
border : 1px solid black; 
}

.btn btn-dark mx-4 btn_radius{
margin-right : 20px;
border : 1px solid black; 
}

.title{
text-decoration: none;
color:black;
}

.title:hover{

color:#23dbc9;
}

.pagination li a {
	border-radius: 0 !important;
	color: #333 !important;
}
.pagination li.active a {
	color: #fff !important;
	background: #444 !important;
	border-color: #444 !important;
}



















</style>


</head>
<body>
 <!--------------- header --------------->
 
 <header class="border-bottom border-white">
      <div class="container">
         <div class="row align-items-start p-3">
            <div class="col mt-3">
               <a href="#"><i class="fas fa-calendar fa-2x text-dark"></i></a>
            </div>
            <div class="col" align="center">
               <a href="getBoardList.do"><img src="resources/images/test.png"
                  alt="logo" width=70px height=70px></a>
            </div>

            <div class="col mt-3 text-end r_menu">
               <span class= mx-2><a href="#">좋아요</a> </span>
               <span class= mx-1><a href="user/mypage.jsp">마이페이지</a></span>
               <span class="mx-2">${ sessionScope.user.getNickname() }님</span>
            </div>
         </div>
      </div>
      
 <!-------------- script -------------->     
	<script>
		function deleteCs() {
			if(confirm("문의사항을 삭제하겠습니까?")) {
		    	self.location.href = "deleteCs.do?noti_seq=${ cs.noti_seq }";
		    }
		}
	</script>
</header>

<!------------------ 본문 ------------------->
	<div class="container col-5 mt-4"  align="center">
	 	<h3 class="fw-bold">고객 문의</h3>
	</div>
	<hr/>	
	
	
	
	<div class="container mt-3">	
	
	
	
	
	
	
	
	<ul class="faq_list" id="faqAllBox">
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">온라인 교육을 받으려고 하는데 지원되지 않는 비디오 유형 또는 잘못된 파일 경로입니다.</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									안녕하세요. 소상공인 지식배움터입니다. 
<br />보통의 경우 개인 PC의 네트워크 환경에 따라 문제가 발생하기 때문에 인터넷 옵션 초기화와 브라우저를 업데이트 하시는 것을 추천드립니다.
<br />이후로도 동영상 시청에 지속적인 문제가 발생하신다면 헬프데스크(1644-5302)를 통해 문의 주시기를 바랍니다.
								</p>
						</div>
					</li>
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">온라인 강의가 모바일 기기에서 열리지 않습니다.</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									안녕하세요. 소상공인 지식배움터입니다. 
<br />동영상이 정상적으로 재생되지 않는다면, 모바일 기기 혹은 네트워크의 문제일 가능성이 높습니다. 아래의 방법들을 진행해 보시기를 권장드립니다.
<br />1. 브라우저 앱 재실행
<br />2. 네트워크 연결 상태 확인
<br />3. 브라우저 앱 설정 초기화 혹은 재설치
<br />이후로도 동영상 시청에 지속적인 문제가 발생하신다면 헬프데스크(1644-5302)를 통해 문의 주시기를 바랍니다.
								</p>
						</div>
					</li>
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">소상공인 정책자금 신청을 위해 교육을 수강하고 싶습니다.</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									Q1. 소상공인 정책자금 신청을 위해 교육을 수강하고 싶습니다. 
<br />소상공인 정책자금을 지원하시려면 온라인교육에 들어가셔서 교육 중 원하시는 교육으로 신청하셔서 12시간 이상 수강해 주시면 됩니다.(교육 신청 과정은 Q3 참고) 
<br />
<br />Q2. 온라인교육 수료완료 후 정책자금을 신청하고 싶습니다.
<br />자금/오프라인 교육에 대한 문의는 1357로 전화주시면 관할지역 소상공인 지역센터로 연결되오니 문의 부탁 드립니다.(휴대전화, 인터넷전화 연결 안됨. 유선전화 연결 가능함) 
<br />각 지역 센터에서 정책자금 신청관련 자세한 안내 받으시면 됩니다. 
<br />
<br />Q3. 온라인교육 교육신청 및 소상공인 정책자금 신청 과정 안내 
<br />1. 온라인교육에서 원하시는 과정으로 신청 
<br />2. 나의 강의실 > 학습현황 > 학습중인 과정에 입장해서 수강
<br />3. 나의 강의실 > 학습현황 > 학습완료 과정에서 수료한 시간을 합산해서 12시간 이상인지 확인 
<br />4. 1357 로 전화주셔서 정책자금 신청관련 방문서류 안내 받으신 후 정책자금 지원대상 확인서 발급함 
<br />5. 각 지역 신용보증 재단에서 신용보증서 발급 (신용, 재정상태, 경영능력, 사업성 등 평가 후 발급)
<br />6. 은행에서 대출 실행 (자금 안내는 "소상공인시장진흥공단 - 지원사업 - 소상공인자금" 에서 융자 절차 등 자세한 내용 확인해 주시면 됩니다.) 
<br />
<br /><신용보증서는 본인 및 배우자 신용상태, 자기자금, 영업기간 및 실적 등에 따라 발급이 불가 할수 있습니다.>
								</p>
						</div>
					</li>
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">수강신청 확인은 어떻게 하나요?</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									수강신청을 하신 후 나의강의실 &gt; 학습현황 &gt; 학습중인 과정 에서 신청내용을 확인하시고 학습을 진행하면 됩니다.
								</p>
						</div>
					</li>
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">기관회원인데 로그인 및 수강신청이 안됩니다.</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									기관회원은 학습 및 수료증 발부가 불가 하므로, 개인회원으로 가입 후 이용을 해주시기 바랍니다.
								</p>
						</div>
					</li>
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">수료증 출력시 테두리 이미지가 출력이 안됩니다.</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									1 .IE8 버전 : 도구 - 인터넷옵션 - 고급 - 인쇄 - 배경 및 이미지 인쇄 체크 
<br />2. IE10 버전 : 파일 - 페이지설정 - 배경색 및 이미지 인쇄 체크
<br />위와 같은 설정 후 F5번 눌러주신 후 프린트 해주시면 됩니다.
								</p>
						</div>
					</li>
				
					<li><!-- 디폴트 활성화 필요시 class="open" -->
						<div class="q">
							<span class="i"><span class="alt_text">질문</span>Q</span>
							<a href="#faq_1">(현장교육) 교육취소를 하려고 하는데 취소버튼이 보이지 않습니다.</a>
						</div>
						
						<div class="a" id="faq_1">
							<span class="i"><span class="alt_text">대답</span>A</span>
								<p>
									선정이 되시면 직접 취소를 하실 수 없습니다.
<br />신청하신 교육기관으로 전화하셔서 신청하신 교육의 취소의사를 말씀드리고 취소요청해 주시기 바랍니다.
								</p>
						</div>
					</li>
				
				
		
	
<script type="text/javascript">

	//내용 펼치기
	$(function() {
		$(".faq_list .q").on("click",function(){
			$(".faq_list li").not($(this).parents("li")).removeClass("open");
			$(this).parents("li").toggleClass("open");
			return false;
		});
	});
	
</script>
	
	
	
	
	
	<h4 class="fw-bold  mt-4 mb-3">고객 문의 게시판</h4>
		<table class="table table-bordered table-striped table-hover">
			<thead class="table-dark text-center">
				<th scope="col" class="col-1 text-center">No.</th>
				<th scope="col" class="col-5">제목</th>
				<th scope="col" class="col-1 text-center">작성자</th>
			    <th scope="col" class="col-1 text-center">조회수</th>
				<th scope="col" class="col-1 text-center">등록일</th>
				
				<!-- ================ 관리자일때 표시 =================== -->
			    <c:if test="${ sessionScope.isAdmin }">
					<th scope="col" class="col-1 text-center">삭제</th>
				</c:if>			
				
			</thead>
		    <tbody>

	  
				<c:forEach var="cs" items="${ csList }">
					<tr>
					    <td scope="row" align="center">${cs.seq }</td>
						<td align="left"><a href="updateCs.do?seq=${cs.seq}" class="title">${ cs.title }</a></td>
						<td scope="row" align="center">${cs.writer }</td>
						<td scope="row" align="right">${cs.cnt }</td>
						<td><fmt:formatDate value="${cs.regDate }" pattern="yyyy-MM-dd"/></td>
					<c:if test="${ sessionScope.isAdmin }">
						<td align="center">
							<a href="deleteCs.do?noti_seq=${ cs.seq }" class="btn btn-danger" onclick="deleteCs()"><i class="fas fa-trash"></i></a>
						</td>
					</c:if>
					</tr>
				</c:forEach>			
			</tbody>
		</table>	
		
		<!-- ==================== 검색 ====================== -->
		<div class="row">
		<div class="col text-start">
       <form action="getCsList.do" method="post" id="csForm">
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
						<option value="content"
							${searchVO.getSearchType()=="content" ? "selected" : "" }>내용</option>
					</select>
					
				</div>
				<div class="col col-lg-4">
					<input class="form-control" name="searchWord" type="text"
						placeholder="${searchVO.getCurPage()}of ${searchVO.getTotalRowCount()}" />
				</div>
				<div class="col col-lg-2">
					<button class="btn text-white "  style="background-color: #72CCD2;" type="submit">Search</button>
				</div>
			</div>
		 </div>
		</form>
		</div>
		
		
		<div class="col text-end">
		<input type="submit" class="btn btn-dark mx-4 "  value="1:1 문의하기" onClick="location.href='cs/insertCs.jsp'"/>
		</div>
		</div>
		
			
	</div>
	
	
	
	
	

	<!------- 여기서부터는 페이징 처리 ------->
	<div class="container mt-3">
		<div class="row align-items-start">
						
			<ul class="pagination justify-content-center">								
				<c:set var="cp" value="${ pageInfo.getCurrentPage() }"/>

				<c:if test="${ pageInfo.getStartPage() != 1 }">
					<li class="page-item"><a href="getCsList.do?p=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a href="getCsList.do?p=${ pageInfo.getStartPage() - 10 }" class="page-link"><i class="fas fa-backward"></i></a></li>				
				</c:if>
			
				<c:forEach var="page" begin="${ pageInfo.getStartPage() }" end="${ pageInfo.getEndPage() }">
					<li class="page-item ${ (cp==page) ? 'active' : ''}"><a href="getCsList.do?p=${page}" class="page-link">${page}</a></li>
				</c:forEach>
				
				<c:if test="${ pageInfo.getEndPage() < pageInfo.getTotalPages() }">
					<li class="page-item"><a href="getCsList.do?p=${ pageInfo.getEndPage() + 1 }" class="page-link"><i class="fas fa-forward"></i></a></li>				
					<li class="page-item"><a href="getCsList.do?p=${ pageInfo.getTotalPages() }" class="page-link"><i class="fas fa-fast-forward"></i></a></li>				
				</c:if>
			</ul>	    	
		</div>
	</div> 		
</body>
</html>