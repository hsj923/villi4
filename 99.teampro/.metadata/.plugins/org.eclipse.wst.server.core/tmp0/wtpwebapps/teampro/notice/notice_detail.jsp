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
<style>
	.input-group mb-3 { background-color : white; }
</style>
<body>
<header>
	<div class="container">
		<div class="row align-items-start mt-3 p-3">
		  <div class="col mt-2"><a href="#"><i class="fas fa-calendar fa-3x"></i></a></div>
		  <div class="col" align="center"><a href="index.jsp"><img src="resources/images/logo.png" alt="logo" width=90px height=90px ></a></div>
		  <div class="col mt-2 text-end"><a href="#"><i class="fas fa-heart fa-3x"></i></a>
		  <span class="mx-4"><a href="login.do"><i class="fas fa-user fa-3x"></i></a></span>
		  <span><a href="#"><i class="fas fa-search fa-3x"></i></a></span>
		  </div>
	<hr />	
		</div>
	</div>
	<script>
		function deleteNotice() {
			if(confirm("공지를 삭제하겠습니까?")) {
		    	self.location.href = "deleteNotice.do?noti_seq=${ notice.noti_seq }";
		    }
		}
	</script>
</header>
	<div class="container"  align="center">
		<div class="mt-4 p-5 bg-primary text-white rounded">
			<h3>공지사항 상세</h3>
	    	<!-- a href="logout.do" class="col-1 btn btn-primary me-2">로그아웃</a> -->
		</div>
	</div>		

	<div class="container mt-3" align="center">
		<form action="updateNotice.do" method="post">
			<input name="noti_seq" type="hidden" value="${notice.noti_seq}" readonly/>
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-address-book"></i></span>
  				<input type="text" class="form-control" name="title" value="${ notice.noti_title }" readonly>
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text"><i class="fas fa-clipboard"></i></span>
			  <textarea class="form-control"  name="noti_content" rows="20" readonly>${ notice.noti_content }</textarea>
			</div>	
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-calendar"></i></span>
  				<input type="text" class="form-control" name="date" value="${notice.noti_regDate }" readonly>
			</div>
			
			
		    <!-- input type="submit" class="btn btn-primary" value="글수정" -->
			<%-- <a href="deleteBoard.do?seq=${board.seq }" class="btn btn-primary">글삭제</a> --%>
		    
			<a href="notice/notice_insert.jsp" class="btn btn-primary">글등록</a>
			<a href="getNoticeList.do" class="btn btn-danger"  onclick="deleteNotice()">글삭제</a>
			<a href="getNoticeList.do"" class="btn btn-primary">글목록</a>
		</form>			
	</div>

</body>
</html>
