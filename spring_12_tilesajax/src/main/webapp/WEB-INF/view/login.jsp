<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#submit').on('click', function(e) {
			if ($('#id').val() == '') {
				alert("아이디를 입력해 주세요.");
				e.preventDefault();
			}
			if ($('#pass').val() == '') {
				alert('비밀번호를 입력해주세요.')
				e.preventDefault();
			}
		})
	});
</script>
</head>
<body>
	<div align="center">
		<form action="loginProcess.do" method="post">
			<input type="text" name="id" id="id" />
			<input type="text" name="pass" id="pass" />
			<input type="submit" value="submit" id="submit" />
		</form>
	</div>

</body>
</html>