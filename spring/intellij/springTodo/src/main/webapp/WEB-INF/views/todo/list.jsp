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
<style>
  td{
    padding: 10px;
  }
</style>
<body>

  <h1>Todo List</h1>

  <table>
    <tr>
      <td>번호</td>
      <td>할일</td>
      <td>기간</td>
      <td>완료여부</td>
    </tr>

    <c:forEach var="todo" items="${todoList}">
      <tr>
        <td>${todo.tno}</td>
        <td><a href="/todo/read?tno=${todo.tno}">${todo.todo}</a></td>
        <td>${todo.dueDate}</td>
        <td>${todo.finished ? '완료': '진행중'}</td>
      </tr>
    </c:forEach>

  </table>

  <button><a href="/todo/register">목록에 추가하기</a></button>
  <button><a href="/user/logout">LOGOUT</a></button>

</body>
</html>
