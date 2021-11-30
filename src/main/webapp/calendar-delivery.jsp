<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="bacit.web.Models.FileModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <link href="styles/navbar.css" rel="stylesheet" type="text/css">
  <link href="styles/calendar.css" type="text/css" rel="stylesheet">
  <title>Lever verktøy</title>
</head>

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>

<main class="container">

    <%
      BookingModel booking = (BookingModel) request.getAttribute("booking");
      ToolModel tool = (ToolModel) request.getAttribute("tool");
      FileModel file = (FileModel) request.getAttribute("file");
    %>


    <div class="left-column-deliver">
        <div class="left-column">
            <img src="fileDownloadServlet?FILE_ID=<%=file.getFileID()%>" alt="<%=tool.getToolName()%>">
        </div>
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
      </div>
    </div>


    <div class="right-column-deliver">
      <form action = "deliverBooking" method = "get">
      <div class="comment">
        <div>
          <label for="comment">Kommentar</label>
        </div>
        <textarea id="comment" name="comment" rows="10" cols="60">
        </textarea>
      </div>

      <a>
        <input type = "hidden" id = "bookingID" name = "bookingID" value = "<%=booking.getBookingID()%>">
      </a>

      <div class="buttons">
        <button type="submit" class="btn-success">Lever</button>
      </div>
      </form>
    </div>

</main>
</body>

</html>
