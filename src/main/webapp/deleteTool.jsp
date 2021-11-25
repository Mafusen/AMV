<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.FileModel" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 18/11/2021
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type = "text/css">
    <title>Slett verktøy</title>
</head>

<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<br><br><br><br>
<%
    ToolModel tool = (ToolModel) request.getAttribute("tool");
    FileModel file = (FileModel) request.getAttribute("file");
%>
    <h1><%=tool.getToolName()%></h1>
    <a>
        <img src="<%=request.getContextPath()%>/fileDownloadServlet?FILE_ID=<%=file.getFileID()%>"
        alt="<%=tool.getToolName()%>" style="height: 250px" width="auto">
    </a>
    <div class="column">
        <a href = "<%=request.getContextPath()%>/admin/slett?toolID=<%=tool.getToolID()%>">
            <button class="submit" type="submit" >Slett verktøy</button>
        </a>

    </div>

</body>

</html>
