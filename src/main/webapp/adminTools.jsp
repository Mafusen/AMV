<%@ page import="bacit.web.amv_models.ToolFileModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href = "<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type = "text/css">
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
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Rapport</a></li>
    </ul>

</nav>

<div class="main">
    <br><br><h1>Side med verktoy</h1>
    <div>
        <a href = "<%=request.getContextPath()%>/admin/newTool">
        <button name = submit type = submit value = submit >Legg til nytt verktøy</button>
        </a>
</div>
</div>

<table>
    <%
        List<ToolFileModel> toolFiles = (ArrayList<ToolFileModel>) request.getAttribute("toolFiles");

        for(ToolFileModel toolFile : toolFiles){
    %>

    <tr>
        <td><img src="<%=request.getContextPath()%>/fileDownloadServlet?FILE_ID=<%=toolFile.getFileID()%>" alt="<%=toolFile.getToolName()%>" style="height: 250px" width="auto"></td>
        <td>Verktøy: <%=toolFile.getToolName()%></td>
        <td>Informasjon <%=toolFile.getToolInfo()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
