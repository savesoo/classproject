<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form action="/login" method="post">

    아이디 <input type="text" name="userID">
    비밀번호 <input type="password" name="userPW">
    이름 <input type="text" name="userName">

    <input type="submit" value="로그인">
</form>

</body>
</html>
