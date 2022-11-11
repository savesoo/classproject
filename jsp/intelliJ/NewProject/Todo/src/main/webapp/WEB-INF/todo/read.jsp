<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
    <h1>조회</h1>
    <form action="/remove" method="post">

        번호 < ${index}> <br>
        해야할 일 <input type="text" name="todo" placeholder="내용"> <br>
        마감일시 <input type="date" name="date"> <br>

        <button><a href="/modify">수정</a></button>
        <input type="submit" value="삭제">
        <button><a href="/list">List</a></button>

    </form>

</body>
</html>
