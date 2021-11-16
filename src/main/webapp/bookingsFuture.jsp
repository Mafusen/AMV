<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/11/2021
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "styles/navbar.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<nav2 class="navbar2">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">LeieHistorikk</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/aktiveBookinger">Aktive Bookinger</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/fremtidigeBookinger">Fremtidige Bookinger</a></li>
    </ul>

</nav2>
<div class="main">
    <br><br><h1>Min Leiehistorikk</h1>
    <form action = "bookingHistoryServlet" method = "get">
        <label>
            <input type = "text" placeholder="produktnavn..." name = "search">
        </label>
        <button type = "submit">SØK</button>
    </form>

    <table>
        <%
            LinkedHashMap<ToolModel, BookingModel> bookings = (LinkedHashMap<ToolModel, BookingModel>) request.getAttribute("bookings");

            for(Map.Entry<ToolModel, BookingModel> booking : bookings.entrySet()){
        %>
        <tr>
            <td>BILDE GÅR HER</td>
            <td>Produkt: <%=booking.getKey().getToolName()%></td>
            <td>Leieperiode: <%=booking.getValue().getStartDate() + " ---> " + booking.getValue().getEndDate()%></td>
            <td>Kommentar: <%=booking.getValue().getComment()%></td>
            <td><form action = "getBookingServlet"><button type = submit name = "bookingID" value = "<%=booking.getValue().getBookingID()%>">Se Produkt</button></form></td>
        </tr>
        <br><br>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
