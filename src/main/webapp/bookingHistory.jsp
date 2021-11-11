<%@ page import="bacit.web.amv_models.BookingModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bacit.web.amv_models.ToolModel" %>
<%@ page import="bacit.web.amv_models.ToolBookingModel" %>
<%@ page import="javax.tools.Tool" %>
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
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <a class="logo" href = "<%=request.getContextPath()%>/frontpageServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="admin/Tools">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="logOut">Logg ut</a></li>
    </ul>
</nav>
<br><br><br><br>
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="bookingHistoryServlet">LeieHistorikk</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Aktive Bookinger</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Fremtidige Bookinger</a></li>
    </ul>

</nav>
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
    List<ToolBookingModel> toolBookings = (ArrayList<ToolBookingModel>) request.getAttribute("toolBookings");

    for(ToolBookingModel toolBooking : toolBookings){
%>
        <tr>
            <td>BILDE GÅR HER</td>
            <td>Produkt: <%=toolBooking.getToolName()%></td>
            <td>Leieperiode: <%=toolBooking.getStartDate() + " ---> " + toolBooking.getEndDate()%></td>
            <td><form action = "getBookingServlet"><button type = submit name = "bookingID" value = "<%=toolBooking.getBookingID()%>">Se Produkt</button></form></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <a></a>
        <a></a>
        <br><br>
    <%
        }
%>
    </table>
</div>

</body>
</html>
