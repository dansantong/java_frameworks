<%--
  Created by IntelliJ IDEA.
  User: dansan
  Date: 2020/2/5
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>editProduct</title>
</head>
<body>
    <form action="updateProduct" method="post">
        <table align="center" border="1" cellspacing="0">
            <tr>
                <td>name:</td>
                <td>
                    <input type="text" name="product.name" value="">
                </td>
            </tr>
            <tr>
                <td>price:</td>
                <td>
                    <input type="text" name="product.price" value="0">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="product.id" value="${product.id}">
                    <input type="submit" value="edit">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
