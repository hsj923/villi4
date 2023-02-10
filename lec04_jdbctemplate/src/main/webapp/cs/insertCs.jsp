<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <title>Villi : 공지사항 작성</title>
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

nav {
	background-color: #FFF;
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

</style>



</head>
<body>


<!-- ===========header================ -->
	<header class="border-bottom border-white">
		<div class="container">
			<div class="row align-items-start p-3">
		
				
				<div class="col mb-3">
					<a href="getBoardList.do"><img src="resources/images/test.png"
						alt="logo" width=70px height=70px></a>
				</div>

				<div class="col mt-3 text-end r_menu">
						<span class=mx-2><a href="#" style="text-decoration:none" class="text-dark">좋아요</a> </span> 
						<span class=mx-1><a href="getUserList.do" style="text-decoration:none" class="text-dark">마이페이지</a></span>
						<span class=mx-1><a href="location/infoVilli.jsp" style="text-decoration:none" class="text-dark">동네정보</a></span>  
						<span class="mx-2">${ sessionScope.user.getNickname() }님</span>
				</div>
			</div>
		</div>
	</header>


<!----------- 본문 ----------->

   <div class="container my-4" align="center">
   
	  <h3 class="fw-bold">1:1 문의글 작성</h3>	
	</div>
	<hr>

	<div class="container mt-5" align="center">
		<form action="insertCs.do" method="post" enctype="multipart/form-data">
			
			<div class="input-group mb-3 w-75">
			 	<input type="hidden" class="form-control" name="writer" value="${ user.getNickname() }" >
			</div>
			
			<div class="input-group mb-3 w-75">
  				<input type="text" class="form-control" name="title" placeholder="문의 제목을 입력하세요">
			</div>
			
			<div class="input-group mb-3 w-75">
			  <textarea class="form-control"  name="content" rows="20" placeholder="문의 내용을 입력하세요"></textarea>
			</div>	
			
			<label for="formFile" class="form-label">파일 업로드</label>	
			
			<div class="input-group mb-3 w-75">
				<input type="file" class="form-control" name="uploadFile1"
					id="uploadFile1" aria-describedby="uploadFile" aria-label="Upload">
			</div>
			
			<input type="hidden" name="fileName" value="" />
				
		    <input type="submit" class="btn btn-dark mx-2 mt-3" value=" 1:1 문의글 등록" />
		    <button type="button" class="btn btn-dark mx-2 mt-3" onclick="history.go(-1)">이전</button>
		</form>	
	</div>
</body>
</html>