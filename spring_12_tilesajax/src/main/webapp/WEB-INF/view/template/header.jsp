<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 align="center">Spring Tiles Examples!!</h2>

<div align="right">
	<c:choose>
		<c:when test="${empty dto }">
			<a href="login.do">로그인</a>
			<a href="join.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="index.do">어서오세요. ${dto.id }님</a>
		</c:otherwise>
	</c:choose>
</div>
