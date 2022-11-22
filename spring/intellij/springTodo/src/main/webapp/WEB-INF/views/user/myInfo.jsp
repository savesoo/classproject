<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-22
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Information</title>
</head>
<style>
    td{
        padding: 5px;
    }
    img{
        height: 50px;
    }
</style>
<body>

    <h1>로그인 회원 정보</h1>

    <form method="post">
        <table>
            <c:if test="${loginInfo != null}">
            <tr>
                <td>프로필 사진 </td>
                <td><img src="/uploadfile/userfile/${loginInfo.userProfile}"></td>
            </tr>
            <tr>
                <td>아이디 </td>
                <td>${loginInfo.userID}</td>
            </tr>
            <tr>
                <td>이름 </td>
                <td>${loginInfo.userName} </td>
            </tr>
            </c:if>
            <tr>
                <td><input type="submit" value="My TodoList"></td>
                <td><button><a href="/user/logout">LOGOUT</a></button></td>
            </tr>
        </table>

    </form>

${loginInfo}

</body>
</html>
