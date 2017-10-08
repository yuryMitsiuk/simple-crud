<%--
  Created by IntelliJ IDEA.
  User: oem
  Date: 10/8/17
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <h2>${param.action == 'create' ? 'Create meal' : 'Edit meal'}</h2>
    <hr>
    <jsp:useBean id="item" type="by.javaeducation.model.Item" scope="request"/>
    <form method="post" action="items">
        <input type="hidden" name="id" value="${item.id}">
        <dl>
            <dt>Title:</dt>
            <dd><input type="text" value="${item.title}" size=40 name="title"></dd>
        </dl>
        <dl>
            <dt>Delivery:</dt>
            <dd><input type="datetime-local" value="${item.delivery}" name="delivery"></dd>
        </dl>
        <dl>
            <dt>Quantity:</dt>
            <dd><input type="number" value="${item.quantity}" name="quantity"></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</body>
</html>
