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
    <title>Todo List Modify</title>
</head>
<body>

    <h1>Todo List 수정</h1>

    <form method="post">

        <table>
            <tr>
                <td>번호 </td>
                <td><input type="text" name="tno" value="${param.tno}"></td>
            </tr>
            <tr>
                <td>해야할 일 </td>
                <td><input type="text" name="todo" value="${todo.todo}"></td>
            </tr>
            <tr>
                <td>기한 </td>
                <td><input type="date" name="dueDate" value="${todo.dueDate}"></td>
            </tr>
            <tr>
                <td>진행 상태 </td>
                <td><input type="checkbox" name="finished" ${todo.finished ? 'checked' : ''} ></td>
            </tr>
        </table>

        <input type="reset">
        <input type="submit" value="수정 완료">

    </form>


    <form action="/todo/list">
        <input type="submit" value="List로">
    </form>

</body>
</html>
