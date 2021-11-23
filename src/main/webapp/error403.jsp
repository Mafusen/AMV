<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 12/11/2021
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type = "text/css">
    <link href = "<%=request.getContextPath()%>/styles/errorPage.css" rel="stylesheet" type = "text/css">
    <title>Error 403</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<p> Du har ikke tilgang til siden du forsøker å åpne.
    Kontakt Admin for hjelp.</p>

<div>
    <input type="button" value="Tilbake" onclick="history.go(-1)">
</div>

</body>
</html>
