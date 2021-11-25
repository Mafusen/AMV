<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="bacit.web.Models.FileModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="styles/navbar.css" rel="stylesheet" type="text/css">
  <link href="styles/calendar.css" type="text/css" rel="stylesheet">
  <title>Produkt Side</title>
</head>

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>

<main class="container">

    <%
      BookingModel booking = (BookingModel) request.getAttribute("booking");
      ToolModel tool = (ToolModel) request.getAttribute("tool");
      FileModel file = (FileModel) request.getAttribute("file");
    %>

    <div class="left-column">
      <img src="fileDownloadServlet?FILE_ID=<%=file.getFileID()%>" alt="<%=tool.getToolName()%>">
    </div>

    <div class="right-column">

      <div class="product-description">
        <h1><%=tool.getToolName()%></h1>
        <p><%=tool.getToolInfo()%></p>
      </div>

      <div class="product-price">
        <p><%=tool.getPrice()%> kr</p>
      </div>

      <form action = "deliverBooking" method = "get">
      <div class="comment">
        <div>
          <label for="kommentar">Kommentar</label>
        </div>
        <input id="kommentar" name="kommentar" type="text" placeholder="Din kommentar..." size="35">
      </div>

      <a>
        <input type = "hidden" id = "bookingID" name = "bookingID" value = "<%=booking.getBookingID()%>">
      </a>

      <div class="buttons">
        <button type="submit" class="btn btn-danger" id="divide">Lever</button>
      </div>
      </form>

    </div>

</main>
<script>
  var today = new Date().toISOString().split('T')[0];
  document.getElementsByName("startDate")[0].setAttribute('min', today);
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
  document.getElementById("endDate").setAttribute("min", endDate);
</script>
</body>

</html>
