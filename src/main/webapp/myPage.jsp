<%@ page import="bacit.web.Models.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "styles/navbar.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<h1>MIN SIDE</h1>
<br><br><br><br><br><br><br><br><br><br><br>
<%@include file="jspHelpers/navbarMain.jsp"%>

<%
    UserModel user = (UserModel) request.getAttribute("user");
%>

<div>
    <a><%=user.getUserName()%></a>
    <a><%=user.getFirstName()%></a>
    <a><%=user.getLastName()%></a>
    <a><%=user.getPhone()%></a>
    <div>
    <a href = "<%=request.getContextPath()%>/minSide/redigerPassord">
        <button type = submit>Rediger Passord</button>
    </a>
    </div>

</div>

</body>
</html>
