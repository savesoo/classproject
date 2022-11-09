<%@ page import="com.firstcoding.fisrtapp.member.Member" %>
<%@ page import="com.firstcoding.fisrtapp.product.Product" %><%--
  Created by IntelliJ IDEA.
  User: E495
  Date: 2022-11-09
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 객체 생략시 탐색 순서 : request -> session -> application

    request.setAttribute("name", "류정한");
    session.setAttribute("name", "임혜영");

    Member member = new Member();
    member.setId("ryu");
    member.setPw("1234");
    member.setName("RYU");

    session.setAttribute("member", member);

    session.setAttribute("product", new Product());

%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h4> 표현식 : <%= request.getAttribute("name")%></h4>
    <h4> 표현언어 : ${requestScope.name} </h4>

    <h4> 표현식 : <%= request.getAttribute("id")%></h4>
    <h4> 표현언어 : ${requestScope.id} </h4>

    <h4> param ( code ) : ${param.code} </h4>

    <h4> pageContext : ${pageContext.request.requestURL} </h4>
    <h4> pageContext : ${pageContext.request.requestURI} </h4>
    <h4> pageContext : ${pageContext.request.contextPath} </h4>
    <h4> contextPath : <%= request.getContextPath()%> </h4>


    <h4> sessionScope ( name ) : ${sessionScope.name} </h4>
    <h4> ( name ) : ${name} </h4>

    <hr>

    ${true} / ${false} / ${100} / ${1.2} / ${'류정한'} / ${null}

    <hr>

    <h4>${sessionScope.member}</h4>
    <h4>
        ${member} / ${member.id} / ${member.pw} / ${member.name} / ${member.info}
    </h4>

    <hr>

    <h4> 첫번째 상품 : ${product.list[0]} , 가격 ${product.price} </h4>
    <h4> 두번째 상품 : ${product.list[1]} , 가격 ${product.price} </h4>

</body>
</html>
