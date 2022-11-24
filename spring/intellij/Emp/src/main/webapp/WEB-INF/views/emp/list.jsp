<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-24
  Time: 오후 4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Emp List</title>
</head>
<style>
    tr{
        padding: 10px;
    }
    th{
        padding: 5px;
    }
</style>
<body>
  <h1>직원 리스트</h1>
  <hr><br>

  <table border="1">
      <tr>
          <th>사원번호</th>
          <th>이름</th>
          <th>직급</th>
          <th>관리자 번호</th>
          <th>입사일</th>
          <th>연봉</th>
          <th>성과급</th>
          <th>부서번호</th>
          <th>관리</th>
      </tr>

      <c:forEach items="${emplist}" var="emp">
      <tr>
          <td>${emp.empno}</td>
          <td>${emp.ename}</td>
          <td>${emp.job}</td>
          <td>${emp.mgr}</td>
          <td>${emp.hiredate}</td>
          <td>${emp.sal}</td>
          <td>${emp.comm}</td>
          <td>${emp.deptno}</td>
          <td><a href="/emp/edit?empno=${emp.empno}">정보 관리</a></td>
      </tr>
      </c:forEach>

  </table>
  <br>

  <button><a href="/emp/regist">사원 등록</a></button>


</body>
</html>
