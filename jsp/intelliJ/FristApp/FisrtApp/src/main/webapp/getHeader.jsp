<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-08
  Time: 오후 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <%

    Enumeration<String> list = request.getHeaderNames();

    while (list.hasMoreElements()){
      String name = list.nextElement(); // Header 이름 출력
      String value = request.getHeader(name); // key 넣어서 value 받기

      out.print("<h3>");
      out.print(name + " = " + value);
      out.print("</h3>");

    }




  %>

</body>
</html>
