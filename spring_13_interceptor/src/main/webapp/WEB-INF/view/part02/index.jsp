<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/header.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var chk = '${empty sessionScope.chk}' == 'true' ? true : false;
		init(chk);
	});
</script>
</head>
<body>
	<p id="logInPage">
		<a href="login.do?returnUrl=${param.returnUrl }">로그인</a>
	</p>

	<p id="logOutPage">
		<a href="logout.do">로그아웃</a>
	</p>
	<div>
		<p>index page</p>
	</div>

</body>
</html>