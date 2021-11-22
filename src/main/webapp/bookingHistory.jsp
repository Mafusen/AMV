<%@ page import="bacit.web.Models.BookingModel" %>
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
    <link href = "styles/navbar.css" rel="stylesheet" type = "text/css">
    <link href = "styles/bookingHistory.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarBookings.jsp"%>
<div class="main">
    <br><br><h1>Min Leiehistorikk</h1>
    <form action = "bookingHistoryServlet" method = "get">
        <label>
            <input type = "text" placeholder="produktnavn..." name = "search">
        </label>
        <button class="button1" type = "submit">SØK</button>
    </form>

    <table id="bookings">
<%--        <tr>
            <td>Bilde</td>
            <td>Produkt</td>
            <td>Leieperiode</td>
            <td>Kommentar</td>
        </tr>--%>
<%
    LinkedHashMap<ToolModel, BookingModel> bookings = (LinkedHashMap<ToolModel, BookingModel>) request.getAttribute("bookings");

    for(Map.Entry<ToolModel, BookingModel> booking : bookings.entrySet()){
%>
        <a class="bookings" href="getBookingServlet">
            <img src="pic.jpg">
            <div class="booking">
                <div class="productname"><%=booking.getKey().getToolName()%></div>
                <div class="bookingdates">Til: <%=booking.getValue().getStartDate()%>  <br> Fra: <%=booking.getValue().getEndDate()%></div>
                <div class="bookingcmnt"><span class="bookingtext">Kommentar:  </span><%=booking.getValue().getComment()%></div>
                <div class="bookingprice"><span class="bookingtext">Pris: </span><%=booking.getValue().getTotalPrice()%></div>
            </div>
        </a>
    <%
        }
%>
    </table>
</div>

</body>
</html>
