<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<title>채팅리스트</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
		integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
		crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
  <link rel="stylesheet" type="text/css" href="../css/chatlist.css">
<style>
@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

body{
font-family: 'Pretendard-Regular';

}

nav{
    background-color: #FFFAFA;
}
<style>
	#banner img{

	width:100%;
	height:650px;
	object-fit: cover;

}

.r_menu a{
text-decoration: none;
color:black;
}

@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

body{
font-family: 'Pretendard-Regular';}

.css-1ckh9yi {
	display: flex;
	flex-direction: column;
	position: relative;
	margin: 16px;
	border: 1px solid gray;
	border-radius: 8px;
	height: 125px;
	-webkit-box-pack: justify;
	justify-content: space-between;
}

.css-10fmtiz {
	margin: 12px 12px 0px;
	width: calc(100% - 24px);
	height: 63px;
	line-height: 150%;
	padding: 0px;
	resize: none;
	font-size: 14px;
	/* border: solid 1px black; */
	border : none;
	outline: none;
	color: gray;
	background-color: var(- -seed-semantic-color-paper-default);
}

textarea {
	overflow: auto;
}

.css-1ckh9yi .chatform-option-area {
	display: flex;
	-webkit-box-pack: justify;
	justify-content: space-between;
	margin: 8px 10px;
}

.css-1ckh9yi .chatform-option-area .chatform-submenu {
	display: flex;
	-webkit-box-align: center;
	align-items: center;
	column-gap: 12px;
}

.css-1ckh9yi .option-wrapper {
	display: inline-flex;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	width: 32px;
	height: 32px;
	cursor: pointer;
	font-size: 0px;
/* 	border: solid 1px black; */
}

.css-1ckh9yi input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	opacity: 0;
}

.css-1f5m7zv .sticker-button {
	border: none;
	background-color: white;
	
}
.css-1useanf {
    border-radius: 4px;
    width: 64px;
    height: 32px;
    line-height: 150%;
    font-weight: bold;
    font-size: 14px;
    background-color: var(--seed-scale-color-carrot-500);
    color: rgb(255, 255, 255);
    transition: background-color 0.5s ease 0s, color 0.5s ease 0s;
}

.css-1useanf.disable {
	background-color: orange;
	color: black;
	border: none;
}

.css-1ckh9yi .text-length {
	position: absolute;
	right: 84px;
	bottom: 11px;
	font-size: 12px;
	line-height: 150%;
	color: gray;
}
.bi-geo-alt-fill{
	height:30px;
	border: none;
	

}
/* ---------------------------------------------------------------------- */

