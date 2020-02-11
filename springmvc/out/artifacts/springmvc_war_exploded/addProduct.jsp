<%--
  Created by IntelliJ IDEA.
  User: dansan
  Date: 2020/2/8
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>addProduct</title>
</head>
<body>
    <form action="addProduct" method="post">
        产品名称：<input type="text" name="name" value=""/><br>
        产品价格：<input type="text" name="price" value=""/><br>
        <input type="submit" value="添加产品"/>
    </form>
</body>
</html>
