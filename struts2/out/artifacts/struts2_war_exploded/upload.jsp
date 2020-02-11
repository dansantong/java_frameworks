<%--
  Created by IntelliJ IDEA.
  User: dansan
  Date: 2020/2/4
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        上传文件：<input type="file" name="doc"/>
        <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
