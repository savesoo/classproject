<%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-21
  Time: 오후 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SaerchForm</title>
</head>
<body>

  <div>
    인기검색어 :
    <c:forEach items="${keywords}" var="keyword"> <!-- 받을 수 있는 이름은 ModelAttribute에서 정의한 것-->
      ${keyword}
    </c:forEach>
  </div>

  <div>
    검색
    <select>

      <c:forEach items="${searhType}" var="type">
        <option>${type}</option>
      </c:forEach>

    </select>

    <input type="text">
    <input type="submit" value="검색">

  </div>

</body>
</html>
