<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
  background: #fff;
 
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

.accordion .accordion-item {
  border-bottom: 1px solid #e5e5e5;
}

.accordion .accordion-item button[aria-expanded=true] {
  border-bottom: 1px solid #03b5d2;
}

.accordion button {
  position: relative;
  display: block;
  text-align: left;
  width: 100%;
  padding: 1em 0;
  color: #7288a2;
  font-size: 1.15rem;
  font-weight: 400;
  border: none;
  background: none;
  outline: none;
}

.accordion button:hover, .accordion button:focus {
  cursor: pointer;
  color: #03b5d2;
}

.accordion button:hover::after, .accordion button:focus::after {
  cursor: pointer;
  color: #03b5d2;
  border: 1px solid #03b5d2;
}

.accordion button .accordion-title {
  padding: 1em 1.5em 1em 0;
}

.accordion button .icon {
  display: inline-block;
  position: absolute;
  top: 18px;
  right: 0;
  width: 22px;
  height: 22px;
  border: 1px solid;
  border-radius: 22px;
}

.accordion button .icon::before {
  display: block;
  position: absolute;
  content: "";
  top: 9px;
  left: 5px;
  width: 10px;
  height: 2px;
  background: currentColor;
}

.accordion button .icon::after {
  display: block;
  position: absolute;
  content: "";
  top: 5px;
  left: 9px;
  width: 2px;
  height: 10px;
  background: currentColor;
}

.accordion button[aria-expanded=true] {
  color: #03b5d2;
}

.accordion button[aria-expanded=true] .icon::after {
  width: 0;
}

.accordion button[aria-expanded=true] + .accordion-content {
  opacity: 1;
  max-height: 60em;
  transition: all 200ms linear;
  will-change: opacity, max-height;
}

.accordion .accordion-content {
  opacity: 0;
  max-height: 0;
  overflow: hidden;
  transition: opacity 200ms linear, max-height 200ms linear;
  will-change: opacity, max-height;
}

