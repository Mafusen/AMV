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
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>

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
        <td>
            <a href = "<%=request.getContextPath()%>/admin/redigerVerktoy?toolID=<%=product.getKey().getToolID()%>">
                <button name = submit type = submit value = submit >
                    Rediger
                </button>
            </a>
        </td>
        <td>
            <a href = "<%=request.getContextPath()%>/admin/slettVerktoy?toolID=<%=product.getKey().getToolID()%>">
                <button name = submit type = submit>
                    Slett
                </button>
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
