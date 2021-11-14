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
    <link href="<%=request.getContextPath()%>/styles/newTool.css" rel="stylesheet" type = "text/css">
    <link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
    <title>Title</title>
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
<br><br><br><br>
<nav2 class="navbar2">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/report">Rapport</a></li>
    </ul>

</nav2>
<form action = "<%=request.getContextPath()%>/admin/registerTool" method = "post" enctype="multipart/form-data">
<div class="newtooltitle">
    <br><br>
    <h1>Legg til nytt verktøy:</h1>
    <hr>
</div>

    <div class="toolform">
        <div class = "inputtext">
    <label for="name"><b>Navn på verktøy: </b></label>
        </div>
        <div>

        <input class = "input1" type="text" name="name" id="name" placeholder="Skriv inn navn på verktøy">
        </div>
        <br>
    </div>

    <br>

    <div class = "toolform">
        <div class = "inputtext">
            <label for="info"><b>Info om verktøy:</b></label>
        </div>

        <div>
            <input class="input2" type="text" name="info" id="info" placeholder="Skriv info om verktøy">
        </div>
        <br>
    </div>

    <br>

    <div class="toolform">
        <div class="inputtext">
            <label for="price"><b>Pris: </b></label>
        </div>

        <div>
            <input class="input3" type="text" name="price" id="price" placeholder="Skriv pris på verktøy">
        </div>
        <br>
    </div>

    <br>

    <div class="toolform">
        <div class="inputtext">
            <label for="file"><b>Last opp bilde:</b></label>
        </div>
        <div>
            <input type="file" name="file" id = "file"/>
        </div>
        <br>
    </div>

    <br>
    <br>

    <div class="toolform">

        <button class="button2" type="reset" value="Reset alle felter">Reset alle felter</button>

        <a href = "admin/Tools">
            <button class="button1" type="submit" value="register">Registrer nytt verktøy</button>
        </a>

    </div>

</form>
</body>
</html>
