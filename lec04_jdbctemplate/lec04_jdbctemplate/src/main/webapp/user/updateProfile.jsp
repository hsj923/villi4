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
   
   <form action="updatePro.do" method="post" enctype="multipart/form-data">
   
 <label for="inputProfile" class="mt-3">* 프로필 사진</label>
		  <div class="col-2 input-group mb-3 mt-2"> 
		  
		  <c:if test="${ !empty  user.getFileName()}">
			<div class="select_img"><img src="/img/${ user.getFileName() }" class="rounded-circle border border-dark" width="80" height="80" alt="img"></div>
		  </c:if>
		  
		  <c:if test="${ empty user.getFileName()}">
		  	<div class="select_img">
				<img src="/img/noimg.png" class="rounded-circle border border-dark" width="80" height="80" alt="img">
		  	</div>
		  </c:if>
		  
		  </div>
		  
		  <input type="file" class="form-control mb-3" name="uploadFile"
					id="uploadFile" aria-describedby="uploadFile" aria-label="Upload">
		 <input type="hidden" name="fileName" value="" />
		 
    <!-- 이메일 수정 -->	
    	 
    <input type="text" name="email" value="${user.getEmail() }"  readonly>
  	
    이름 : ${ user.getName()}
	
	 <input type="text" name="nickname" value="${user.getNickname() }" >
   
   	 <input type="password" name="password" placeholder="비밀번호" >

	<input type="submit" class="btn btn-dark mx-4 mt-2 btn_radius"  value="수정하기" />
 </form>
    
      
	      
</body>
</html>