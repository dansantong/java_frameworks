<%--
  Created by IntelliJ IDEA.
  User: dansan
  Date: 2020/2/9
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>listCategory</title>
</head>
<body>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
