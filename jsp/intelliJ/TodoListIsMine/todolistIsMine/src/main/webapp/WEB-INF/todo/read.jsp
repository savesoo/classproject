<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>

    <h1>조회</h1>
    <form action="/remove" method="post">
        <table>
            <tr>
                <td>번호 </td>
                <td><input type="text" name="tno" value="${param.tno}" readonly></td>
            </tr>
            <tr>
                <td>해야할 일 </td>
                <td><input type="text" name="todo" value="${todo.todo}" readonly></td>
            </tr>
            <tr>
                <td>기한 </td>
                <td><input type="date" name="dueDate" value="${todo.dueDate}" readonly></td>
            </tr>
            <tr>
                <td>진행 상태 </td>
                <td><input type="checkbox" name="finished" ${todo.finished ? 'checked' : ''} ></td>
            </tr>
        </table>

        <button><a href="/modify?tno=${param.tno}">수정</a></button>
        <input type="submit" value="삭제">
        <button><a href="/list">List로</a></button>
    </form>

</body>
</html>
