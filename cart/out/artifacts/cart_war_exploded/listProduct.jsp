<%--
  Created by IntelliJ IDEA.
  User: dansan
  Date: 2020/2/3
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>产品展示</title>
</head>
<body>
    <%--如果用户登录了，session中有user信息，就显示用户的名字--%>
    <c:if test="${!empty user}">
        <div align="center">
            当前用户：${user.name}
        </div>
    </c:if>

    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>名称</td>
            <td>价格</td>
            <td>购买</td>
        </tr>

        <c:forEach items="${products}" var="product" varStatus="st">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <form action="addOrderItem" method="post">
                        数量<input type="text" value="1" name="num">
                        <input type="hidden" name="pid" value="${product.id}">
                        <input type="submit" value="购买">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
