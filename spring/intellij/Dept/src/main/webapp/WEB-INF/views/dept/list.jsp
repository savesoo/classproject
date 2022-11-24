<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-24
  Time: 오후 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DeptList</title>
</head>
<style>
    tr{
        padding: 10px;
    }
</style>
<body>

    <h1>dept list</h1>
    <hr>

    <button><a href="/dept/register">부서 등록</a></button>
    <br>

    <table border="1">
        <tr>
            <th>부서 번호</th>
            <th>부서 이름</th>
            <th>부서 위치</th>
            <th>관리</th>
        </tr>

        <c:forEach items="${deptList}" var="dept">
        <tr>
            <td>${dept.deptno}</td>
            <td>${dept.dname}</td>
            <td>${dept.loc}</td>
            <td> <a href="/dept/edit?no=${dept.deptno}">수정</a> / <a onclick="deleteDept(${dept.deptno});" style="cursor: pointer">삭제</a></td>
        </tr>
        </c:forEach>
    </table>

<script>
    function  deleteDept(no){
        if(confirm("정말 삭제하시겠습니까?")){
            location.href = '/dept/delete?deptno='+no;
        }
    }
</script>

</body>
</html>
