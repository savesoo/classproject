<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-08
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate(); // 세션 정보 삭제
  response.sendRedirect("index.jsp"); // 로그아웃하고 메인페이지로 이동
%>
