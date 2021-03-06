<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="bacit.web.Models.FileModel" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 03/11/2021
  Time: 20:48
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

        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">LeieHistorikk</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Aktive Bookinger</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Fremtidige Bookinger</a></li>
    </ul>

</nav2>
<br><br><br><br>
<%
    ToolModel tool = (ToolModel) request.getAttribute("tool");
    BookingModel booking = (BookingModel) request.getAttribute("booking");
    FileModel file = (FileModel) request.getAttribute("file");
    String deliveryStatus = "Ikke levert!";

    if (booking.getIsDelivered()){
        deliveryStatus = "Levert";
    }
%>
<div class="main">
    <h1><%=tool.getToolName()%></h1>
    <a><img src="fileDownloadServlet?FILE_ID=<%=file.getFileID()%>" alt = "<%=tool.getToolName()%>"></a>
    <a>Info: <%=tool.getToolInfo()%></a>
    <a>Pris per dag: <%=tool.getPrice()%></a>
    <a>Startdato: <%=booking.getStartDate()%></a>
    <a>Sluttdato: <%=booking.getEndDate()%></a>
    <a>Kommentar: <%=booking.getComment()%></a>
    <a>Leveringsstatus: <%=deliveryStatus%></a>
    <a>Total kostnad: <%=booking.getTotalPrice()%></a>
</div>

</body>
</html>
