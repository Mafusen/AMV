<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.BookingModel" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 19/11/2021
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Levert</title>
    <link href="styles/navbar.css" rel="stylesheet" type="text/css">
    <link href="styles/calendar.css" type="text/css" rel="stylesheet">
</head>

<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<br><br><br><br>
<body>
<%
    ToolModel tool = (ToolModel) request.getAttribute("tool");
    BookingModel booking = (BookingModel) request.getAttribute("finalBooking");
%>
<h1>Booking Levert!</h1>
<a>
    <%= tool.getToolName()%>
</a>
<a>
    <%= booking.getStartDate()%>
</a>
<a>
    <%= booking.getEndDate()%>
</a>
<a>
    <%= booking.getTotalPrice()%>
</a>

</body>
</html>
