<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-10
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo 추가</title>
</head>
<body>

    <h1>Todo List 등록</h1>
    <form method="post">

        <table>
            <tr>
                <td>해야할 일 </td>
                <td><input type="text" name="todo" placeholder="INSERT TITLE"></td>
            </tr>
            <tr>
                <td>기한</td>
                <td><input type="date" name="dueDate"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="reset">
                    <input type="submit" value="등록">
                </td>
            </tr>
        </table>

    </form>

</body>
</html>
