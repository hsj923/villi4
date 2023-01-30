<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <title>mypage</title>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">   
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" 
      integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" 
      crossorigin="anonymous">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>   
   <style>
   
   
   
   
   #mem_info { margin-left : 450px; }
   #bg_admin{ margin-left : 15px; }
   
   
   
   

@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

body{
font-family: 'Pretendard-Regular';}


</style>

</head>
<body>
                   <!-- ===========header================ -->
 <header>
	<div class="container border-bottom border-dark">
		<div class="row align-items-start mt-3 p-3 opacity-100">
		  <div class="col mt-2"><a href="#"><i class="fas fa-calendar fa-3x text-dark"></i></a></div>
		  <div class="col" align="center"><a href="mainpage.jsp"><img src="resources/images/logo.png" alt="logo" width=90px height=90px ></a></div>
		  
		  <div class="col mt-2 text-end"><a href="#"><i class="fas fa-heart fa-3x text-dark"></i></a>
		  <span class="mx-4"><a href="login.do"><i class="fas fa-user fa-3x text-dark"></i></a></span>
		  <span><a href="#"><i class="fas fa-search fa-3x text-dark" ></i></a></span>	
		  </div>
		</div>
	</div>	
</header>


     <div class="container mt-3" id="mem_info">
        
        <h3>${ sessionScope.user.getName() }님</h3>
      
   
      <br />
      </div>
      <br />
      <div class="container mt-3" align="left">
        <ul class="list-group list-group-flush">
          <a href="#" class="list-group-item">채팅 리스트</a>
          <a href="#" class="list-group-item">대여내역</a>
          <a href="#" class="list-group-item">찜리스트</a>
          <a href="#" class="list-group-item">내가 쓴 글 목록</a>
       </ul>
       <hr />
       </div>
       <div class="container mt-3" align="left">
       <ul class="list-group list-group-flush">
          <a href="#" class="list-group-item">공지사항</a>
          <a href="location.jsp" class="list-group-item">내 동네 설정</a>
          <a href="#" class="list-group-item">고객센터</a>
         
       </ul>
       </div>
</body>
<footer>
   <div class="container" align="right">
   <br />
   <br />
   <br />
      <a href="logout.do" class="btn btn-info">로그아웃</a>
   </div>
</footer>

      
      
   </div>      
</body>
</html>