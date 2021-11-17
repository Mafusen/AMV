<%@ page import="bacit.web.Models.FileModel" %>
<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="java.util.*" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="bacit.web.DAOs.FileDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <meta name="AMV - Produktside" content="width=device-width, initial-scale=1">
    <link href="styles/productPage.css" rel="stylesheet">
    <link href="styles/navbar.css" rel="stylesheet">
    <title>AMV - Velferden</title>
</head>

<body>
<%@include file="jspHelpers/navbarMain.jsp"%>

<div class="main">
    <div class="search">
        <label>
            <input type="text" placeholder="Søk etter produkt..">
        </label>
    </div>

    <button type="button" class="collapsible"><strong>Aktive Bookinger</strong></button>
    <div class="content">
        <div class="activecontainer">

            <%
                LinkedHashMap<ToolModel, BookingModel> bookings = (LinkedHashMap<ToolModel, BookingModel>) request.getAttribute("bookings");

                for(Map.Entry<ToolModel, BookingModel> booking : bookings.entrySet()){
                    FileDAO fDao = new FileDAO();
                    int fileID = 0;
                    try {
                        fileID = fDao.getFileForTool(booking.getKey().getToolID()).getFileID();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
            %>
            <a class="products" href="passBooking?bookingID=<%=booking.getValue().getBookingID()%>">
                <img src="fileDownloadServlet?FILE_ID=<%=fileID%>" alt = "<%=booking.getKey().getToolName()%>">
                <div class="product">
                    <div class="productname"><%=booking.getKey().getToolName()%></div>
                    <div class="productinfo"><%=booking.getKey().getToolInfo()%></div>
                    <div class="productinfo"></div>
                </div>
            </a>
            <%
                }
            %>
        </div>
    </div>

    <button type="button" class="notcollapsible"><strong>Andre Produkter</strong></button>

    <div class="content">
        <div class="container">


            <%
                LinkedHashMap<ToolModel, FileModel> products = (LinkedHashMap<ToolModel, FileModel>) request.getAttribute("products");

                for (Map.Entry<ToolModel, FileModel> product : products.entrySet()) {

            %>
            <a class="products" href="passProduct?toolID=<%=product.getKey().getToolID()%>">
                <img src="fileDownloadServlet?FILE_ID=<%=product.getValue().getFileID()%>" alt = "<%=product.getKey().getToolName()%>">
                <div class="product">
                    <div class="productname"><%=product.getKey().getToolName()%></div>
                    <div class="productinfo">Info: <%=product.getKey().getToolInfo()%></div>
                    <div class="productprice">Pris per dag: <%=product.getKey().getPrice()%></div>
                </div>
            </a>
            <%
                }
            %>

        </div>
    </div>


    <script>
        var coll = document.getElementsByClassName("collapsible");
        var i;
        for (i = 0; i < coll.length; i++) {
            coll[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var content = this.nextElementSibling;
                if (content.style.display === "block") {
                    content.style.display = "none";
                } else {
                    content.style.display = "block";
                }
            });
        }
    </script>

    <script>
        var coll = document.getElementsByClassName("collapsibleinfo");
        var i;

        for (i = 0; i < coll.length; i++) {
            coll[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var content = this.nextElementSibling;
                if (content.style.maxHeight){
                    content.style.maxHeight = null;
                } else {
                    content.style.maxHeight = content.scrollHeight + "px";
                }
            });
        }
    </script>

</div>
</body>
</html>