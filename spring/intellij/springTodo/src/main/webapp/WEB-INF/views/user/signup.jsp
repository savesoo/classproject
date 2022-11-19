<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-14
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome to Join with Us</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<form method="post">

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
      <td>재입력 </td>
      <td><input type="password" name="checkPW"></td>
    </tr>
    <tr>
      <td>이름 </td>
      <td><input type="text" name="userName"></td>
    </tr>
  </table>

  <input type="submit" value="회원가입">
  <input type="reset" value="내용 초기화">

</form>

<c:if test="${param.fail == 'check'}">
  <script>
    alert("비밀번호가 서로 일치하지 않습니다.");
  </script>
</c:if>
${param.result}

</body>
</html>
