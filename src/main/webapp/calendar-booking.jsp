<%@ page import="bacit.web.Models.ToolFileModel" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="bacit.web.Models.ToolBookingModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="bacit.web.Models.UserModel" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produkt Side</title>

    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link href="styles/navbar.css" rel="stylesheet" type="text/css">
        <link href="styles/calendar.css" type="text/css" rel="stylesheet">
        <title>Produkt Side</title>

<body>

<nav class="navbar">
    <a class="logo" href= "<%=request.getContextPath()%>/frontpageServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="<%=request.getContextPath()%>/logOut">Logg ut</a></li>
    </ul>
</nav>

<%
    ToolFileModel product = (ToolFileModel) request.getAttribute("product");
%>

<main class="container">
    <form action = "registerBooking" method = "get">
        <!-- Left Column / Headphones Image -->
        <div class="left-column">
            <img src="fileDownloadServlet?FILE_ID=<%=product.getFileID()%>" alt = "<%=product.getToolName()%>" style="height: 200px; width: auto" >
        </div>

        <a>
            <input type = "hidden" id = "toolID" name = "toolID" value = "<%=product.getToolID()%>">
        </a>

        <!-- Right Column -->
        <div class="right-column">

            <!-- Product Description -->
            <div class="product-description">
                <h1><%=product.getToolName()%></h1>
                <p>
                    Informarsjon: <%=product.getToolInfo()%>
                </p>
            </div>
            <!-- Product Pricing -->
            <div class="calendar">
                <div>
                    <label for="start">Start Dato:</label>
                    <input type="date" id="start" name="start" required>
                </div>
                <div>
                    <label for="end">Slutt Dato:</label>
                    <input type="date" id="end" name="end" required>
                </div>

            </div>

            <div class="product-price">
                <p>
                    <%=product.getPrice()%>kr/dag
                </p>
            </div>


            <div class="buttons">
                <button type="submit" class="btn btn-success">Book</button>
                <button type="button" class="btn btn-danger" value = "Avbryt" onclick="history.go(-1)">Avbryt</button>
            </div>

        </div>

        <div>
            <table class="table" style=text-align:center border=1 width=50% height=10%>
                <thead>
                <tr>
                    <th>Booket av</th>
                    <th>Mobil</th>
                    <th>Fra</th>
                    <th>Til</th>
                </tr>
                </thead>
                <tbody>

                <!-- toolID skal egentlig vært product.getToolID -->
                <%
                    HashMap<UserModel, BookingModel> bookings = (HashMap<UserModel, BookingModel>) request.getAttribute("bookings");
                    for(Map.Entry<UserModel, BookingModel> booking : bookings.entrySet()){
                %>
                <tr>
                    <td><%=booking.getKey().getFirstName() +" "+ booking.getKey().getLastName()%></td>
                    <td><%=booking.getKey().getPhone()%></td>
                    <td><%=booking.getValue().getStartDate()%></td>
                    <td><%=booking.getValue().getEndDate()%></td>

                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </form>



</main>
<script>
    var today = new Date().toISOString().split('T')[0];
    document.getElementsByName("start")[0].setAttribute('min', today);
</script>
<script>
    var endDate = new Date();
    var dd = endDate.getDate();
    var mm = endDate.getMonth()+4; //January is 0 so need to add 1 to make it 1!
    var yyyy = endDate.getFullYear();
    if(dd<10){
        dd='0'+dd
    }
    if(mm<10){
        mm='0'+mm
    }
    endDate = yyyy+'-'+mm+ '-'+dd;
    document.getElementById("end").setAttribute("min", endDate);
</script>
</body>

</html>