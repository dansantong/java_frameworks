<%--
  Created by IntelliJ IDEA.
  User: dansan
  Date: 2020/2/8
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadImage</title>
</head>
<body>
    <form action="uploadImage" method="post" enctype="multipart/form-data">
        <!--accept表示只接收图片形式的上传-->
        选择图片：<input type="file" name="image" accept="image/*"/><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
