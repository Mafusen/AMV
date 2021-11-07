<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 04/11/2021
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <li class="nav-item"><a href="getToolsServlet">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="logInServlet">Logg ut</a></li>
    </ul>
</nav>
<br><br><br><br>
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="getUserServlet">Ansatte</a></li>
        <li class="nav-item"><a href="getToolsServlet">Verktoy</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Rapport</a></li>
    </ul>

</nav>
<form action = "registerToolServlet" method = "post" enctype="multipart/form-data">
<div class="main">
    <br><br>
    <h1>Nytt verktøy:</h1>
    <hr>
    <label for="name"><b>Navn på verktøy: </b></label>
    <input type="text" name="name" id="name" placeholder="Skriv inn navn på verktøy">
    <br>

    <label for="info"><b>Info om verktøy:</b></label>
    <input type="text" name="info" id="info" placeholder="Skriv inn info om verktøy">
    <br>

    <label for="price"><b>Pris: </b></label>
    <input type="text" name="price" id="price" placeholder="Skriv inn pris på verktøy">
    <br>


    <label for="file"><b>Last opp bilde</b></label>
    <input type="file" name="file" id = "file"/>

    <br>
    <a href = "getToolsServlet">
    <button type="submit" class = "register">Registrer nytt verktøy</button>
    </a>

</div>
</form>
</body>
</html>
