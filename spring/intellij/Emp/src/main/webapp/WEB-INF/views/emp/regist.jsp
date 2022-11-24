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
              <td>관리자 번호</td>
              <td><input type="number" name="mgr"></td>
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
              <td><select name="deptno">
                <option value="10">10:ACCOUNTING</option>
                <option value="20">20:RESEARCH</option>
                <option value="30">30:SALES</option>
                <option value="40">40:OPERATIONS</option>
              </select>
              </td>
          </tr>
          <tr>
              <td></td>
              <td><input type="submit" value="제출"></td>
          </tr>

      </table>
  </form>


</body>
</html>
