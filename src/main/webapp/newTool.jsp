<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 04/11/2021
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="fileUpload.jsp"%>
<html>
<head>
    <link href = "styles/navbar.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <a class="logo" href = productPage.jsp>
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="adminTools.jsp">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="logInServlet">Logg ut</a></li>
    </ul>
</nav>
<br><br>
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="getUserServlet">Ansatte</a></li>
        <li class="nav-item"><a href="adminTools.jsp">Verktoy</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Rapport</a></li>
    </ul>

</nav>
<form action = # method = #>
<div class="main">
    <br><br><h1>Nytt verktøy:</h1>
    <b>Navn på verktøy: </b>
    <label for="ToolName"></label><input type="text" name="ToolName" id="ToolName" placeholder="">
    <br>
    <b>Info om verktøy: </b>
    <label for="ToolInfo"></label><input type="text" name="ToolInfo" id="ToolInfo" placeholder="">
    <br>
    <b>Pris: </b>
    <label for="Price"></label><input type="text" name="Price" id="Price" placeholder="">
    <br>
    <%@include file="fileUpload.jsp"%>
    <br>
    <a>
    <input type='submit' value='registerTool'/>
    </a>
</div>
</form>
</body>
</html>
