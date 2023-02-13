<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Villi : 프로필 수정</title>
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
	
</style>
	
	<!-- 비밀번호 확인 스크립트 -->
	<script type="text/javascript">
		
	function passConfirm(){
		
		var password = document.getElementById("password");  // 비밀번호
		var passwordConfirm = document.getElementById("passwordCheck"); //비밀번호 확인값
		var confirmMsg = document.getElementById('confirmMsg'); //확인메세지
		var correctColor = "#23dbc9"; // 일치할 때 출력되는 색
		var wrongColor = "#F0614B";    // 틀렸을 때 출력되는 색
		
		if(password.value == passwordConfirm.value){
			confirmMsg.style.color = correctColor; 
			confirmMsg.innerHTML = "비밀번호가 일치합니다";
			$('#passwordCheck').attr("check_pw", "success");
			
		}else{
			confirmMsg.style.color = wrongColor;
			confirmMsg.innerHTML = "비밀번호가 일치하지 않습니다.";
		}
	};
		
		
	</script>

	<script type="text/javascript">
 
		function checkResult(){
	 
	 if($('#passwordCheck').attr("check_pw") == "fail"){
		 alert("비밀번호를 확인해주시기 바랍니다.");
		 $('#passwordCheck').focus();
		 return false;
	 }
 }


</script>


<style type="text/css">

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
					<span class= mx-2><a href="#">좋아요</a> </span>
					<span class= mx-1><a href="user/mypage.jsp">마이페이지</a></span>
					<span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				</div>
			</div>
		</div>
	</header>
	
	<!------------------ 본문 --------------------->
	
	<div class="container col-5 mt-4">
	<h3 class="fw-bold">프로필 수정</h3>
	<hr/>
		<form:form role="form" action="updateUser.do" method="post" onSubmit="return checkResult();" >
			
			
			<input type="hidden" name="email" value="${user.getEmail()}">
			<input type="hidden" name="curPage" value="${searchVO.getCurPage()}">
			<input type="hidden" name="rowSizePerPage" value="${searchVO.getRowSizePerPage()}">
			<input type="hidden" name="searchCategory" value="${searchVO.getSearchCategory()}">
			<input type="hidden" name="searchType" value="${searchVO.getSearchType()}">
			<input type="hidden" name="searchWord" value="${searchVO.getSearchWord()}">
		 
		 
		 <!-- 프로필 사진 수정 -->
		 
		 <label for="inputProfile" class="mt-3">* 프로필 사진</label>
		  <div class="col-2 input-group mb-3 mt-2"> 
		  
		   <c:if test="${ !empty  user.fileName}">
			<img src="resources/images/${ user.fileName }" class="rounded-circle border border-dark" width="80" height="80" alt="img">
		  </c:if>
		  
		  
		  <c:if test="${ empty user.fileName}">
			<img src="resources/images/noimg.png" class="rounded-circle border border-dark" width="80" height="80" alt="img">
		  </c:if>
		  
		 
		  </div>
		  
		  <input type="file" class="form-control mb-3" name="uploadFile"
					id="uploadFile" aria-describedby="uploadFile" aria-label="Upload">
		 
			 
			 
		  <!--  아이디 입력칸, 변경불가  : 아마도 이메일로 바뀜  -->
		  
			<label for="inputEmail" class="mt-2">* 이메일 주소</label>
			    
			<div class="col-2 input-group mb-3 mt-2" >
				<input type="text" name="email" class="form-control" value="${ user.getEmail() }" disabled>
			</div>

		  <!-- 이름 변경 불가 -->

			<label for="inputEmail" class="mt-2">* 이름</label>
			    
			<div class="col-2 input-group mb-3 mt-2" >
				<input type="text" name="email" class="form-control" value="${ user.getName() }" disabled>
			</div>

			<!-- 닉네임 변경  --> 
			
			<label for="inputName" class="mt-2">* 닉네임</label>
			
			<div class="col-2 input-group mb-3 mt-2">
				<input type="text" name="nickname" class="form-control" value="${ user.getNickname() }">
			</div>
			
			
			<!--  비밀번호 변경 1 -->
			
			<label for="inputPassword" class="mt-2">* 비밀번호</label>
			
			<div class="col-2 input-group mb-3 mt-2">
				<input type="password" name="password"  id="password" class="form-control " placeholder="비밀번호" required >
			</div>
			
			<!--  비밀번호 변경 2 -->
			
			<label for="inputPassword" class="mt-2">* 비밀번호 확인</label>
			
			<div class="col-2 input-group mb-3 mt-2">
				<input type="password"  id="passwordCheck" class="form-control" placeholder="비밀번호 확인" onkeyup="passConfirm();" check_pw="fail" required >
			</div>
			
			<span id="confirmMsg"></span>
			
			
		<!--  <div class="col-2 mb-3 form-check start-0">
			    <input type="checkbox" class="form-check-input" name="role" ${ user.getRole().toUpperCase() == "ADMIN" ? "checked" : "" }>
			    <label class="form-check-label" for="role">Administrator</label>
			</div>
		  -->
		  
			<div class="container btn_box mt-5" align="center">
				
				<input type="submit" class="btn btn-dark mx-4 btn_radius"  value="수정하기" onClick="location.href='user/mypage.jsp'"/>
			<!-- 	<a href="logout.do" class="btn btn-dark mx-4 btn_radius">로그아웃</a> -->
						
			</div>	
			
		</form:form>	
		
				
	</div>	
</body>
</html>