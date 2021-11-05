<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 04/11/2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<form action='fileUploadServlet' method='POST' enctype='multipart/form-data'>
    <%--@declare id="file"--%><label for="file">Last opp bilde</label>
    <input type='file' name='file'/>
</form>
</body>
</html>

