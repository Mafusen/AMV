<%@ page import="bacit.web.Models.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 18/11/2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type = "text/css">
    <title>Slett bruker</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<br><br><br><br>
<%
    UserModel user = (UserModel) request.getAttribute("user");
%>
<h1>
    <%=user.getUserName()%>
</h1>
<div class="column">
    <a href = "<%=request.getContextPath()%>/admin/sletting?userID=<%=user.getUserID()%>">
        <button class="submit" type="submit" >Slett bruker</button>
    </a>

</div>
</body>
</html>
