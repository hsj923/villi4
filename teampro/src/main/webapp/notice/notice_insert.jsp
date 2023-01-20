<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <title>Spring Framework</title>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
      integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
      crossorigin="anonymous">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>   
</head>
<body>
<header>
	<div class="container">
		<div class="row align-items-start mt-3 p-3">
		  <div class="col mt-2"><a href="#"><i class="fas fa-calendar fa-3x"></i></a></div>
		  <div class="col" align="center"><a href="index.do"><img src="../resources/images/logo.png" alt="logo" width=90px height=90px ></a></div>
		  <div class="col mt-2 text-end"><a href="#"><i class="fas fa-heart fa-3x"></i></a>
		  <span class="mx-4"><a href="login.do"><i class="fas fa-user fa-3x"></i></a></span>
		  <span><a href="#"><i class="fas fa-search fa-3x"></i></a></span>
		  </div>
	<hr />	
		</div>
	</div>
</header>
   <div class="container" align="center">
		<div class="mt-4 p-5 bg-secondary text-white rounded">
			<h3>공지사항 작성</h3>	
		</div>
	</div>

	<div class="container mt-3" align="center">
		<form action="insertNotice.do" method="post" enctype="multipart/form-data">
			<div class="input-group mb-3">
  				<span class="input-group-text" id="noti_title"><i class="fas fa-address-book"></i></span>
  				<input type="text" class="form-control" name="noti_title" placeholder="공지사항 제목을 입력하세요">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text"><i class="fas fa-clipboard"></i></span>
			  <textarea class="form-control"  name="noti_content" rows="20" placeholder="공지사항 내용을 입력하세요"></textarea>
			</div>	
				
		    <input type="submit" class="btn btn-primary" value=" 공지사항 등록" />
		    <button type="button" class="btn btn-primary" onclick="history.go(-1)">공지사항 목록 가기</button>
		</form>	
	</div>
</body>
</html>