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
<nav class="navbar">
    <a class="logo" href = "<%=request.getContextPath()%>/frontpageServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="<%=request.getContextPath()%>/logOut">Logg ut</a></li>
    </ul>
</nav>
<p> Du har ikke tilgang til siden du forsøker å åpne.
    Kontakt Admin for hjelp.</p>

<div>
    <input type="button" value="Tilbake" onclick="history.go(-1)">
</div>

</body>
</html>
