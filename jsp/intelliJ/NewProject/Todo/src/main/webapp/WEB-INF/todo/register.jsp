<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo 추가</title>
</head>
<body>

    <h1>Todo List 등록</h1>
    <form action="/register" method="post">

        해야할 일 <input type="text" name="title" placeholder="INSERT TITLE"> <br>
        마감일시 <input type="date" name="date"> <br>
        상세 <textarea name="todo" cols="10" rows="5"></textarea> <br>
        <input type="reset" value="RESET">
        <button>등록</button>

    </form>

</body>
</html>
