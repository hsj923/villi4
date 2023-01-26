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
	<div class="container"  align="center">
		<div class="mt-4 p-5 bg-primary text-white rounded">
			<h3>고객 문의 상세 페이지</h3>
		</div>
	</div>		

	<div class="container mt-3" align="center">
		<form action="updateCs.do" method="post">
			<input name="cs_num" type="hidden" value="${csitem.cs_num}" />
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-address-book"></i></span>
  				<input type="text" class="form-control" name="cs_title" value="${ csitem.cs_subject }" disabled>
			</div>
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-user"></i></span>
  				<input type="text" class="form-control" name="cs_writer" value="${ csitem.cs_name }" disabled>
			</div>
			
			<div class="input-group mb-3">
			  <span class="input-group-text"><i class="fas fa-clipboard"></i></span>
			  <textarea class="form-control"  name="cs_content" rows="15" disabled>${ csitem.cs_content }</textarea>
			</div>	
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-calendar"></i></span>
  				<input type="text" class="form-control" name="writer" value="${csitem.cs_date }" disabled>
			</div>
			
			<div class="input-group mb-3">
  				<span class="input-group-text" id="desc_title"><i class="fas fa-hashtag"></i></span>
  				<input type="text" class="form-control" name="writer" value="${ csitem.cs_file }" disabled>
			</div>
			
		    <input type="submit" class="btn btn-primary" value="글수정" />
			<a href="cs/cs_reply.jsp" class="btn btn-primary">답글 등록</a>
			<%-- <a href="deleteBoard.do?seq=${board.seq }" class="btn btn-primary">글삭제</a> --%>
			<a href="#" class="btn btn-danger"  onclick="deleteCs()">글삭제</a>
			<a href="getCsList.do" class="btn btn-primary">글목록</a>
		</form>			
	</div>
</body>
</html>
