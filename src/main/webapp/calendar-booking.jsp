<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="bacit.web.Models.*" %>
<%@ page import="java.util.LinkedHashMap" %>
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
    FileModel file = (FileModel) request.getAttribute("file");
    ToolModel tool = (ToolModel) request.getAttribute("tool");

%>

<main class="container">
    <form action = "registerBooking" method = "get">
        <!-- Left Column / Headphones Image -->
        <div class="left-column">
            <img src="fileDownloadServlet?FILE_ID=<%=file.getFileID()%>" alt = "<%=tool.getToolName()%>" style="height: 200px; width: auto" >
        </div>

        <a>
            <input type = "hidden" id = "toolID" name = "toolID" value = "<%=tool.getToolID()%>">
        </a>

        <!-- Right Column -->
        <div class="right-column">

            <!-- Product Description -->
            <div class="product-description">
                <h1><%=tool.getToolName()%></h1>
                <p>
                    Informarsjon: <%=tool.getToolInfo()%>
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
                    <%=tool.getPrice()%>kr/dag
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

                <%
                    LinkedHashMap<UserModel, BookingModel> bookings = (LinkedHashMap<UserModel, BookingModel>) request.getAttribute("bookings");
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
<%-- Start date skal vær minst idag, og max om 3 måneder--%>
<script>
    let today = new Date().toISOString().split('T')[0];
    let date3m = new Date();
    date3m.setMonth(date3m.getMonth() + 3);
    date3m = date3m.toISOString().split('T')[0];
    document.getElementsByName("start")[0].setAttribute('min', today);
    document.getElementsByName("start")[0].setAttribute('max', date3m);
    document.getElementsByName("end")[0].setAttribute('max', date3m);
</script>

<%-- EndDate kan ikke vær mindre enn startDate--%>
<script>
    let fDate = document.querySelector('#start');
    let tDate = document.querySelector('#end');

    fDate.addEventListener('change', function() {
        tDate.min = this.value;
    });
</script>
</body>

</html>
