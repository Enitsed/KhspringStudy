<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memPro</title>
</head>
<body>
	<p>Member data</p>
	<p>이름 : ${name}</p>
	<p>나이 : ${age }</p>
	<hr />

	<!-- 반드시 첫글자는 소문자로 써야한다. -->
	<p>이름:${memDTO.name }</p>
	<p>나이:${memDTO.age }</p>
	<hr />

	<!-- 앞서 컨트롤레의 @ModelAttribute 으로 지정한 이름으로 객체를 호출한다. -->
	<p>이름:${dto.name }</p>
	<p>나이:${dto.age }</p>

</body>
</html>