<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<h2 align="center">회원가입</h2>

	<div align="center">
		<form action="joinProcess.do" method="post">
			<input type="text" name="id" />
			<input type="text" name="pass" />
			<input type="submit" value="submit" />
		</form>
	</div>
</body>
</html>