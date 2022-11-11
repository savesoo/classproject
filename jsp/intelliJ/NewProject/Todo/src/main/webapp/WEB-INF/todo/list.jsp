<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>


  <h1>Todo List</h1>
  <ul>
    <c:forEach var="num" begin="1" end="10" varStatus="stat">
      <li><input type="checkbox" name="todoItem" value="num"><a href="/read?tno=${num}">${stat.index}</a> Todo Title 2022-11-10 DONE</li>
      <hr>
    </c:forEach>
  </ul>

  <button><a href="/register">목록에 추가하기</a></button>
  <button><a href="/logout">LOGOUT</a></button>

</body>
</html>
