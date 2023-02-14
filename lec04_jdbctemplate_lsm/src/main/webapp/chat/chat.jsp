<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>채팅리스트</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
<link rel="stylesheet" href="../css/chat.css"></link>
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
	<!-- ===========header================ -->
	<header class="border-bottom border-white">
		<div class="container">
			<div class="row align-items-start p-3">
				<div class="col mt-3">
					<a href="#"><i class="fas fa-calendar fa-2x text-dark"></i></a>
				</div>
				<div class="col" align="center">
					<a href="../board/getBoardList.jsp"><img
						src="../resources/images/test.png" alt="logo" width=70px
						height=70px></a>
				</div>

				<div class="col mt-3 text-end r_menu">
					<a href="#">좋아요</a> <span class="mx-4"> <a
						href="getUserList.do">마이페이지</a></span><span class="mx-2">${ sessionScope.user.getName() }님</span>
				</div>
			</div>
		</div>
	</header>
	<!-- ============search=============== -->
	<header class="border-bottom border-dark sticky-top z-index-10">
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
							<!-- ================글작성버튼============= -->
							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav me-auto mb-2 mb-lg-0">
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="../lost/lost_insert.jsp">글작성</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="../getQuestionList.do">우리동네질문</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="../getLostList.do">동네분실센터</a></li>
									<li class="nav-item"><a class="nav-link"
										aria-current="page" href="../getMeetingList.do">동네모임</a></li>
									<li class="nav-item"><a class="nav-link"
										href="../getVoteList.do">동네투표</a></li>
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
			<div class="Chat-list">
				<div></div>
				<div class="Side-list">
					<nav class="Sidebar">
						<a class="UserProf" href="../index.jsp"> <img
							class="selected profile-image" src="../resources/images/test.png"
							alt="villi">
						</a>
					</nav>
					<nav class="User-list">
						<div class="nickname-bar">
							<div class="nickname-area">사용자 닉네임</div>
						</div>

						<form action="../chat/updateChat.jsp" method="post" id="chatForm">
							<input type="hidden" id="curPage" name="curPage"
								value="${searchVO.getCurPage()}"> <input type="hidden"
								id="rowSizePerPage" name="rowSizePerPage"
								value="${searchVO.getRowSizePerPage()}">
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
						<ul tabindex="0" role="list" aria-label="내 채널 리스트"
							class="css-8lfz6g">
							<li class="not-exist-channelList">
								<div class="title">
								<div class="container mt-3">
								<img class="userprof"  width="45px" height="45px;" src="../resources/images/userprof.png">
								전재성   
								<span class="badge bg-success text-white rounded-pill ">대기중</span>	
								</div> <!-- 사용자 리스트 불러 오는 공간 -->
									<div class="row mt-4">
										<!-- 닉네임 나열 하는 공간 -->
										<th scope="col"></th>
										<tbody>
											<c:forEach var="chat" items="${ chatList }">
												<tr>
													<%-- <td>${ chat.getWriter() }</td> --%>
													<td align="center">
														<div class="container">
															<div class="row">
																<div class="col-2 mb-3">프사</div>
																<div class="col-6 mb-3">
																	<td scope="row"><a>${ chat.getWriter() }</a>l</td> <span
																		class="badge bg-success text-white rounded-pill ">${chat.getStatus()}</span>
																</div>
																<div class="col-1">
																	<button type="button"
																		class="btn btn-danger dropdown-toggle dropdown-toggle-split"
																		data-bs-toggle="dropdown" aria-expanded="false">
																		<span class="visually-hidden">Toggle Dropdown</span>
																	</button>
																	<ul class="dropdown-menu"
																		aria-labelledby="dropdownMenuButton">
																		<li><a class="dropdown-item"
																			href="review/insertReview.jsp">후기 남기기</a></li>
																		<!-- 후기 작성폼 생성 -->
																		<li><a class="dropdown-item"
																			href="report/insertReport.jsp">신고하기</a></li>
																		<li><a class="dropdown-item" href="#">채팅방 삭제</a></li>
																		<!-- crud user삭제 게시판 활용 -->
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
							<a class="faq-content common-bg-hover"
								href="https://www.daangn.com/wv/faqs?kind=karrotchat"
								target="_blank" rel="noreferrer"> <span class="faq-test">자주묻는
									질문</span> <svg width="18" height="18" viewBox="0 0 18 18" fill="none"
									xmlns="http://www.w3.org/2000/svg">
  	    <circle cx="9" cy="9" r="8.5" stroke="#868B94"></circle>
  	    <path
										d="M8.25586 11.0977C8.26367 10.6328 8.31641 10.2656 8.41406 9.99609C8.51172 9.72656 8.71094 9.42773 9.01172 9.09961L9.7793 8.30859C10.1074 7.9375 10.2715 7.53906 10.2715 7.11328C10.2715 6.70312 10.1641 6.38281 9.94922 6.15234C9.73438 5.91797 9.42188 5.80078 9.01172 5.80078C8.61328 5.80078 8.29297 5.90625 8.05078 6.11719C7.80859 6.32812 7.6875 6.61133 7.6875 6.9668H6.60352C6.61133 6.33398 6.83594 5.82422 7.27734 5.4375C7.72266 5.04688 8.30078 4.85156 9.01172 4.85156C9.75 4.85156 10.3242 5.05078 10.7344 5.44922C11.1484 5.84375 11.3555 6.38672 11.3555 7.07812C11.3555 7.76172 11.0391 8.43555 10.4062 9.09961L9.76758 9.73242C9.48242 10.0488 9.33984 10.5039 9.33984 11.0977H8.25586ZM8.20898 12.9551C8.20898 12.7793 8.26172 12.6328 8.36719 12.5156C8.47656 12.3945 8.63672 12.334 8.84766 12.334C9.05859 12.334 9.21875 12.3945 9.32812 12.5156C9.4375 12.6328 9.49219 12.7793 9.49219 12.9551C9.49219 13.1309 9.4375 13.2773 9.32812 13.3945C9.21875 13.5078 9.05859 13.5645 8.84766 13.5645C8.63672 13.5645 8.47656 13.5078 8.36719 13.3945C8.26172 13.2773 8.20898 13.1309 8.20898 12.9551Z"
										fill="#868B94"></path>
  	  </svg>
							</a>
						</div>
					</nav>
				</div>
				<section class="Chatlist-box">
					<div class="empty-box">
						<!-- -------------------------------------------------------------------------------------- -->
					</div>


					<!-- chat Form -->

					<div id="nav-list">
						<tr>
							<td><input type="text" name="user" id="user"
								placeholder="유저명" /></td>
							<td>
								<button type="button" class="btn btn-default" id="btnConnect">연결</button>
							</td>
							<a>전재성</a>
							<%-- <c:when test="${chat.status eq '대기중'}"> --%>
								<span class="badge bg-success text-white rounded-pill ">대기중</span>
