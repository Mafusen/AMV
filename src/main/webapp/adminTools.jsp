<%@ page import="bacit.web.amv_models.FileModel" %>
<%@ page import="bacit.web.amv_models.ToolFileModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:12
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
    <a class="logo" href = "frontpageServlet">
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

<div class="main">
    <br><br><h1>Side med verktoy</h1>
    <div>
        <a href = "newTool.jsp">
        <button name = submit type = submit value = submit >Legg til nytt verktøy</button>
        </a>
</div>
</div>

<table>
    <%
        List<ToolFileModel> toolFiles = (ArrayList<ToolFileModel>) request.getAttribute("toolFiles");

        for(ToolFileModel toolFile : toolFiles){
            //int fileIDint = tool.getFileID();
            //String fileID = Integer.toString(fileIDint);

    %>

    <tr>
        <td><img src="fileDownloadServlet?FILE_ID=<%=toolFile.getFileID()%>" alt="<%=toolFile.getToolName()%>" style="height: 250px" width="auto"></td>
        <td>Verktøy: <%=toolFile.getToolName()%></td>
        <td>Informasjon <%=toolFile.getToolInfo()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