.nav-items{
	position: fixed;
}
.List-container {
    padding-top: 50px;
    max-height: 100vh;
    /* overflow: auto;  */
/*     float:center; */
}
.List-container .List-body {
    display: flex;
    -webkit-box-pack: center;
    justify-content: center;
    flex-direction: column;
    height: calc(100vh - 64px);
}
.Chat-list {
    display: flex;
    overflow-x: auto;
    position: relative;
    margin: 0px auto;
    height: 100%;
}
.Side-list {
    display: flex;
}
.User-list {
    display: flex;
    border-right: 1px solid var(--seed-semantic-color-divider-2);
    width: 312px;
    min-width: 312px;
    flex-direction: column;
    -webkit-box-pack: justify;
    justify-content: space-between;
    background-color: var(--seed-semantic-color-paper-default);
}
.nickname-bar {
    position: relative;
    display: flex;
    height: 64px;
    min-height: 64px;
    border-bottom: 1px solid var(--seed-semantic-color-divider-1);
    padding: 0px 20px;
    -webkit-box-align: center;
    align-items: center;
    border:solid 1px #ced4da;
}
.nickname-bar .nickname-area {
    font-weight: bold;
    font-size: 16px;
    line-height: 150%;
}
.Search-bar {
    display: flex;
    flex-direction: row-reverse;
    height: 44px;
    min-height: 44px;
    padding: 0px 6px;
    border-bottom: 1px solid var(--seed-semantic-color-divider-1);
    font-size: 12px;
    -webkit-box-align: center;
    align-items: center;
    border:solid 1px #ced4da;
}
.css-8lfz6g {
    position: relative;
    margin: 0px;
   /*  padding: 0px; */
    height: calc(100% - 56px);
    list-style: none;
    overflow: hidden auto;
    background-color: var(--seed-semantic-color-paper-sheet);
    border: solid 1px #ced4da;
}
.User-list .faq-container {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    border-top: 1px solid var(--seed-semantic-color-divider-2);
    padding-left: 10px;
    height: 56px;
    min-height: 56px;
    border: solid 1px #ced4da;
}
.Chatlist-box {
    position: relative;
    display: flex;
    flex-direction: column;
    border-right: 1px solid var(--seed-semantic-color-divider-2);
    min-width: 812px;
    max-width: 812px;
    background-color: var(--seed-semantic-color-paper-default);
}
.Chatlist-box .empty-box {
    display: flex;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    align-items: center;
    width: 100%;
    height: 100%;
    flex-direction: column;
    border:solid 1px #ced4da; 
}
.Side-list .Sidebar .profile-image.selected {
    box-shadow: 0px 0px 0 2px var(--seed-scale-color-gray-200),0px 0px 0 4px rgb(255, 126, 54);
}
.Side-list .Sidebar {
    display: flex;
    flex-direction: column;
    border-left: 1px solid var(--seed-semantic-color-divider-1);
    border-right: 1px solid var(--seed-semantic-color-divider-1);
    padding: 10px 10px;
    width: 72px;
    background-color: #BDBDBD;
    border: solid 1px #ced4da;
}
.Side-list .Sidebar .UserProf {
    position: relative;
    display: inline-block;
    width: 44px;
    height: 44px;
}
.css-up958c {
    position: relative;
    display: flex;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    align-items: center;
    height: 44px;
    font-size: 14px;
    color: var(--color-blue800);
    background-color: var(--color-blue50);
}
img, svg {
    vertical-align: middle;
    height: 55px;
}

.Search-bar .unread-label {
    display: flex;
    padding: 6px;
    border-radius: 6px;
    font-weight: normal;
    font-size: 13px;
    line-height: 150%;
    letter-spacing: -0.02em;
    color: var(--seed-scale-color-gray-600);
}
  .form-control {
    display: block;
    width: 120%;
    padding: 0.375rem 0.75rem;
    font-size: 1.1rem;
    font-weight: 1000;
    line-height: 1.4;
    color: #212529;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border-radius: 0.25rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
} 
 
