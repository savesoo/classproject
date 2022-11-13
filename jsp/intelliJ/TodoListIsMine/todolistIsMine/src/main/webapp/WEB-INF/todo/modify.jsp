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
    <title>Todo List Modify/Remove</title>
</head>
<body>

    <h1>수정 및 삭제</h1>

    <form action="/modify" method="post">

        해야할 일 <input type="text" name="todo" placeholder="내용"> <br>
        마감일시 <input type="date" name="date"> <br>

        <input type="submit" value="수정">

    </form>

</body>
</html>
