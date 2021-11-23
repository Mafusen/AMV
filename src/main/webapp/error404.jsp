<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 14/11/2021
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type = "text/css">
    <link href = "<%=request.getContextPath()%>/styles/errorPage.css" rel="stylesheet" type = "text/css">
    <title>Error Page</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<H1> 404</H1>
<p> Vi kan dessverre ikke finne siden du leter etter...</p>

<div>
    <input type="button" value="Gå til forsiden" onclick="window.location.href= '<%=request.getContextPath()%>/frontpageServlet'">
</div>

</body>
</html>
