<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="bacit.web.Models.FileModel" %>
<%@ page import="bacit.web.DAOs.BookingDAO" %>
<%@ page import="java.sql.SQLException" %><%--
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
<%@include file="jspHelpers/navbarMain.jsp"%>>
<br><br><br><br>
<%@include file="jspHelpers/navbarBookings.jsp"%>
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
    <a><%=booking.getBookingID()%></a>
    <br>
    <%
        BookingDAO bDao = new BookingDAO();
        boolean isFuture = false;
        try {
            isFuture = bDao.checkFuture(booking.getBookingID());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(isFuture){
    %>
    <form action = "deleteBooking" method = "get"><button type = submit name="bookingID" value="<%=booking.getBookingID()%>">Slett kommende booking</button></form>
    <%
        }
    %>
</div>

</body>
</html>
