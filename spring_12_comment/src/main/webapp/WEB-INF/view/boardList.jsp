<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<c:forEach items="${list }" var="board">
		<table>
			<thead>
				<tr>
					<th>Number</th>
					<th>Title</th>
					<th>Content</th>
					<th>Writer</th>
					<th>Date</th>
					<th>View Count</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${board.bno }</td>
					<c:url var="link" value="boardView.do">
						<c:param name="bno" value="${board.bno }"></c:param>
					</c:url>
					<td><a href="${link }">${board.title }</a></td>
					<td>${board.content }</td>
					<td>${board.writer }</td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" dateStyle="short"
							value="${board.regdate }" /></td>
					<td>${board.viewcnt }</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>

</body>
</html>