.accordion .accordion-content p {
  font-size: 1rem;
  font-weight: 300;
  margin: 2em 0;
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
      <div class="container" >
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
   </header>  
   
   
   



<div class="container">
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
		
		<!--===================== 검색 =======================-->
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


<!--------------------- 자주 묻는 질문---------------------->   
<div class="container"  >
  <h4 class="fw-bold  mt-4 mb-3">자주 묻는 질문</h4>
  
  <div class="accordion">
    
    <div class="accordion-item">
      <button id="accordion-button-1" aria-expanded="false"><span class="accordion-title"> &nbsp; 중고거래 운영정책</span><span class="icon" aria-hidden="true"></span></button>
      <div class="accordion-content">
        <p style="line-height : 1.5;">
&nbsp;&nbsp;  • 가까운 이웃과의 만남이 따뜻함이 될 수 있도록 거래매너를 지켜요.</br>
&nbsp;&nbsp;  • 서로 존중하고 배려해요. 존댓말로 솔직하게 대화해요.</br>
&nbsp;&nbsp;  • 모두의 시간은 소중해요. 약속은 반드시 지켜요.</br>
&nbsp;&nbsp;  • 절대로 중간에 연락 끊기는 일이 없도록 해요.</br>
&nbsp;&nbsp;  • 언제나 따뜻한 인사로 시작하고 마무리해요.</br>
&nbsp;&nbsp;  • 늦은 시간, 특히 모두가 자고 있는 새벽 시간에는 채팅을 자제해주세요.</br>
&nbsp;&nbsp;  • 택배 거래보다는 만나서 직거래하기로 해요.</br>
&nbsp;&nbsp;  • 이웃과의 거래는 만 14세 이상부터 하기로 해요.</br>
</p>
      </div>
    </div>
    
    <div class="accordion-item">
      <button id="accordion-button-2" aria-expanded="false"><span class="accordion-title"> &nbsp; 판매 금지 물품</span><span class="icon" aria-hidden="true"></span></button>
      <div class="accordion-content">
       <p style="line-height : 1.5;">
&nbsp;&nbsp;   • 가품∙이미테이션 (상표권, 저작권 침해 물품, 특정 브랜드의 스타일을 모방한 물품)</br>
&nbsp;&nbsp;    • 주류(무알콜 주류 포함), 담배, 전자담배, 모의총포 및 그 부속품 일체 (ex. 라이터, 비비탄 총/총알 등 청소년 유해물건)</br>
&nbsp;&nbsp;    • 경유, LPG, 휘발유 등의 유류 거래</br>
&nbsp;&nbsp;    • 반려동물, 생명이 있는 동물·곤충 (무료분양, 열대어 포함)</br>
&nbsp;&nbsp;    • 한약∙의약품 ∙ 의료기기∙마약류 (청소년 유해약물∙유해화학물질)</br>
&nbsp;&nbsp;   • 반영구 화장 등 면허나 자격 없는 자의 불법 유사 의료 행위 홍보/모집글</br>
&nbsp;&nbsp;    • 수제 음식물∙건강기능식품 : 직접 만들거나 가공한 음식, 건강기능식품(지자체 및 영업 신고를 한 사람만 판매할 수 있음)</br>
&nbsp;&nbsp;   • 유통기한이 지난 제품, 포장이 훼손되거나 개봉된 식품</br>
&nbsp;&nbsp;    • 도수 있는 안경∙선글라스 (온라인 판매 불법)</br>
&nbsp;&nbsp;   • 콘택트 렌즈, 써클 렌즈 (온라인 판매 불법)</br>
&nbsp;&nbsp;   • 화장품 샘플 (온라인 판매 불법)</br>
&nbsp;&nbsp;    • 화장품제조업 및 화장품책임판매업의 등록 없이 직접 제조한 화장품</br>
&nbsp;&nbsp;  	   • 완제품이 아닌 직접 소분한 화장품</br>
&nbsp;&nbsp;     • 화장품법에 따른 라벨 및 기재사항이 없는 화장품</br>
&nbsp;&nbsp;  	   • 음란물 (청소년 유해 매체물)</br>
&nbsp;&nbsp;  	   • 촬영 여부를 상대방이 알기 어려운 카메라 혹은 그밖에 유사한 기능을 갖춘 기계장치(불법 카메라 등)</br>
&nbsp;&nbsp;  	   • 성생활용품</br>
&nbsp;&nbsp;  	   • 개인정보 (게임 계정, 추천인 계정 포함)</br>
&nbsp;&nbsp;  	   • 조건부 무료나눔</br>
&nbsp;&nbsp;  	   • 렌탈 제품</br>
&nbsp;&nbsp;  	   • 헌혈증 (무료나눔만 가능)</br>
&nbsp;&nbsp;  	   • 초대권 (무료로 받은 초대권을 유료로 판매하는 경우 / 무료나눔만 가능)</br>
&nbsp;&nbsp;  	   • 군용품∙군마트용품∙경찰용품∙도검∙화약류∙분사기∙전자충격기∙석궁∙활 (안전확인∙안전인증표시 없는 전기용품 및 단전지 또는 공산품)</br>
&nbsp;&nbsp;  	   • USD 1000달러 이상의 외환 거래나 매매차익을 목적으로 하는 반복적인 외환 거래 (매매차익을 목적으로 하지 않는 1000달러 미만의 외환 거래는 허용) </br>
&nbsp;&nbsp;  	   • 나라미, 정부 지원 생필품, 지역상품권, 문화누리카드 등 법률에 의해 재판매 할 수 없는 물품</br>
&nbsp;&nbsp;  	   • 종량제봉투</br>
&nbsp;&nbsp;  	   • 통신사 데이터, 인터넷 상품</br>
&nbsp;&nbsp;  	   • 반입한 날로부터 1년 이상 경과하지 않은 전파인증이 면제된 해외직구 전자제품을 판매하는 행위</br>
&nbsp;&nbsp;  	   • 낚시로 포획한 수산물 거래 행위</br>
&nbsp;&nbsp;  	   • 암표매매 행위</br>
&nbsp;&nbsp;  	   • 종자 (삽수,어린묘목 등)</br>
&nbsp;&nbsp;  	   • 국가기관 인증을 받지 않고 친환경, 무농약, 유기농, 오가닉, 무공해 라는 표현을 사용하여 판매하는 행위</br>
&nbsp; &nbsp; 	   • 100만 원 이상 금 제품 (골드바, 금괴, 금으로 제작된 목걸이, 팔찌, 귀걸이 등)</br>
&nbsp;&nbsp;  	   • 리콜로 인한 회수/폐기 물품</br>
&nbsp;&nbsp;  	   • 이외 법률을 위반하는 모든 물품</br>
&nbsp;&nbsp;  	   • 당근마켓 광고주센터에 등록되지 않은 모든 홍보/광고
	   </p>
      </div>
    </div>
    <div class="accordion-item">
      <button id="accordion-button-3" aria-expanded="false"><span class="accordion-title">&nbsp; FAQ를 확인해도 찾는 내용이 없나요?</span><span class="icon" aria-hidden="true"></span></button>
      <div class="accordion-content">
        <p style="line-height : 1.5;">
&nbsp; &nbsp; [마이페이지] - [고객문의] - [자주 묻는 질문] 을 클릭하여 관련 질문을 확인해도 찾으시는 내용이 없으신가요?
        
      </br>
        
&nbsp; &nbsp;         FAQ에서 확인할 수 없거나 다른 개선 제안을 남겨주고 싶으시다면</br>

&nbsp; &nbsp; 		1:1 문의하기를 선택하여 제안을 남겨주세요.
        </p>
      </div>
    </div>
    <div class="accordion-item">
      <button id="accordion-button-4" aria-expanded="false"><span class="accordion-title">&nbsp; 게시 금지 품목</span><span class="icon" aria-hidden="true"></span></button>
      <div class="accordion-content">
        <p style="line-height : 1.5;">
&nbsp;&nbsp;   • 가품∙이미테이션 (상표권, 저작권 침해 물품, 특정 브랜드의 스타일을 모방한 물품)</br>
&nbsp;&nbsp;    • 주류(무알콜 주류 포함), 담배, 전자담배, 모의총포 및 그 부속품 일체 (ex. 라이터, 비비탄 총/총알 등 청소년 유해물건)</br>
&nbsp;&nbsp;    • 경유, LPG, 휘발유 등의 유류 거래</br>
&nbsp;&nbsp;    • 반려동물, 생명이 있는 동물·곤충 (무료분양, 열대어 포함)</br>
&nbsp;&nbsp;    • 한약∙의약품 ∙ 의료기기∙마약류 (청소년 유해약물∙유해화학물질)</br>
&nbsp;&nbsp;   • 반영구 화장 등 면허나 자격 없는 자의 불법 유사 의료 행위 홍보/모집글</br>
&nbsp;&nbsp;    • 수제 음식물∙건강기능식품 : 직접 만들거나 가공한 음식, 건강기능식품(지자체 및 영업 신고를 한 사람만 판매할 수 있음)</br>
&nbsp;&nbsp;   • 유통기한이 지난 제품, 포장이 훼손되거나 개봉된 식품</br>
&nbsp;&nbsp;    • 도수 있는 안경∙선글라스 (온라인 판매 불법)</br>
&nbsp;&nbsp;   • 콘택트 렌즈, 써클 렌즈 (온라인 판매 불법)</br>
&nbsp;&nbsp;   • 화장품 샘플 (온라인 판매 불법)</br>
&nbsp;&nbsp;    • 화장품제조업 및 화장품책임판매업의 등록 없이 직접 제조한 화장품</br>
&nbsp;&nbsp;  	   • 완제품이 아닌 직접 소분한 화장품</br>
&nbsp;&nbsp;     • 화장품법에 따른 라벨 및 기재사항이 없는 화장품</br>
&nbsp;&nbsp;  	   • 음란물 (청소년 유해 매체물)</br>
&nbsp;&nbsp;  	   • 촬영 여부를 상대방이 알기 어려운 카메라 혹은 그밖에 유사한 기능을 갖춘 기계장치(불법 카메라 등)</br>
&nbsp;&nbsp;  	   • 성생활용품</br>
&nbsp;&nbsp;  	   • 개인정보 (게임 계정, 추천인 계정 포함)</br>
&nbsp;&nbsp;  	   • 조건부 무료나눔</br>
&nbsp;&nbsp;  	   • 렌탈 제품</br>
        </p>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">


const items = document.querySelectorAll(".accordion button");

function toggleAccordion() {
  const itemToggle = this.getAttribute('aria-expanded');
  
  for (i = 0; i < items.length; i++) {
    items[i].setAttribute('aria-expanded', 'false');
  }
  
  if (itemToggle == 'false') {
    this.setAttribute('aria-expanded', 'true');
  }
}

items.forEach(item => item.addEventListener('click', toggleAccordion));



</script>




</body>
</html>