.col-6{
line-height:300%;
border: solid 1px black;
}
.col-2{
border:solid 1px blue;
}
.dropdown-toggle-split
{
    width: 40px;
    height: 50px;
    background-color: gray;
    border: solid 1px black;
}
.btn-outline-success{
	width:60px;
}
.form-select {
    display: block;
    width: 100%;
    padding: 0.375rem 1.5rem 0.375rem 0.95rem;
    -moz-padding-start: calc(0.75rem - 3px);
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
    background-image: url(data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='%23343a40' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M2 5l6 6 6-6'/%3e%3c/svg%3e);
    background-repeat: no-repeat;
    background-position: right 0.75rem center;
    background-size: 16px 12px;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;

</style>		
</head>
<body>
	<!-- ===========header================ -->
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
						<a href="#">좋아요</a> <span class="mx-4"> <a
							href="getUserList.do">마이페이지</a></span> <span>
					</div>
				</div>
			</div>
		</header>
<!-- ============search=============== -->	 		            
   <header class="border-bottom border-dark sticky-top z-index-10">            
	<div class="container"  align="center">
	  <div class="row p-3">
		 <div class="col"> 
		 <nav class="navbar navbar-expand-lg navbar-light">
		   <div class="container-fluid">
		    <a class="navbar-brand" href="../getBoardList.do">Villi</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    	 	              <!-- ================글작성버튼============= -->
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="../lost/lost_insert.jsp">글작성</a>
		        </li>
		        <li class="nav-item">
		        
		          <a class="nav-link" aria-current="page" href="../getQuestionList.do">우리동네질문</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="../getLostList.do">동네분실센터</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" aria-current="page" href="../getMeetingList.do">동네모임</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="../getVoteList.do">동네투표</a>
		        </li>
		      </ul>      
		   		</div>  
		 	</div>
		</nav> 
	  	</div> 	
    </div>
   </div>
   
</header> 
  		<div class="List-container">
  			<main class="List-body">
  				<div class="Chat-list"><div>
  				</div>
  				<div class="Side-list">
  				<nav class="Sidebar">
  			<a class="UserProf" href="../index.do">
  			<!-- 	<img class="selected profile-image" src="../resources/images/logo.png"  alt="villi" > -->
  			</a>
 	 </nav>
  		<nav class="User-list">
  		<div class="nickname-bar">
 		<div class="nickname-area">사용자 닉네임</div><!-- db에서 user닉네임 호출 -->
  	</div>
 	
 	
 	
 	
 
 	
 <form action="getChatList.do" method="post" id="chatForm">
					<input type="hidden" id="curPage" name="curPage" value="${searchVO.getCurPage()}"> 
						<input type="hidden" id="rowSizePerPage" name="rowSizePerPage"value="${searchVO.getRowSizePerPage()}">
										<div class="container">
											<div class="row justify-content-md">
												<div class="col-md-2">
													<select class="form-select" id="searchType" name="searchType">
														<option value="writer"
															${searchVO.getSearchType()=="writer" ? "selected" : "" }></option>
													</select>
													</div>
												<div class="col col-lg-6">
													<input class="form-control" name="searchWord" type="text"
														placeholder="닉네임 검색" />
												</div>
												<div class="col col-lg-2">
													<button class="btn btn-outline-success" type="submit">검색</button>
												</div>
											</div>
										</div>
									</form>
 	<!-- 채팅 내의 검색 이동 href -->
  <ul tabindex="0" role="list" aria-label="내 채널 리스트" class="css-8lfz6g">
  		<li class="not-exist-channelList">
  			<div class="title"></div>
  				<!-- 사용자 리스트 불러 오는 공간 -->
  		<div class="container mt-3">
		<div class="row mt-4">
  			<!-- 닉네임 나열 하는 공간 -->
 			<th scope="col"></th>
					<tbody>
				<c:forEach  var="chat" items="${ chatList }">
					<tr>
						<%-- <td>${ chat.getWriter() }</td> --%>
						<td align="center">
							<div class="container">
  								<div class="row">
    								<div class="col-2 mb-3">프사</div>
    								<div class="col-6 mb-3">
  											<td scope="row"><a href="getChatList.do?id=${ chat.getWriter() }">${ chat.getWriter() }</a></td>
   											
   										</div>
    							<div class="col-1">
							    <button type="button" class="btn btn-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
							        <span class="visually-hidden">Toggle Dropdown</span>
							    </button>
							    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							        <li><a class="dropdown-item" href="#">후기 남기기</a></li>
							        <li><a class="dropdown-item" href="#">신고하기</a></li>
							        <li><a class="dropdown-item" href="#">채팅방 삭제</a></li>
							    </ul>
    							</div>
    						</div>
    					</div>
					</td>
				</tr>
			</c:forEach>				
		</tbody>
	</div>	
</div> 
  	  <div class="description"></div>
  	</li>
 </ul>
  	   <div class="faq-container">
  	 <a class="faq-content common-bg-hover" href="https://www.daangn.com/wv/faqs?kind=karrotchat" target="_blank" rel="noreferrer">
  	<span class="faq-test">자주묻는 질문</span>
  	<svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
  	    <circle cx="9" cy="9" r="8.5" stroke="#868B94"></circle>
  	    <path d="M8.25586 11.0977C8.26367 10.6328 8.31641 10.2656 8.41406 9.99609C8.51172 9.72656 8.71094 9.42773 9.01172 9.09961L9.7793 8.30859C10.1074 7.9375 10.2715 7.53906 10.2715 7.11328C10.2715 6.70312 10.1641 6.38281 9.94922 6.15234C9.73438 5.91797 9.42188 5.80078 9.01172 5.80078C8.61328 5.80078 8.29297 5.90625 8.05078 6.11719C7.80859 6.32812 7.6875 6.61133 7.6875 6.9668H6.60352C6.61133 6.33398 6.83594 5.82422 7.27734 5.4375C7.72266 5.04688 8.30078 4.85156 9.01172 4.85156C9.75 4.85156 10.3242 5.05078 10.7344 5.44922C11.1484 5.84375 11.3555 6.38672 11.3555 7.07812C11.3555 7.76172 11.0391 8.43555 10.4062 9.09961L9.76758 9.73242C9.48242 10.0488 9.33984 10.5039 9.33984 11.0977H8.25586ZM8.20898 12.9551C8.20898 12.7793 8.26172 12.6328 8.36719 12.5156C8.47656 12.3945 8.63672 12.334 8.84766 12.334C9.05859 12.334 9.21875 12.3945 9.32812 12.5156C9.4375 12.6328 9.49219 12.7793 9.49219 12.9551C9.49219 13.1309 9.4375 13.2773 9.32812 13.3945C9.21875 13.5078 9.05859 13.5645 8.84766 13.5645C8.63672 13.5645 8.47656 13.5078 8.36719 13.3945C8.26172 13.2773 8.20898 13.1309 8.20898 12.9551Z" fill="#868B94"></path>
  	  </svg>
  	 </a>
  	</div>
  </nav>
 </div>
  	<section class="Chatlist-box">
  		<div class="empty-box">
  	<svg width="96" height="81" viewBox="0 0 96 81" fill="none" xmlns="http://www.w3.org/2000/svg">
  	<path d="M33.0004 0C15.0185 0 0 13.0729 0 29.6567C0 40.358 6.27606 49.642 15.5279 54.8364L13.8397 64.5305C13.7353 65.1299 13.928 65.7446 14.3535 66.1751L14.3573 66.179L14.3724 66.1939C14.3853 66.2066 14.4061 66.2267 14.4326 66.2506C14.4869 66.2995 14.568 66.3668 14.6744 66.435C14.9082 66.5849 15.1569 66.6709 15.3962 66.7073C15.7666 66.7637 16.0661 66.6901 16.1358 66.673L16.1413 66.6716C16.3174 66.6287 16.5003 66.558 16.6232 66.51C16.9302 66.3901 17.5014 66.1524 18.5787 65.6955C20.7218 64.7866 24.9636 62.9696 33.3799 59.3641C51.1931 59.1817 66.0008 46.1763 66.0008 29.7093C66.0008 13.1297 50.987 0 33.0004 0Z" fill="#DCDEE3"></path><path d="M72.2312 29.4385C72.2312 48.2002 56.7085 62.679 37.8858 64.8408C44.0168 70.067 52.3818 73.2792 61.479 73.3633C70.2216 76.9749 74.6257 78.7941 76.8498 79.7036C77.9674 80.1606 78.5583 80.3977 78.8749 80.517C79.0036 80.5654 79.1863 80.6333 79.3599 80.6741L79.3652 80.6754C79.4339 80.6917 79.7238 80.7604 80.0821 80.7078C80.313 80.6739 80.5564 80.5935 80.7883 80.4501C80.8943 80.3846 80.9756 80.3195 81.0307 80.2717C81.0459 80.2585 81.0593 80.2464 81.0704 80.2362C81.0789 80.2284 81.0861 80.2217 81.0918 80.2163L81.1071 80.2017L81.111 80.1978C81.5557 79.764 81.7577 79.1325 81.6467 78.5179L79.9012 68.8524C89.4699 63.674 96 54.3943 96 43.6557C96 29.1206 84.0984 17.353 68.7254 14.6059C70.9682 19.0808 72.2312 24.0881 72.2312 29.4385Z" fill="#DCDEE3"></path>
  	</svg>
  	<div class="empty-description">채팅할 상대를 선택해주세요.</div>
  	</div>
  	<!-- -------------------------------------------------------------------------------------- -->
 <!--  	<div tabindex="0" role="region"  aria-label ="메시지리스트" class="css-1bc192o"></div>
  					   	<form class="css-1ckh9yi">
  							<textarea placeholder="메시지를 입력해주세요" class="css-10fmtiz"></textarea>
  							<div class="chatform-option-area">
  								<div class="chatform-submenu">
  									<label class="option-wrapper">
  										<span class="option-tooltip">사진</span> 
  										<svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
  										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-images" viewBox="0 0 16 16">
												<path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
													<path d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z"/>
												</svg>
  													<rect width="20" height="20" rx="3"></rect>
										  				<path d="M6 9C7.10457 9 8 8.10457 8 7C8 5.89543 7.10457 5 6 5C4.89543 5 4 5.89543 4 7C4 8.10457 4.89543 9 6 9Z" fill="white"></path>
										  				<path d="M3 16L6.5 12L10 16" fill="white"></path>
										  				<path d="M7 16L12 10L17 16" fill="white"></path>
													</svg>완
  												<input type="file" multiple="" accept="image/png, image/jpeg, image/gif">
  										</label>
  											 <label class="option-wrapper ">
  												<span class="option-tooltip">자주 쓰는 문구</span>
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-left-text-fill" viewBox="0 0 16 16">
													  <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H4.414a1 1 0 0 0-.707.293L.854 15.146A.5.5 0 0 1 0 14.793V2zm3.5 1a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 2.5a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 2.5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5z"/>
													</svg>
												</label>							  											
									  			<label class="option-wrapper">
									  				<span class="option-tooltip">위치 공유</span>
							  						<div class="option-wrapper  css-1f5m7zv">
						  								<button class="sticker-button" type="button">
						  								location
														<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
													  <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
													</svg>		
												</button>
												</div>
											</label>
										</div>
									  	<button class="disable css-1useanf" aria-disabled="true">전송</button>
									  	</div>
							  			</button>
								  	<span class="text-length">0/1000</span>
	  		    			  		</div>
		  					   	</form>
	  		    			  </div>
			  				</section>
	  	    			  </div>
		</div>  	 -->
  	<!-- -------------------------------------------------------------------------------------- -->
    		<!-- <div class="css-1oteowz">
  			<div class="css-up958c"> 
  						</div>
  						</div>
  			-->
				  	</main>
				<div></div>
			</div>
  		</div>
		<div id ="popupRoot"></div>
		<div id ="modalRoot"></div>
	<%-- 	
		<div class="row align-items-start mt-3">
			<ul class="col pagination justify-content-center">
			
				<c:set var="cp" value="${searchVO.getCurPage()}"/>
				<c:set var="rp" value="${searchVO.getRowSizePerPage()}"/>
				<c:set var="fp" value="${searchVO.getFirstPage()}"/>
				<c:set var="lp" value="${searchVO.getLastPage()}"/>
				<c:set var="ps" value="${searchVO.getPageSize()}"/>
				<c:set var="tp" value="${searchVO.getTotalPageCount()}"/>
				<c:set var="sc" value="${searchVO.getSearchCategory()}"/>
				<c:set var="st" value="${searchVO.getSearchType()}"/>
				<c:set var="sw" value="${searchVO.getSearchWord()}"/>
																
				<c:if test="${ fp != 1 }">
					<li class="page-item"><a href="getChatList.do?curPage=1&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
					<li class="page-item"><a href="getChatList.do?curPage=${fp-1}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}" class="page-link"><i class="fas fa-backward"></i></a></li>				
				</c:if>
			
				<c:forEach var="page" begin="${fp}" end="${lp}">
					<li class="page-item ${cp==page ? 'active' : ''}"><a href="getChatList.do?curPage=${page}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}" class="page-link">${page}</a></li>
				</c:forEach>
				
				<c:if test="${ lp < tp }">
					<li class="page-item"><a href="getChatList.do?curPage=${lp+ps}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}" class="page-link"><i class="fas fa-forward"></i></a></li>				
					<li class="page-item"><a href="getChatList.do?curPage=${tp}&rowSizePerPage=${rp}&searchType=${st}&searchWord=${sw}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>				
				</c:if>
			</ul> --%>
		
	</body>
</html>
  
		    		 