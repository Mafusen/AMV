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
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>

<%@include file="jspHelpers/navbarAdmin.jsp"%>

<form action = "<%=request.getContextPath()%>/admin/registerTool" method = "post" enctype="multipart/form-data">

<div class="main">
    <br>
    <h1>Legg til nytt verktøy:</h1>
</div>
<br>

    <div class="toolform">
        <div class = "inputtext">
            <label for="name" style="margin-top: 10px"><b>Navn på verktøy: </b></label>
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