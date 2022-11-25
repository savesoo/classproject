<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-24
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Regist</title>
</head>
<body>
  <h1>신규 직원 등록</h1>
  <hr>

  <form method="post">

      <table>
          <tr>
              <td>사원번호</td>
              <td><input type="number" name="empno"></td>
          </tr>
          <tr>
              <td>이름</td>
              <td><input type="text" name="ename"></td>
          </tr>
          <tr>
              <td>직급</td>
              <td>
                  <select name="job">
                      <c:forEach items="${jobList}" var="job">
                          <option value="${job}">${job}</option>
                      </c:forEach>
                  </select>
              </td>
          </tr>
          <tr>
              <td>관리자 번호</td>
              <td>
                  <select name="mgr">
                    <c:forEach items="${empList}" var="mgr">
                      <option value="${mgr.empno}">${mgr.ename}</option>
                    </c:forEach>
                  </select>
              </td>
          </tr>
          <tr>
              <td>입사일</td>
              <td><input type="date" name="hiredate"></td>
          </tr>
          <tr>
              <td>연봉</td>
              <td><input type="number" name="sal"></td>
          </tr>
          <tr>
              <td>성과급</td>
              <td><input type="number" name="comm"></td>
          </tr>
          <tr>
              <td>부서번호</td>
              <td>
                  <select name="deptno">
                      <c:forEach items="${deptList}" var="dept">
                          <option value="${dept.deptno}"> ${dept.deptno}:${dept.dname} </option>
                      </c:forEach>
                  </select>
              </td>
          </tr>
          <tr>
              <td></td>
              <td><input type="submit" value="등록"></td>
          </tr>

      </table>
  </form>


</body>
</html>
