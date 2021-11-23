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
        <link href="styles/navbar.css" rel="stylesheet" type="text/css">
        <link href="styles/calendar.css" type="text/css" rel="stylesheet">
        <title>Booking Side</title>

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>>

<%
    FileModel file = (FileModel) request.getAttribute("file");
    ToolModel tool = (ToolModel) request.getAttribute("tool");
%>
<main class="columns">
    <div class="columnleft">
        <form action = "registerBooking" method = "get">

            <div class="left-column">
                <img src="fileDownloadServlet?FILE_ID=<%=file.getFileID()%>" alt = "<%=tool.getToolName()%>">
            </div>

            <a>
                <input type = "hidden" id = "toolID" name = "toolID" value = "<%=tool.getToolID()%>">
            </a>

            <div class="product">
                <div class="product-name">
                    <p><%=tool.getToolName()%></p>
                </div>
                <div class="product-info">
                    Informasjon: <%=tool.getToolInfo()%>
                </div>

                <div class="product-price">
                    <p>
                        <%=tool.getPrice()%>kr/dag
                    </p>
                </div>

                <div class="calendar">
                    <div class="startdate">
                        <label for="start">Startdato:</label>
                        <input type="date" id="start" name="start" required>
                    </div>
                    <div>
                        <label for="end">Sluttdato:</label>
                        <input type="date" id="end" name="end" required>
                    </div>

                </div>

                <div class="buttons">
                    <button type="submit" class="btn-success">Book</button>
                    <button type="button" class="btn-cancel" value = "Avbryt" onclick="history.go(-1)">Avbryt</button>
                </div>

            </div>
        </form>
    </div>
    <div class="columnright">
        <table class="table">
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