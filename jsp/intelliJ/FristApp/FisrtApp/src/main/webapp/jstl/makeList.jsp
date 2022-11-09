<%@ page import="com.firstcoding.fisrtapp.member.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-09
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <%
    List<Member> members = new ArrayList<>();
    members.add(new Member("light0", "1110", "LIGHT"));
    members.add(new Member("light1", "1111", null));
    members.add(new Member("light2", "1112", null));
    members.add(new Member("light3", "1113", "LIGHT"));
    members.add(new Member("light4", "1114", "LIGHT"));
    members.add(new Member("light5", "1115", null));
    members.add(new Member("light6", "1116", "LIGHT"));
    members.add(new Member("light7", "1117", "LIGHT"));
    members.add(new Member("light8", "1118", null));
    members.add(new Member("light9", "1119", null));

    session.setAttribute("members", members);

  %>

</body>
</html>
