<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="bodywrap">
		<!-- 리스트 출력 -->
		<table>
			<tr>
				<th width="5%">번호</th>
				<th width="45%">제목</th>
				<th width="25%">글쓴이</th>
				<th width="5%">조회수</th>
			</tr>
			<c:forEach var="dto" items="${aList }">
				<tr>
					<td>${dto.num }</td>
					<td>${dto.subject }</td>
					<td>${dto.writer }</td>
					<td>${dto.readcount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>