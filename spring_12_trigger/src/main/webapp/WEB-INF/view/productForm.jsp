<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
 <div>

  <form name="frm" action="productPro.do" method="get">
    <table>
     <caption>물품입력</caption>
    <tr>
     <th>상품코드</th>
     <td>
      <select name="code">
        <c:forEach items="${aList}" var="dto">
        <option value="${dto }"> ${dto}
        </c:forEach>
      </select>
     </td>
     </tr>
     
     <tr>
      <th>입고수량</th>
      <td><input type="text" name="incnt" /></td>
     </tr>
     
     <tr>
      <th>입고단가</th>
      <td><input type="text" name="inprice" /></td>
     </tr>
       
     <tr>
      <td colspan="2">
       <input type="submit" value="commit" />
     </td>
    </tr>
     </table>
  </form>
 </div>
</body>
</html>