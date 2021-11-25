<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.FileModel" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 18/11/2021
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/newUser.css">
    <title>Title</title>
</head>
<link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/styles/newUser.css" rel="stylesheet" type="text/css">
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<br><br><br><br>

<%
    ToolModel tool = (ToolModel) request.getAttribute("tool");
    FileModel file = (FileModel) request.getAttribute("file");
%>

<h1>Rediger verktøy: <%=tool.getToolName()%></h1>

<main class="container">


        <div class="column">
            <form action="<%=request.getContextPath()%>/admin/endreVerktoy?toolID=<%=tool.getToolID()%>" method="post" enctype="multipart/form-data">
            <div class="inputtext">
                <label for="name">Verktøynavn: </label>
            </div>
            <div>
                <input class="input" type="text" name="name" id="name" value = "<%=tool.getToolName()%>" required placeholder="Verktøynavn">
            </div>

            <div class="inputtext">
                <label for="info">Informasjon: </label>
            </div>
            <div>
                <input class="input" type="text" name="info" id="info" value = "<%=tool.getToolInfo()%>" required placeholder="Verktøynavn">
            </div>

            <div class="inputtext">
                <label for="price">Pris per dag: </label>
            </div>
            <div>
                <input class="input" type="text" name="price" id="price" value = "<%=tool.getPrice()%>" required placeholder="Verktøynavn">
            </div>

            <div class="toolform">
                <div class="inputtext">
                    <label for="file"><b>Endre bilde:</b></label>
                </div>
                <div>
                    <input type="file" name="file" id = "file" value = "<%=file.getContents()%>"/>
                </div>
                <br>
            </div>

            <div class="column">
                <a href = "admin/Tools">
                    <button class="submit" type="submit" >Lagre endringer</button>
                </a>
            </div>
            </form>
            <div class="column">
                <a href = "<%=request.getContextPath()%>/admin/slettVerktoy?toolID=<%=tool.getToolID()%>">
                    <button name = submit type = submit>
                        Slett verktøy
                    </button>
                </a>
            </div>
        </div>

</main>

</body>
</html>
