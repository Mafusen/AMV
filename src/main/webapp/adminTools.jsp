<%@ page import="bacit.web.Models.FileModel" %>
<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>
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
<nav2 class="navbar2">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/report">Rapport</a></li>
    </ul>

</nav2>

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
        LinkedHashMap<ToolModel, FileModel> products = (LinkedHashMap<ToolModel, FileModel>) request.getAttribute("products");

        for(Map.Entry<ToolModel, FileModel> product : products.entrySet()){
    %>

    <tr>
        <td><img src="<%=request.getContextPath()%>/fileDownloadServlet?FILE_ID=<%=product.getValue().getFileID()%>" alt="<%=product.getKey().getToolName()%>" style="height: 250px" width="auto"></td>
        <td>Verktøy: <%=product.getKey().getToolName()%></td>
        <td>Informasjon <%=product.getKey().getToolInfo()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
