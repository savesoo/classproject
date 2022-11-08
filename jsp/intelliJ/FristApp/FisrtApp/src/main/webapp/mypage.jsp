<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-08
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
</head>
<body>

    <%

        String loginID = (String) session.getAttribute("loginID"); // 세션 안에 속성 있나요?

        if(loginID==null) {
            response.sendRedirect("login.html"); // 로그인 결과가 null이면 로그인 페이지로
        }

    %>

   <h1>로그인 후 보여주는 페이지 : <%= loginID%></h1>
    <a href="logout.jsp">로그아웃</a>

</body>
</html>
