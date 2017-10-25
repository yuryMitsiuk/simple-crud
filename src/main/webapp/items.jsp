<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 10/6/17
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
    <a href="/index.html">Home</a>
    <br>
    <a href="items?action=create">Create</a>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Title</th>
            <th>Delivery</th>
            <th>Quantity</th>
            <th>Enabled</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <c:forEach items="${items}" var="item">
            <jsp:useBean id="item" scope="page" type="by.javaeducation.model.Item"/>
            <tr>
                <td>${item.title}</td>
                <td>${item.delivery}</td>
                <td>${item.quantity}</td>
                <td>${item.enable}</td>
                <td><a href="items?action=update&id=${item.id}">Update</a></td>
                <td><a href="items?action=delete&id=${item.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
