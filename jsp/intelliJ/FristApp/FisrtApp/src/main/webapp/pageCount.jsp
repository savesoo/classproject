<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-08
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <%

    String cntStr = (String) application.getAttribute("cnt"); // 오브젝트를 반환하므로 형변환
    // 서버가 종료되지 않으면 cnt값은 계속 유지
    int cnt = cntStr == null ? 0 : Integer.parseInt(cntStr);

    out.print("페이지 방문 수 : " + cnt); // 내가 현재 방문했으므로

    application.setAttribute("cnt", String.valueOf(++cnt)); // 다음에 출력할 때는 증가시켜줌

  %>

</body>
</html>
