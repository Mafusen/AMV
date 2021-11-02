<%@ page import="bacit.web.amv_models.BookingModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bacit.web.amv_models.ToolModel" %>
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
    <link href = "navbar.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <a class="logo" href = productPage.jsp>
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="adminTools.jsp">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookings.jsp">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="login.jsp">Logg ut</a></li>
    </ul>
</nav>
<br><br><br><br>
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="bookingHistoryServlet">LeieHistorikk</a></li>
        <li class="nav-item"><a href="adminTools.jsp">Aktive Bookinger</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Fremtidige Bookinger</a></li>
    </ul>

</nav>
<div class="main">
    <br><br><h1>Min Leiehistorikk</h1>

<%

    List<BookingModel> bookings = (ArrayList<BookingModel>)request.getAttribute("bookings");
    List<ToolModel> tools = (List<ToolModel>) request.getAttribute("tools");
    for (BookingModel booking : bookings)
    {

%>
     <%
         for (ToolModel tool : tools)
         {
     %>
     <a>Produktnavn: <%=tool.getToolName()%></a>
     <a>Leieperiode: <%=booking.getStartDate() + " ---> " + booking.getEndDate()%></a>
<br><br>
    <%
        }
%>
    <%
        }
    %>

</div>

</body>
</html>
