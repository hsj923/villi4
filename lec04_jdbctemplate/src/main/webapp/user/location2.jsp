<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>



//위치정보 사용
function getLocation() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(getAddressByCoords,redirectLocation, geo_options);
       //navigator.geolocation.getCurrentPosition(successCallback,errorCallback,{ timeout: 10_000 });
	} else {
		location.href = "/selectAddressList.do";
	}
}

//성공했을 때
function getAddressByCoords(position) {
	var longitude = position.coords.longitude;
	var latitude = position.coords.latitude;
	console.log(longitude);
   console.log(latitude);
   //★★위도 경도 정보를 가지고 서버 사이드로 넘어가는 부분
	location.href = "/selectAddressList.do?longitude=" + longitude + "&latitude=" + latitude;
}

//에러났을 때
function redirectLocation(error) {
	location.href = "/selectAddressList.do";
}

//타임아웃
var geo_options = {
	maximumAge        : 5000, 
	timeout           : 3000
};

</script>

<div class="container col-3 mt-4">
		<form>
			<div class="col-2 input-group mb-3">
				<div class="input-group-text">주소</div>
				<input type="text" name="id" class="form-control" value="${ address_name }" >
			</div>
		</form>			
	</div>			
		

</body>
</html>