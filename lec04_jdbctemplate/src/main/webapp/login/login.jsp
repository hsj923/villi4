</html>   <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


	<title>villi login</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
		integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
		crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
<style>
.joinbtn{
text-decoration:none;
color:white;
}



</style>

</head>

<body>

                  <!-- ===========header================ -->
 <header>
	<div class="container border-bottom border-dark">
		<div class="row align-items-start mt-3 p-3 opacity-100">
		  <div class="col mt-2"><a href="#"><i class="fas fa-calendar fa-3x text-dark"></i></a></div>
		  <div class="col" align="center"><a href="index.jsp"><img src="resources/images/logo.png" alt="logo" width=90px height=90px ></a></div>
		  
		  <div class="col mt-2 text-end"><a href="#"><i class="fas fa-heart fa-3x text-dark"></i></a>
		  <span class="mx-4"><a href="login.do"><i class="fas fa-user fa-3x text-dark"></i></a></span>
		  <span><a href="#"><i class="fas fa-search fa-3x text-dark" ></i></a></span>	
		  </div>
		</div>
	</div>	
</header>





	<div class="container mt-5">
	<form action="login.do" method="post">		
		<div class="container" align="center">
		<div class="modal-content">	
				
						
					<div class="modal-header bg-info text-white">
						<h1 class="motal-title fs-5" id="staticBackdropLabel" >로그인</h1>
					</div> <!-- modal-header -->
					
					
					
					<div class="modal-body">
						<div class="input-group mb-3">
							<div class="input-group-text"><i class="fas fa-envelope"></i></div>
							<input type="text" name="email" class="form-control" id="email" required placeholder="이메일">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-text"><i class="fas fa-lock"></i></div>
							<input type="password" name="password" class="form-control" id="password" required placeholder="비밀번호">
						</div>
					
					
			<c:if test="${ sessionScope.matchedPassword != null && !sessionScope.matchedPassword }">
				<h5 class="bg-danger text-white">비밀번호가 틀립니다!!!</h5>
			</c:if>
				
				
						
					</div> <!-- modal-body -->
					
					<div class="modal-footer ">
					
					<div class="input-group mb-1">
							<a href="findpw.do" style="text-decoration:none;  "> 비밀번호를 잊으셨나요?</a>
					</div>
			
						<button type="submit" class="btn btn-info text-white" style= "width: 90px;" "height: 38px;" >로그인</button>
						<button type="button" class="btn btn-info text-white"> <a class="joinbtn"  href ="joinok.jsp" >회원가입</a></button>
						
						
						<!-- 소셜로그인 -->
						<a href="kakao_login.do"><img width="90" height="38"  src="resources/images/kakao_loginlogo.png"/></a>
						<a href="naver_login.do"><img width="90" height="38" src="resources/images/naver_login.png"/></a>
						</div>
					
					</div> <!-- modal-footer -->
				</div> <!-- modal-content -->
			</form>	
			
			
			



	</div>		
</body>
</html>		


















	
			
	
	<!-- 내꺼 
		<form action="login.do" method="post">		
		
          <div class="container" align="center">
          
	   			<div class="col me-3 input-group" style="width:300px;">
			      	<div class="input-group-text"><i class="fas fa-user"></i></div>
			      	<input type="text" name="email" class="form-control" id="email" placeholder="이메일">
			    </div>
		<br>
			    <div class="col me-3 input-group"  style="width:300px;">
			      <div class="input-group-text"><i class="fas fa-lock"></i></div>
			      <input type="password" name="password" class="form-control" id="password" placeholder="비밀번호"> 
	   			</div>
	    
	<br>
	
		<div style="width:100%; height:150px;">
	  		  	<div class="col me-5 float-sm-end" style="display:flex; flex-direction:column;align-items:center; justify-content:center; position:absolute;left:45%;">
			    	<button type="submit" class="btn btn-info">로그인하기</button>
			    	<button type="submit" class="btn btn-info" style="margin:10%;">회원가입</button>
			  
			<a href="kakao_login.do">
  			 <img width="150" height="33" src="resources/img/kakao_login.png"/>
			</a>
			</div>
	</div>
</div>
	
	
	
		</form>	
-->