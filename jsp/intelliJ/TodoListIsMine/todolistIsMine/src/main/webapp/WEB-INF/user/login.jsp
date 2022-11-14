<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
</head>

<body>
<h1>로그인 페이지</h1>
<form action="/login" method="post">

    <table>
        <tr>
            <td>아이디 </td>
            <td> <input type="text" name="userID"></td>
        </tr>
        <tr>
            <td>비밀번호 </td>
            <td><input type="password" name="userPW"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="로그인">
                <button>회원 가입</button>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a href="#">비밀번호 찾기</a></td>
        </tr>
    </table>

</form>

</body>
</html>
