<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<form name="frm" method="post" action="logpro.do">
		<p>
			<label for="id">아이디</label>
			<input type="text"  name="id" />
		</p>

       <p>
        <label for="pass">비밀번호</label>
        <input type="text" name="pass" />
       </p>
       
       <p>
       <input type="text" name="returnUrl" 
                value="${param.returnUrl }" />
        <input type="submit" value="로그인" />
       </p>
	</form>
</body>
</html>