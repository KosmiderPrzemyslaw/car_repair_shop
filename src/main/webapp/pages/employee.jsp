<%--
  Created by IntelliJ IDEA.
  User: przemysaw
  Date: 16.01.21
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th style="background: darkslategray" scope="col">Employee</th>
    </tr>
    <c:forEach items="${employee}" var="employe">
        <tr>
            <td>${employe}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