<%-- 							</c:when> --%>

							<button type="button" class="btn btn-default" id="btnDisconnect">
								<!-- 연결 끊기 -->

								<svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"
									fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
  					<path
										d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
 					 <path
										d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
					</svg>
							</button>
						</tr>
					</div>
					<tr>
						<td colspan="2"><div id="list"></div></td>
					</tr>
					<form class="css-1ckh9yi">
						<tr>
							<!-- send -->
							<td colspan="2"><input type="text" name="msg" id="msg"
								placeholder="대화 내용을 입력하세요."></td>
						</tr>
						<div class="chatform-option-area">
							<div class="chatform-submenu">
								<label class="option-wrapper"> <span
									class="option-tooltip">사진</span> <svg width="20" height="20"
										viewBox="0 0 20 20" fill="none"
										xmlns="http://www.w3.org/2000/svg">
  										<svg xmlns="http://www.w3.org/2000/svg" width="16"
											height="16" fill="currentColor" class="bi bi-images"
											viewBox="0 0 16 16">
												<path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
													<path
												d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z" />
												</svg>
  													<rect width="20" height="20" rx="3"></rect>
										  				<path
											d="M6 9C7.10457 9 8 8.10457 8 7C8 5.89543 7.10457 5 6 5C4.89543 5 4 5.89543 4 7C4 8.10457 4.89543 9 6 9Z"
											fill="white"></path>
										  				<path d="M3 16L6.5 12L10 16" fill="white"></path>
										  				<path d="M7 16L12 10L17 16" fill="white"></path>
													</svg> <input type="file" multiple=""
									accept="image/png, image/jpeg, image/gif">
								</label> <label class="option-wrapper "> <span
									class="option-tooltip">자주 쓰는 문구</span> <svg
										xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-chat-left-text-fill"
										viewBox="0 0 16 16">
													  <path
											d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H4.414a1 1 0 0 0-.707.293L.854 15.146A.5.5 0 0 1 0 14.793V2zm3.5 1a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 2.5a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1h-9zm0 2.5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 0-1h-5z" />
													</svg>
								</label> <label class="option-wrapper"> <span
									class="option-tooltip">위치 공유</span>
									<div class="option-wrapper  css-1f5m7zv">
										<button class="sticker-button" type="button">
											location
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-geo-alt-fill"
												viewBox="0 0 16 16">
													  <path
													d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
													</svg>
										</button>


									</div>
								</label>
							</div>
							<input type=text class="disable css-1useanf" aria-disabled="true"
								placeholder=" 전송"></input>
						</div>
						</button>
			</div>
			<!-- 채팅창 -->
			<script>
				//채팅 서버 주소
				let url = "ws://localhost:8080/chat/chatServer";
				// 웹 소켓
				let ws;
				// 연결하기	
				$('#btnConnect').click(function() {
									// 유저명 확인
									console.log('입장');
									if ($('#user').val().trim() != '') {
										//연결
										ws = new WebSocket(url);
										//소켓 이벤트 매핑
										ws.onopen = function(evt) {
											// console.log('서버 연결 성공');
											print($('#user').val(), '입장했습니다.');

											// 현재 사용자가 입장했다고 서버에게 통지(유저명 전달)
											// -> 1#유저명
											ws.send('1#' + $('#user').val()+ '#');
											$('#user').attr('readonly', true);
											$('#btnConnect').attr('disabled',true);
											$('#btnDisconnect').attr('disabled', false);
											$('#msg').attr('disabled', false);
											$('#msg').focus();
										};
										ws.onmessage = function(evt) {
											// print('', evt.data);
											let index = evt.data.indexOf("#", 2);
											let no = evt.data.substring(0, 1);
											let user = evt.data.substring(2,index);
											let txt = evt.data.substring(index + 1);
											if (no == '1') {
												print2(user);
											} else if (no == '2') {
												print(user, txt);
											} else if (no == '3') {
												print3(user);
											}
											$('#list').scrollTop(
											$('#list').prop('scrollHeight'));
										};
										ws.onclose = function(evt) {
										console.log('소켓이 닫힙니다.');
										};
										ws.onerror = function(evt) {
										console.log(evt.data);
										};
									} else {
										alert('유저명을 입력하세요.');
										$('#user').focus();
									}
								});
				// 메세지 전송 및 아이디
				function print(user, txt) {
					let temp = '';
					temp += '<div style="margin-bottom:5px;font-size: 17px; text-align: right; padding: 5px 12px; margin-right: 6px;">';
					temp += '[' + user + '] '; /*DB테이블 유저 정보 기입*/
					temp += txt;
					temp += ' <span style="font-size:11px;color:#777;">'
							+ new Date().toLocaleTimeString() + '</span>';
					temp += '</div>';

					$('#list').append(temp);
				}

				// 다른 client 접속		
				function print2(user) {
					let temp = ' ';
					temp += '<div style="margin-bottom:3px;">';
					temp += "'" + user + "' 이(가) 접속했습니다.";
					temp += ' <span style="font-size:11px;color:#777;">'
							+ new Date().toLocaleTimeString() + '</span>';
					temp += '</div>';

					$('#list').append(temp);
				}

				// client 접속 종료
				function print3(user) {
					let temp = ' ';
					temp += '<div style="margin-bottom:3px;">';
					temp += "'" + user + "' 이(가) 종료했습니다.";
					temp += ' <span style="font-size:11px;color:#777;">'
							+ new Date().toLocaleTimeString() + '</span>';
					temp += '</div>';

					$('#list').append(temp);
				}

				$('#user').keydown(function() {
					if (event.keyCode == 13) {
						$('#btnConnect').click();
					}
				});

				$('#msg').keydown(
						function() {
							if (event.keyCode == 13) {

								//서버에게 메시지 전달
								//2#유저명#메시지
								ws.send('#user' + $('#user').val() + '#'
										+ $(this).val()); //서버에게
								print($('#user').val(), $(this).val()); //본인 대화창에

								$('#msg').val('');
								$('#msg').focus();

							}
						});

				$('#btnDisconnect').click(function() {
					ws.send('3#' + $('#user').val() + '#');
					ws.close();

					$('#user').attr('readonly', false);
					$('#user').val('');

					$('#btnConnect').attr('disabled', false);
					$('#btnDisconnect').attr('disabled', true);

					$('#msg').val('');
					$('#msg').attr('disabled', true);
				});
			</script>
	</div>
	</form>
	</div>
	</section>
	</div>
	</div>

	<!-- -------------------------------------------------------------------------------------- -->
	<!-- <div class="css-1oteowz">
  			<div class="css-up958c"> 
  						</div>
  						</div>-->
	</main>
	<div></div>
	</div>
	</div>
	<div id="popupRoot"></div>
	<div id="modalRoot"></div>
</body>
</html>

