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
    <title>Employee Information Edit</title>
</head>
<body>
  <h1>사원 정보 수정</h1>
  <hr>

  <form method="post">

      <table>
          <tr>
              <td>사원번호</td>
              <td><input type="number" name="empno" value="${saved.empno}" readonly></td>
          </tr>
          <tr>
              <td>이름</td>
              <td><input type="text" name="ename" value="${saved.ename}"></td>
          </tr>
          <tr>
              <td>관리자 번호</td>
              <td><input type="number" name="mgr" value="${saved.mgr}"></td>
          </tr>
          <tr>
              <td>입사일</td>
              <td><input type="date" name="hiredate" value="${saved.hiredate}" readonly></td>
          </tr>
          <tr>
              <td>연봉</td>
              <td><input type="number" name="sal" value="${saved.sal}"></td>
          </tr>
          <tr>
              <td>성과급</td>
              <td><input type="number" name="comm" value="${saved.comm}"></td>
          </tr>
          <tr>
              <td>부서번호</td>
              <td>
                  <select name="deptno">
                    <option value="10" ${saved.deptno==10?"selected" : ""} >10:ACCOUNTING</option>
                    <option value="20" ${saved.deptno==20?"selected" : ""}>20:RESEARCH</option>
                    <option value="30" ${saved.deptno==30?"selected" : ""}>30:SALES</option>
                    <option value="40" ${saved.deptno==40?"selected" : ""}>40:OPERATIONS</option>
                  </select>
              </td>
          </tr>
          <tr>
              <td></td>
              <td><input type="submit" value="수정"></td>
          </tr>

      </table>
  </form>

  <form action="/emp/delete">
      <input type="submit" value="삭제">
      <input type="hidden" name="empno" value="${saved.empno}">
  </form>


</body>
</html>
