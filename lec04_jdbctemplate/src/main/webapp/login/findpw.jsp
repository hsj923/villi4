</html>   <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


	<title>비번찾기</title>
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

.find{
text-decoration:none;
color:black;
font-size: 13px;

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
		<form action="findpw.do" method="post">		
	<div class="container" align="center">
			<div class="modal-content">	
			
						
				<div class="modal-header bg-info text-white">
						<h1 class="motal-title fs-5" id="staticBackdropLabel" >비밀번호찾기</h1>
					</div> <!-- modal-header 끝-->
					
					
					
					<div class="modal-body">
						<div class="input-group mb-3">
							<div class="input-group-text"><i class="fas fa-envelope"></i></div>
							<input type="text" name="email" class="form-control"  required placeholder="이메일">
						</div>
						
						
						<div class="input-group mb-3">
							<div class="input-group-text"><i class="fas fa-lock"></i></div>
							<input type="text" name="name" class="form-control"  required placeholder="이름">
						</div>
						
			<div class="modal-footer ">
					
						<button type="submit" class="btn btn-info text-white" style= "width: 90px; height: 38px;" >찾기</button>
					
						
					
			
		</div>	

</div>

</div></div></form>

      
   </div>      
</body>
</html>   