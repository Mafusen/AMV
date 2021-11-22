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
    <link href="<%=request.getContextPath()%>/styles/adminTools.css" rel="stylesheet">
    <title>AMV - Verktøyoversikt</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>

<div class="main">
    <br><h1>Verktøyoversikt</h1>
    <form action = "<%=request.getContextPath()%>/admin/Tools" method = "get">
        <div class="search">
            <label>
                <input type="text" name = "search" id = "search" placeholder="Søk etter produkt..">

            </label>
        </div>
    </form>
    <div>
        <a href = "<%=request.getContextPath()%>/admin/newTool">
        <button class="button1" name = submit type = submit value = submit >Legg til nytt verktøy</button>
        </a>
</div>
</div>
<br>

<table>
    <%
        LinkedHashMap<ToolModel, FileModel> products = (LinkedHashMap<ToolModel, FileModel>) request.getAttribute("products");

        for(Map.Entry<ToolModel, FileModel> product : products.entrySet()){
    %>
    <a class="products" href="<%=request.getContextPath()%>/admin/redigerVerktoy?toolID=<%=product.getKey().getToolID()%>">
        <img src="<%=request.getContextPath()%>/fileDownloadServlet?FILE_ID=<%=product.getValue().getFileID()%>" alt = "<%=product.getKey().getToolName()%>">
        <div class="product">
            <div class="productname"><%=product.getKey().getToolName()%></div>
            <div class="producttitles">Info:</div>
            <div class="productinfo"> <%=product.getKey().getToolInfo()%></div>
        </div>
    </a>
    <%
        }
    %>
</table>

</body>
</html>
